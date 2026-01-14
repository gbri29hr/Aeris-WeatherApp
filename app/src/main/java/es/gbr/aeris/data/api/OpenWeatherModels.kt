package es.gbr.aeris.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Modelos para OpenWeather API 2.5 (gratuita)

// Respuesta del clima actual
@Serializable
data class OpenWeatherCurrentResponse(
    val coord: OpenWeatherCoord = OpenWeatherCoord(),
    val weather: List<OpenWeatherWeather> = emptyList(),
    val main: OpenWeatherMain = OpenWeatherMain(),
    val wind: OpenWeatherWind = OpenWeatherWind(),
    val name: String = "",
    val dt: Long = 0
)

// Respuesta de la predicción de 5 días
@Serializable
data class OpenWeatherForecastResponse(
    val list: List<OpenWeatherForecastItem> = emptyList(),
    val city: OpenWeatherCity = OpenWeatherCity()
)

// Item de predicción (cada 3 horas)
@Serializable
data class OpenWeatherForecastItem(
    val dt: Long = 0,
    @SerialName("dt_txt") val dtTxt: String = "",
    val main: OpenWeatherMain = OpenWeatherMain(),
    val weather: List<OpenWeatherWeather> = emptyList(),
    val wind: OpenWeatherWind = OpenWeatherWind(),
    val pop: Double = 0.0  // Probabilidad de precipitación (0.0 a 1.0)
)

// Coordenadas
@Serializable
data class OpenWeatherCoord(
    val lat: Double = 0.0,
    val lon: Double = 0.0
)

// Información meteorológica principal
@Serializable
data class OpenWeatherMain(
    val temp: Double = 0.0,
    @SerialName("temp_min") val tempMin: Double = 0.0,
    @SerialName("temp_max") val tempMax: Double = 0.0,
    val humidity: Int = 0,
    @SerialName("feels_like") val feelsLike: Double = 0.0
)

// Información del viento
@Serializable
data class OpenWeatherWind(
    val speed: Double = 0.0,
    val deg: Int = 0
)

// Condición meteorológica
@Serializable
data class OpenWeatherWeather(
    val id: Int = 0,
    val main: String = "",
    val description: String = "",
    val icon: String = ""
)

// Información de la ciudad (en predicción)
@Serializable
data class OpenWeatherCity(
    val name: String = "",
    val coord: OpenWeatherCoord = OpenWeatherCoord()
)

// Respuesta de índice UV
@Serializable
data class OpenWeatherUVResponse(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val value: Double = 0.0,
    @SerialName("date_iso") val dateIso: String = ""
)
