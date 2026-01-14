package es.gbr.aeris.data.preferences

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "aeris_user_preferences"
)

data class UserPreferences(
    val usarFahrenheit: Boolean = false,
    val usarMph: Boolean = false,
    val temaOscuro: Boolean = false,
    val idCiudadPorDefecto: Int = 1,
    val ciudadesVisibles: Set<Int> = setOf(1, 2, 3),
    val ultimaSincronizacion: Long = 0L
)

// Gestión de preferencias del usuario (unidades, tema, ciudades) con DataStore
class PreferenciasRepository(private val context: Context) {

    private object PreferencesKeys {
        val USAR_FAHRENHEIT = booleanPreferencesKey("usar_fahrenheit")
        val USAR_MPH = booleanPreferencesKey("usar_mph")
        val TEMA_OSCURO = booleanPreferencesKey("tema_oscuro")
        val ID_CIUDAD_DEFECTO = intPreferencesKey("id_ciudad_defecto")
        val CIUDADES_VISIBLES = stringPreferencesKey("ciudades_visibles")
        val ULTIMA_SINCRONIZACION = longPreferencesKey("ultima_sincronizacion")
    }

    val preferenciasFlow: Flow<UserPreferences> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e("PreferenciasRepo", "Error: ${exception.message}")
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val ciudadesStr = preferences[PreferencesKeys.CIUDADES_VISIBLES] ?: ""
            val ciudadesSet = ciudadesStr.split(",")
                .filter { it.isNotBlank() }
                .mapNotNull { it.toIntOrNull() }
                .toSet()
            
            UserPreferences(
                usarFahrenheit = preferences[PreferencesKeys.USAR_FAHRENHEIT] ?: false,
                usarMph = preferences[PreferencesKeys.USAR_MPH] ?: false,
                temaOscuro = preferences[PreferencesKeys.TEMA_OSCURO] ?: false,
                idCiudadPorDefecto = preferences[PreferencesKeys.ID_CIUDAD_DEFECTO] ?: 1,
                ciudadesVisibles = ciudadesSet,
                ultimaSincronizacion = preferences[PreferencesKeys.ULTIMA_SINCRONIZACION] ?: 0L
            )
        }

    suspend fun guardarUsarFahrenheit(usarFahrenheit: Boolean) {
        context.dataStore.edit { it[PreferencesKeys.USAR_FAHRENHEIT] = usarFahrenheit }
    }

    suspend fun guardarUsarMph(usarMph: Boolean) {
        context.dataStore.edit { it[PreferencesKeys.USAR_MPH] = usarMph }
    }

    suspend fun guardarTemaOscuro(temaOscuro: Boolean) {
        context.dataStore.edit { it[PreferencesKeys.TEMA_OSCURO] = temaOscuro }
    }

    suspend fun guardarCiudadPorDefecto(idCiudad: Int) {
        context.dataStore.edit { it[PreferencesKeys.ID_CIUDAD_DEFECTO] = idCiudad }
    }
    
    suspend fun guardarCiudadesVisibles(ciudades: Set<Int>) {
        val ciudadesStr = ciudades.joinToString(",")
        context.dataStore.edit { it[PreferencesKeys.CIUDADES_VISIBLES] = ciudadesStr }
    }
    
    suspend fun anadirCiudadVisible(idCiudad: Int) {
        val actuales = preferenciasFlow.first().ciudadesVisibles.toMutableSet()
        actuales.add(idCiudad)
        guardarCiudadesVisibles(actuales)
    }
    
    suspend fun eliminarCiudadVisible(idCiudad: Int) {
        val actuales = preferenciasFlow.first().ciudadesVisibles.toMutableSet()
        actuales.remove(idCiudad)
        guardarCiudadesVisibles(actuales)
    }
    
    suspend fun esCiudadVisible(idCiudad: Int): Boolean {
        return preferenciasFlow.first().ciudadesVisibles.contains(idCiudad)
    }

    suspend fun actualizarUltimaSincronizacion() {
        val ahora = System.currentTimeMillis()
        context.dataStore.edit { it[PreferencesKeys.ULTIMA_SINCRONIZACION] = ahora }
    }

    suspend fun guardarPreferencias(
        usarFahrenheit: Boolean,
        usarMph: Boolean,
        temaOscuro: Boolean,
        idCiudadDefecto: Int
    ) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USAR_FAHRENHEIT] = usarFahrenheit
            preferences[PreferencesKeys.USAR_MPH] = usarMph
            preferences[PreferencesKeys.TEMA_OSCURO] = temaOscuro
            preferences[PreferencesKeys.ID_CIUDAD_DEFECTO] = idCiudadDefecto
        }
    }

    suspend fun limpiarPreferencias() {
        context.dataStore.edit { it.clear() }
    }
}
