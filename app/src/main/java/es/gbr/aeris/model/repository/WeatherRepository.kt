package es.gbr.aeris.model.repository

import androidx.lifecycle.LiveData
import es.gbr.aeris.model.database.dao.WeatherDao
import es.gbr.aeris.model.database.entities.*
import es.gbr.aeris.model.database.relations.CiudadConTiempoActual

// Repositorio que accede a Room para los ViewModels
class WeatherRepository(private val weatherDao: WeatherDao) {

    fun obtenerTodasLasCiudades(): LiveData<List<CiudadEntidad>> =
        weatherDao.obtenerTodasLasCiudades()

    fun obtenerTiempoActual(idCiudad: Int): LiveData<TiempoActualEntidad> =
        weatherDao.obtenerTiempoActual(idCiudad)

    fun obtenerPrediccionHoras(idCiudad: Int): LiveData<List<PrediccionHorasEntidad>> =
        weatherDao.obtenerPrediccionHoras(idCiudad)

    fun obtenerPrediccionDiaria(idCiudad: Int): LiveData<List<PrediccionDiariaEntidad>> =
        weatherDao.obtenerPrediccionDiaria(idCiudad)

    fun obtenerCiudadesConTiempoActual(): LiveData<List<CiudadConTiempoActual>> =
        weatherDao.obtenerCiudadesConTiempoActual()

    suspend fun insertarCiudad(ciudad: CiudadEntidad): Long =
        weatherDao.insertarCiudad(ciudad)
}