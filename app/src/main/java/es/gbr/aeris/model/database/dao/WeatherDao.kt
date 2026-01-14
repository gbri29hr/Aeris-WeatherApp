package es.gbr.aeris.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import es.gbr.aeris.model.database.entities.*
import es.gbr.aeris.model.database.relations.CiudadConTiempoActual

// DAO con las consultas SQL para acceder a los datos
@Dao
interface WeatherDao {

    @Query("SELECT * FROM ciudades")
    fun obtenerTodasLasCiudades(): LiveData<List<CiudadEntidad>>

    @Query("SELECT * FROM tiempo_actual WHERE id_ciudad_fk = :idCiudad")
    fun obtenerTiempoActual(idCiudad: Int): LiveData<TiempoActualEntidad>

    @Query("SELECT * FROM prediccion_hora WHERE id_ciudad_fk = :idCiudad ORDER BY id_hora ASC")
    fun obtenerPrediccionHoras(idCiudad: Int): LiveData<List<PrediccionHorasEntidad>>

    @Query("SELECT * FROM prediccion_dia WHERE id_ciudad_fk = :idCiudad ORDER BY id_dia ASC")
    fun obtenerPrediccionDiaria(idCiudad: Int): LiveData<List<PrediccionDiariaEntidad>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarCiudad(ciudad: CiudadEntidad): Long
    
    @Query("SELECT * FROM ciudades WHERE nombre = :nombre LIMIT 1")
    suspend fun buscarCiudadPorNombre(nombre: String): CiudadEntidad?
    
    @Query("SELECT * FROM ciudades WHERE id_ciudad = :idCiudad LIMIT 1")
    suspend fun obtenerCiudadPorId(idCiudad: Int): CiudadEntidad?
    
    @Query("UPDATE ciudades SET latitud = :latitud, longitud = :longitud WHERE id_ciudad = :idCiudad")
    suspend fun actualizarCoordenadasCiudad(idCiudad: Int, latitud: Double, longitud: Double)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTiempoActual(tiempo: TiempoActualEntidad)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarListaHoras(listaHoras: List<PrediccionHorasEntidad>)
    
    @Query("DELETE FROM prediccion_hora WHERE id_ciudad_fk = :idCiudad")
    suspend fun eliminarHorasPorCiudad(idCiudad: Int)
    
    @Query("DELETE FROM prediccion_dia WHERE id_ciudad_fk = :idCiudad")
    suspend fun eliminarDiasPorCiudad(idCiudad: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarListaDias(listaDias: List<PrediccionDiariaEntidad>)

    @Query("DELETE FROM ciudades WHERE id_ciudad = :idCiudad")
    suspend fun eliminarCiudadPorId(idCiudad: Int)

    // Eliminar ciudades duplicadas, manteniendo solo la de menor ID por cada nombre
    @Query("""
        DELETE FROM ciudades 
        WHERE id_ciudad NOT IN (
            SELECT MIN(id_ciudad) FROM ciudades GROUP BY nombre
        )
    """)
    suspend fun eliminarCiudadesDuplicadas()

    @Transaction
    @Query("SELECT * FROM ciudades ORDER BY id_ciudad")
    fun obtenerCiudadesConTiempoActual(): LiveData<List<CiudadConTiempoActual>>
}
