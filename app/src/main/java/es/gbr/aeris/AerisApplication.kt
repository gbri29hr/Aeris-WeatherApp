package es.gbr.aeris

import android.app.Application
import android.util.Log
import es.gbr.aeris.data.api.OpenWeatherRepository
import es.gbr.aeris.model.DatosCompartidos
import es.gbr.aeris.model.database.database.AppDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Clase Application que inicializa la BD y sincroniza datos al arrancar
class AerisApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        Log.d("AerisApp", "Iniciando app")
        
        // Inicializar DatosCompartidos para persistir ciudades
        DatosCompartidos.inicializar(this)
        DatosCompartidos.cargarCiudadSeleccionada()

        // Sincronización inicial con OpenWeather en segundo plano
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val weatherDao = AppDataBase.obtenerBaseDeDatos(applicationContext).weatherDao()
                val weatherRepository = OpenWeatherRepository(weatherDao)

                Log.d("AerisApp", "Limpiando ciudades duplicadas...")
                
                // Eliminar ciudades duplicadas de la base de datos
                weatherDao.eliminarCiudadesDuplicadas()
                
                Log.d("AerisApp", "Sincronizando datos iniciales...")

                // Sincronizar solo las ciudades visibles por el usuario
                val ciudadesVisibles = DatosCompartidos.obtenerCiudadesVisibles()
                
                // Si no hay ciudades visibles (primera vez), sincronizar Ciudad Real por defecto
                if (ciudadesVisibles.isEmpty()) {
                    try {
                        weatherRepository.sincronizarCiudad("Ciudad Real")
                        val ciudadReal = weatherDao.buscarCiudadPorNombre("Ciudad Real")
                        ciudadReal?.let { 
                            DatosCompartidos.mostrarCiudad(it.idCiudad)
                            DatosCompartidos.idCiudadSeleccionada = it.idCiudad
                        }
                        Log.d("AerisApp", "Ciudad Real inicializada como predeterminada")
                    } catch (e: Exception) {
                        Log.e("AerisApp", "Error inicializando Ciudad Real: ${e.message}")
                    }
                } else {
                    // Sincronizar solo las ciudades que el usuario tiene visibles
                    ciudadesVisibles.forEach { idCiudad ->
                        try {
                            weatherRepository.sincronizarCiudadPorId(idCiudad)
                            Log.d("AerisApp", "Ciudad ID $idCiudad sincronizada")
                        } catch (e: Exception) {
                            Log.e("AerisApp", "Error sincronizando ciudad ID $idCiudad: ${e.message}")
                        }
                    }
                }

                Log.d("AerisApp", "Sincronización completada")
            } catch (e: Exception) {
                Log.e("AerisApp", "Error en sincronización: ${e.message}")
            }
        }
    }
}
