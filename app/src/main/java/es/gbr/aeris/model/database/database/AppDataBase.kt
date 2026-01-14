package es.gbr.aeris.model.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import es.gbr.aeris.model.database.dao.WeatherDao
import es.gbr.aeris.model.database.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Base de datos Room que almacena ciudades y datos del tiempo
@Database(
    entities = [
        CiudadEntidad::class,
        TiempoActualEntidad::class,
        PrediccionHorasEntidad::class,
        PrediccionDiariaEntidad::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun obtenerBaseDeDatos(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "weather_app.db"
                )
                    .addCallback(DatabaseCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


    private class DatabaseCallback : Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(database.weatherDao())
                }
            }
        }

        // Poblar la base de datos con ciudades principales de España al crear la BD por primera vez
        suspend fun populateDatabase(weatherDao: WeatherDao) {
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Ciudad Real", latitud = 38.9863, longitud = -3.9271))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Madrid", latitud = 40.4168, longitud = -3.7038))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Barcelona", latitud = 41.3851, longitud = 2.1734))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Valencia", latitud = 39.4699, longitud = -0.3763))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Sevilla", latitud = 37.3891, longitud = -5.9845))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Zaragoza", latitud = 41.6488, longitud = -0.8891))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Málaga", latitud = 36.7213, longitud = -4.4214))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Murcia", latitud = 37.9922, longitud = -1.1307))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Palma", latitud = 39.5696, longitud = 2.6502))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Las Palmas", latitud = 28.1248, longitud = -15.4300))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Bilbao", latitud = 43.2630, longitud = -2.9350))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Alicante", latitud = 38.3452, longitud = -0.4810))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Córdoba", latitud = 37.8882, longitud = -4.7794))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Valladolid", latitud = 41.6521, longitud = -4.7286))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Vigo", latitud = 42.2406, longitud = -8.7207))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Gijón", latitud = 43.5322, longitud = -5.6611))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Granada", latitud = 37.1773, longitud = -3.5986))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "A Coruña", latitud = 43.3623, longitud = -8.4115))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Vitoria", latitud = 42.8467, longitud = -2.6731))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Elche", latitud = 38.2699, longitud = -0.6983))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Oviedo", latitud = 43.3614, longitud = -5.8493))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Santander", latitud = 43.4623, longitud = -3.8099))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Pamplona", latitud = 42.8125, longitud = -1.6458))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Cartagena", latitud = 37.6256, longitud = -0.9960))
            weatherDao.insertarCiudad(CiudadEntidad(nombre = "Cádiz", latitud = 36.5271, longitud = -6.2886))
        }
    }
}
