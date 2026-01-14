package es.gbr.aeris.model

import android.content.Context
import android.util.Log
import es.gbr.aeris.R
import es.gbr.aeris.data.preferences.PreferenciasRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

// Singleton que mantiene el ID de la ciudad seleccionada y gestiona las ciudades visibles
object DatosCompartidos {

    private var preferenciasRepository: PreferenciasRepository? = null
    private val scope = CoroutineScope(Dispatchers.IO)
    
    private val _idCiudadSeleccionadaFlow = MutableStateFlow(1)
    val idCiudadSeleccionadaFlow: StateFlow<Int> = _idCiudadSeleccionadaFlow.asStateFlow()
    
    fun inicializar(context: Context) {
        if (preferenciasRepository == null) {
            preferenciasRepository = PreferenciasRepository(context.applicationContext)
        }
    }
    
    var idCiudadSeleccionada: Int
        get() = _idCiudadSeleccionadaFlow.value
        set(value) {
            _idCiudadSeleccionadaFlow.value = value
            scope.launch {
                try {
                    preferenciasRepository?.guardarCiudadPorDefecto(value)
                } catch (e: Exception) {
                    Log.e("DatosCompartidos", "Error: ${e.message}")
                }
            }
        }
    
    fun cargarCiudadSeleccionada() {
        scope.launch {
            try {
                val prefs = preferenciasRepository?.preferenciasFlow?.first()
                prefs?.let { idCiudadSeleccionada = it.idCiudadPorDefecto }
            } catch (e: Exception) {
                Log.e("DatosCompartidos", "Error: ${e.message}")
            }
        }
    }

    // Obtiene los IDs de las ciudades que el usuario ha marcado como visibles
    suspend fun obtenerCiudadesVisibles(): Set<Int> {
        return try {
            preferenciasRepository?.preferenciasFlow?.first()?.ciudadesVisibles ?: emptySet()
        } catch (e: Exception) {
            Log.e("DatosCompartidos", "Error al obtener ciudades visibles: ${e.message}")
            emptySet()
        }
    }
    
    suspend fun esCiudadVisible(idCiudad: Int): Boolean = obtenerCiudadesVisibles().contains(idCiudad)

    suspend fun ocultarCiudad(idCiudad: Int) {
        try {
            preferenciasRepository?.eliminarCiudadVisible(idCiudad)
        } catch (e: Exception) {
            Log.e("DatosCompartidos", "Error: ${e.message}")
        }
    }

    suspend fun mostrarCiudad(idCiudad: Int) {
        try {
            preferenciasRepository?.anadirCiudadVisible(idCiudad)
        } catch (e: Exception) {
            Log.e("DatosCompartidos", "Error: ${e.message}")
        }
    }

    // Traduce la descripción del clima al idioma del sistema
    fun traducirDescripcion(context: Context, descripcion: String): String {
        val desc = descripcion.lowercase().trim()
        return when {
            // Despejado / Clear sky
            desc.contains("despejado") || desc == "soleado" || 
            desc.contains("clear") || desc.contains("sunny") ->
                context.getString(R.string.clima_soleado)
            
            // Parcialmente nublado / Partly cloudy / Few clouds / Scattered clouds
            desc.contains("poco nuboso") || desc.contains("intervalos nubosos") ||
            desc.contains("nubes altas") || desc.contains("parcialmente") ||
            desc.contains("few clouds") || desc.contains("scattered clouds") ||
            desc.contains("partly") ->
                context.getString(R.string.clima_parcialmente_nublado)
            
            // Nublado / Cloudy / Overcast / Broken clouds
            desc.contains("nuboso") || desc.contains("cubierto") ||
            desc.contains("cloudy") || desc.contains("overcast") || 
            desc.contains("broken clouds") || desc.contains("clouds") ->
                context.getString(R.string.clima_nublado)
            
            // Lluvia / Rain / Drizzle / Shower
            desc.contains("lluvia") || desc.contains("chubasco") ||
            desc.contains("rain") || desc.contains("drizzle") || 
            desc.contains("shower") ->
                context.getString(R.string.clima_lluvioso)
            
            // Tormenta / Thunderstorm / Storm
            desc.contains("tormenta") || desc.contains("thunderstorm") || 
            desc.contains("storm") ->
                context.getString(R.string.clima_tormenta)
            
            // Nieve / Snow
            desc.contains("nieve") || desc.contains("nevad") ||
            desc.contains("snow") ->
                context.getString(R.string.clima_nieve)
            
            else -> descripcion
        }
    }

    // Traduce el día de la semana al idioma del sistema
    fun traducirDia(context: Context, dia: String): String {
        val esIngles = context.resources.configuration.locales[0].language == "en"
        return when (dia.lowercase()) {
            "lunes" -> if (esIngles) "Monday" else "Lunes"
            "martes" -> if (esIngles) "Tuesday" else "Martes"
            "miércoles", "miercoles" -> if (esIngles) "Wednesday" else "Miércoles"
            "jueves" -> if (esIngles) "Thursday" else "Jueves"
            "viernes" -> if (esIngles) "Friday" else "Viernes"
            "sábado", "sabado" -> if (esIngles) "Saturday" else "Sábado"
            "domingo" -> if (esIngles) "Sunday" else "Domingo"
            else -> dia
        }
    }
}
