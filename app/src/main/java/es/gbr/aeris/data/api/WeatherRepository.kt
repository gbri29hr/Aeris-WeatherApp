package es.gbr.aeris.data.api

import android.util.Log
import es.gbr.aeris.model.database.dao.WeatherDao
import es.gbr.aeris.model.database.entities.CiudadEntidad
import es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad
import es.gbr.aeris.model.database.entities.PrediccionHorasEntidad
import es.gbr.aeris.model.database.entities.TiempoActualEntidad
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Repositorio que obtiene datos de OpenWeather y los guarda en la base de datos
class OpenWeatherRepository(private val weatherDao: WeatherDao) {

    // Coordenadas de ciudades
    private val ciudadesData = mapOf(
        "Ciudad Real" to Triple(38.9863, -3.9271, ""),
        "Madrid" to Triple(40.4168, -3.7038, ""),
        "Barcelona" to Triple(41.3851, 2.1734, ""),
        "Valencia" to Triple(39.4699, -0.3763, ""),
        "Sevilla" to Triple(37.3891, -5.9845, ""),
        "Zaragoza" to Triple(41.6488, -0.8891, ""),
        "Málaga" to Triple(36.7213, -4.4214, ""),
        "Murcia" to Triple(37.9922, -1.1307, ""),
        "Palma" to Triple(39.5696, 2.6502, ""),
        "Las Palmas" to Triple(28.1248, -15.4300, ""),
        "Bilbao" to Triple(43.2630, -2.9350, ""),
        "Alicante" to Triple(38.3452, -0.4810, ""),
        "Córdoba" to Triple(37.8882, -4.7794, ""),
        "Valladolid" to Triple(41.6521, -4.7286, ""),
        "Vigo" to Triple(42.2406, -8.7207, ""),
        "Gijón" to Triple(43.5322, -5.6611, ""),
        "Granada" to Triple(37.1773, -3.5986, ""),
        "A Coruña" to Triple(43.3623, -8.4115, ""),
        "Vitoria" to Triple(42.8467, -2.6731, ""),
        "Elche" to Triple(38.2699, -0.6983, ""),
        "Oviedo" to Triple(43.3614, -5.8493, ""),
        "Santander" to Triple(43.4623, -3.8099, ""),
        "Pamplona" to Triple(42.8125, -1.6458, ""),
        "Cartagena" to Triple(37.6256, -0.9960, ""),
        "Cádiz" to Triple(36.5271, -6.2886, "")
    )

    // Sincronizar ciudad: OpenWeather completo
    suspend fun sincronizarCiudad(nombreCiudad: String): Boolean {
        val cityData = ciudadesData[nombreCiudad] ?: return false
        val (lat, lon, _) = cityData

        return try {
            Log.d("WeatherRepo", "Sincronizando $nombreCiudad")

            // OpenWeather: temperaturas, descripciones, predicciones, UV, precipitación
            val climaActual = OpenWeatherClient.obtenerClimaActual(lat, lon)
            val prediccionOpenWeather = OpenWeatherClient.obtenerPrediccion5Dias(lat, lon)
            val indiceUV = OpenWeatherClient.obtenerIndiceUV(lat, lon)

            if (climaActual != null) {
                val ciudad = buscarOCrearCiudad(nombreCiudad, lat, lon)
                val idCiudad = ciudad.idCiudad

                // Guardar tiempo actual (OpenWeather completo)
                val tiempoActual = convertirTiempoActual(idCiudad, climaActual, prediccionOpenWeather, indiceUV)
                weatherDao.insertarTiempoActual(tiempoActual)

                // Guardar predicción horaria (cada 3h)
                weatherDao.eliminarHorasPorCiudad(idCiudad)
                prediccionOpenWeather?.let { forecast ->
                    val horas = convertirPrediccionHorariOpenWeather(idCiudad, forecast)
                    weatherDao.insertarListaHoras(horas)
                }

                // Guardar predicción diaria
                weatherDao.eliminarDiasPorCiudad(idCiudad)
                prediccionOpenWeather?.let { forecast ->
                    val dias = convertirPrediccionDiaria(idCiudad, forecast)
                    weatherDao.insertarListaDias(dias)
                }

                Log.d("WeatherRepo", "$nombreCiudad sincronizada exitosamente")
                true
            } else {
                Log.e("WeatherRepo", "$nombreCiudad: OpenWeather falló")
                false
            }
        } catch (e: Exception) {
            Log.e("WeatherRepo", "Error $nombreCiudad: ${e.message}")
            false
        }
    }

    // Sincronizar por ID
    suspend fun sincronizarCiudadPorId(idCiudad: Int): Boolean {
        return try {
            val ciudad = weatherDao.obtenerCiudadPorId(idCiudad)
            if (ciudad != null) {
                sincronizarCiudad(ciudad.nombre)
            } else {
                sincronizarCiudad("Ciudad Real")
            }
        } catch (e: Exception) {
            false
        }
    }

    // Sincronizar todas las ciudades
    suspend fun sincronizarDatosBasicos(excluirIdCiudad: Int? = null): Boolean {
        var exitoAlguna = false

        ciudadesData.keys.forEach { nombreCiudad ->
            try {
                val ciudad = weatherDao.buscarCiudadPorNombre(nombreCiudad)
                if (excluirIdCiudad == null || ciudad?.idCiudad != excluirIdCiudad) {
                    if (sincronizarCiudad(nombreCiudad)) {
                        exitoAlguna = true
                    }
                }
            } catch (e: Exception) {
                Log.e("HybridWeather", "Error sincronizando $nombreCiudad: ${e.message}")
            }
        }

        return exitoAlguna
    }

