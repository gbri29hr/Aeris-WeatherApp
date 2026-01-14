package es.gbr.aeris.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import es.gbr.aeris.data.api.OpenWeatherRepository
import es.gbr.aeris.model.DatosCompartidos
import es.gbr.aeris.model.database.database.AppDataBase
import es.gbr.aeris.model.database.entities.CiudadEntidad
import es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad
import es.gbr.aeris.model.database.entities.PrediccionHorasEntidad
import es.gbr.aeris.model.database.entities.TiempoActualEntidad
import es.gbr.aeris.model.repository.WeatherRepository
import kotlinx.coroutines.launch

// ViewModel de la pantalla principal que sincroniza datos del tiempo de la ciudad actual
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository
    private val weatherRepository: OpenWeatherRepository

    val todasLasCiudades: LiveData<List<CiudadEntidad>>

    private val _idCiudadSeleccionada = MutableLiveData<Int>()
    val idCiudadSeleccionada: LiveData<Int> = _idCiudadSeleccionada
    
    private val _refrescandoManual = MutableLiveData(false)
    val refrescandoManual: LiveData<Boolean> = _refrescandoManual

    init {
        val weatherDao = AppDataBase.obtenerBaseDeDatos(application).weatherDao()
        repository = WeatherRepository(weatherDao)
        weatherRepository = OpenWeatherRepository(weatherDao)

        todasLasCiudades = repository.obtenerTodasLasCiudades()
        _idCiudadSeleccionada.value = DatosCompartidos.idCiudadSeleccionada
        
        viewModelScope.launch {
            try {
                weatherRepository.sincronizarCiudadPorId(DatosCompartidos.idCiudadSeleccionada)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error: ${e.message}")
            }
        }
    }

    val tiempoActual: LiveData<TiempoActualEntidad> = _idCiudadSeleccionada.switchMap { id ->
        repository.obtenerTiempoActual(id)
    }

    val prediccionHoras: LiveData<List<PrediccionHorasEntidad>> = _idCiudadSeleccionada.switchMap { id ->
        repository.obtenerPrediccionHoras(id)
    }

    val prediccionDiaria: LiveData<List<PrediccionDiariaEntidad>> = _idCiudadSeleccionada.switchMap { id ->
        repository.obtenerPrediccionDiaria(id)
    }

    fun cambiarCiudadSeleccionada(nuevoIdCiudad: Int) {
        _idCiudadSeleccionada.value = nuevoIdCiudad
        DatosCompartidos.idCiudadSeleccionada = nuevoIdCiudad
        
        viewModelScope.launch {
            try {
                weatherRepository.sincronizarCiudadPorId(nuevoIdCiudad)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error: ${e.message}")
            }
        }
    }
    
    fun sincronizarCiudadActual(onResultado: (Boolean) -> Unit = {}) {
        val idCiudad = _idCiudadSeleccionada.value ?: return
        _refrescandoManual.value = true

        viewModelScope.launch {
            try {
                val exito = weatherRepository.sincronizarCiudadPorId(idCiudad)
                _refrescandoManual.value = false
                onResultado(exito)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error: ${e.message}")
                _refrescandoManual.value = false
                onResultado(false)
            }
        }
    }
}


