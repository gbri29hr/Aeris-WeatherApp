package es.gbr.aeris.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.gbr.aeris.data.api.OpenWeatherRepository
import es.gbr.aeris.model.DatosCompartidos
import es.gbr.aeris.model.database.database.AppDataBase
import es.gbr.aeris.model.database.relations.CiudadConTiempoActual
import es.gbr.aeris.model.repository.WeatherRepository
import kotlinx.coroutines.launch

// ViewModel que filtra ciudades por búsqueda y controla cuáles se muestran en la lista
class LocalizacionesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository
    private val weatherRepository: OpenWeatherRepository
    val todasLasCiudadesDB: LiveData<List<CiudadConTiempoActual>>

    private var textoBusquedaActual: String = ""
    private var ciudadesVisiblesActuales: Set<Int> = emptySet()

    private val _ciudadesFiltradas = MutableLiveData<List<CiudadConTiempoActual>>()
    val ciudadesFiltradas: LiveData<List<CiudadConTiempoActual>> = _ciudadesFiltradas

    init {
        val weatherDao = AppDataBase.obtenerBaseDeDatos(application).weatherDao()
        repository = WeatherRepository(weatherDao)
        weatherRepository = OpenWeatherRepository(weatherDao)

        todasLasCiudadesDB = repository.obtenerCiudadesConTiempoActual()
        _ciudadesFiltradas.value = emptyList()
        
        // Cargar ciudades visibles de forma asíncrona
        viewModelScope.launch {
            ciudadesVisiblesActuales = DatosCompartidos.obtenerCiudadesVisibles()
        }
    }

    // Actualiza la lista filtrada basándose en ciudades visibles y texto de búsqueda
    fun actualizarListaFiltrada(todasLasCiudades: List<CiudadConTiempoActual>) {
        val idPrincipal = DatosCompartidos.idCiudadSeleccionada
        
        val listaFiltrada = todasLasCiudades
            .distinctBy { it.ciudad.idCiudad } 
            .filter { ciudadConTiempo ->
                ciudadesVisiblesActuales.contains(ciudadConTiempo.ciudad.idCiudad)
            }
            .filter { ciudadConTiempo ->
                if (textoBusquedaActual.isEmpty()) true
                else ciudadConTiempo.ciudad.nombre.contains(textoBusquedaActual, ignoreCase = true)
            }
            .sortedByDescending { it.ciudad.idCiudad == idPrincipal }
            
        _ciudadesFiltradas.value = listaFiltrada
    }

    fun buscarCiudad(texto: String) {
        textoBusquedaActual = texto
        todasLasCiudadesDB.value?.let { actualizarListaFiltrada(it) }
    }

    fun actualizarCiudadesVisibles(visibles: Set<Int>) {
        ciudadesVisiblesActuales = visibles
        todasLasCiudadesDB.value?.let { actualizarListaFiltrada(it) }
    }
    
    fun refrescarCiudades() {
        todasLasCiudadesDB.value?.let { actualizarListaFiltrada(it) }
    }
    
    fun sincronizarTodasLasCiudades(onResultado: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val exito = weatherRepository.sincronizarDatosBasicos(excluirIdCiudad = null)
                onResultado(exito)
            } catch (e: Exception) {
                Log.e("LocalizacionesVM", "Error: ${e.message}")
                onResultado(false)
            }
        }
    }
}