    // Buscar o crear ciudad
    private suspend fun buscarOCrearCiudad(nombre: String, lat: Double, lon: Double): CiudadEntidad {
        val existente = weatherDao.buscarCiudadPorNombre(nombre)
        if (existente != null) return existente

        val nueva = CiudadEntidad(nombre = nombre, latitud = lat, longitud = lon)
        val id = weatherDao.insertarCiudad(nueva)
        return nueva.copy(idCiudad = id.toInt())
    }

    // Convertir tiempo actual: OpenWeather completo
    private fun convertirTiempoActual(
        idCiudad: Int,
        climaActual: OpenWeatherCurrentResponse,
        prediccion: OpenWeatherForecastResponse?,
        indiceUVResponse: OpenWeatherUVResponse?
    ): TiempoActualEntidad {
        val condicion = climaActual.weather.firstOrNull()

        // OPENWEATHER: Temperaturas máx/mín del día actual y futuro
        // Usar todas las predicciones disponibles desde ahora en adelante
        val ahora = System.currentTimeMillis() / 1000
        val prediccionesDesdeAhora = prediccion?.list?.filter { it.dt >= ahora } ?: emptyList()

        // Si hay predicciones, usar las primeras 8 (24 horas) para calcular máx/mín del día
        // Si no hay predicciones, usar los valores actuales
        val tempMax = if (prediccionesDesdeAhora.isNotEmpty()) {
            prediccionesDesdeAhora.take(8).maxOfOrNull { it.main.tempMax } ?: climaActual.main.tempMax
        } else {
            climaActual.main.tempMax
        }
        
        val tempMin = if (prediccionesDesdeAhora.isNotEmpty()) {
            prediccionesDesdeAhora.take(8).minOfOrNull { it.main.tempMin } ?: climaActual.main.tempMin
        } else {
            climaActual.main.tempMin
        }

        // Probabilidad de precipitación: OpenWeather
        // pop viene como 0.0 a 1.0, lo convertimos a porcentaje
        val probabilidadLluvia = prediccion?.list?.firstOrNull()?.let { 
            (it.pop * 100).toInt()
        } ?: 0

        // Índice UV real de OpenWeather
        val uvIndice = indiceUVResponse?.value ?: 0.0

        return TiempoActualEntidad(
            idCiudadFk = idCiudad,
            temperatura = climaActual.main.temp,
            descripcion = condicion?.description?.replaceFirstChar { it.uppercase() } ?: "Despejado",
            codigoIcono = mapearIconoOpenWeather(condicion?.icon ?: "01d"),
            tempAlta = tempMax,
            tempBaja = tempMin,
            humedad = climaActual.main.humidity.toDouble(),
            vientoVelocidad = climaActual.wind.speed * 3.6,
            uvIndice = uvIndice,
            precipitacion = probabilidadLluvia
        )
    }

    // Predicción horaria desde OpenWeather (cada 3h)
    private fun convertirPrediccionHorariOpenWeather(
        idCiudad: Int,
        prediccion: OpenWeatherForecastResponse
    ): List<PrediccionHorasEntidad> {
        val formatoHora = SimpleDateFormat("HH:00", Locale.getDefault())
        val ahora = System.currentTimeMillis() / 1000

        return prediccion.list
            .filter { it.dt > ahora }
            .take(8)
            .map { item ->
                PrediccionHorasEntidad(
                    idCiudadFk = idCiudad,
                    hora = formatoHora.format(Date(item.dt * 1000)),
                    temperatura = item.main.temp,
                    codigoIcono = mapearIconoOpenWeather(item.weather.firstOrNull()?.icon ?: "01d")
                )
            }
    }

    // Convertir predicción diaria OpenWeather (máximo 5 días)
    private fun convertirPrediccionDiaria(
        idCiudad: Int,
        prediccion: OpenWeatherForecastResponse
    ): List<PrediccionDiariaEntidad> {
        val formatoDia = SimpleDateFormat("EEEE", Locale.getDefault())
        val formatoFecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        
        // Obtener fecha de mañana (excluir día actual)
        val manana = Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)
        val fechaManana = formatoFecha.format(manana)

        // Agrupar por día y tomar SOLO los 5 primeros días completos desde mañana
        val porDia = prediccion.list
            .filter { formatoFecha.format(Date(it.dt * 1000)) >= fechaManana }
            .groupBy { formatoFecha.format(Date(it.dt * 1000)) }
            .toList()
            .take(5)  // Limitar a exactamente 5 días

        return porDia.map { (fecha, items) ->
            val fechaDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(fecha)!!
            val nombreDia = formatoDia.format(fechaDate).replaceFirstChar { it.uppercase() }

            PrediccionDiariaEntidad(
                idCiudadFk = idCiudad,
                nombreDia = nombreDia,
                tempAlta = items.maxOfOrNull { it.main.tempMax } ?: 0.0,
                tempBaja = items.minOfOrNull { it.main.tempMin } ?: 0.0,
                codigoIcono = mapearIconoOpenWeather(items[items.size / 2].weather.firstOrNull()?.icon ?: "01d")
            )
        }
    }

    // Mapear iconos OpenWeather
    private fun mapearIconoOpenWeather(iconCode: String): String {
        return when {
            iconCode.startsWith("01") -> "ic_sol"
            iconCode.startsWith("02") -> "ic_parcialmente_nublado"
            iconCode.startsWith("03") -> "ic_nublado"
            iconCode.startsWith("04") -> "ic_nublado"
            iconCode.startsWith("09") -> "ic_lluvia"
            iconCode.startsWith("10") -> "ic_lluvia"
            iconCode.startsWith("11") -> "ic_tormenta"
            iconCode.startsWith("13") -> "ic_nieve"
            iconCode.startsWith("50") -> "ic_nublado"
            else -> "ic_parcialmente_nublado"
        }
    }

}
