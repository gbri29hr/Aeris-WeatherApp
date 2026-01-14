package es.gbr.aeris.data.api

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

// Cliente para OpenWeather API 2.5
object OpenWeatherClient {

    private const val API_KEY = 
    private const val BASE_URL =

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 10000
            connectTimeoutMillis = 5000
        }
    }

    // Obtiene el clima actual
    suspend fun obtenerClimaActual(lat: Double, lon: Double): OpenWeatherCurrentResponse? {
        return try {
            // Detectar idioma del sistema
            val idiomaSistema = java.util.Locale.getDefault().language
            val codigoIdioma = if (idiomaSistema == "es") "es" else "en"

            httpClient.get("$BASE_URL/weather") {
                parameter("lat", lat)
                parameter("lon", lon)
                parameter("appid", API_KEY)
                parameter("units", "metric")
                parameter("lang", codigoIdioma)
            }.body()
        } catch (e: Exception) {
            Log.e("OpenWeather", "Error clima actual: ${e.message}")
            null
        }
    }

    // Obtiene la predicción de 5 días (cada 3 horas)
    suspend fun obtenerPrediccion5Dias(lat: Double, lon: Double): OpenWeatherForecastResponse? {
        return try {
            // Detectar idioma del sistema
            val idiomaSistema = java.util.Locale.getDefault().language
            val codigoIdioma = if (idiomaSistema == "es") "es" else "en"

            httpClient.get("$BASE_URL/forecast") {
                parameter("lat", lat)
                parameter("lon", lon)
                parameter("appid", API_KEY)
                parameter("units", "metric")
                parameter("lang", codigoIdioma)
            }.body()
        } catch (e: Exception) {
            Log.e("OpenWeather", "Error predicción: ${e.message}")
            null
        }
    }

    // Obtiene el índice UV actual
    suspend fun obtenerIndiceUV(lat: Double, lon: Double): OpenWeatherUVResponse? {
        return try {
            httpClient.get("$BASE_URL/uvi") {
                parameter("lat", lat)
                parameter("lon", lon)
                parameter("appid", API_KEY)
            }.body()
        } catch (e: Exception) {
            Log.e("OpenWeather", "Error UV: ${e.message}")
            null
        }
    }
}