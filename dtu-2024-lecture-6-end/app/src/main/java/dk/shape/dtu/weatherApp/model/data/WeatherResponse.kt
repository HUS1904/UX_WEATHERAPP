package dk.shape.dtu.weatherApp.model.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("cod") var cod: String? = null,
    @SerialName("message") var message: Int? = null,
    @SerialName("cnt") var cnt: Int? = null,
    @SerialName("list") var list: ArrayList<WeatherData> = arrayListOf(),
    @SerialName("city") var city: City? = City()
)

@Serializable
data class City(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("coord") var coord: Coord? = Coord(),
    @SerialName("country") var country: String? = null,
    @SerialName("population") var population: Int? = null,
    @SerialName("timezone") var timezone: Int? = null,
    @SerialName("sunrise") var sunrise: Int? = null,
    @SerialName("sunset") var sunset: Int? = null
)

@Serializable
data class Coord(
    @SerialName("lat") var lat: Double? = null,
    @SerialName("lon") var lon: Double? = null
)

@Serializable
data class WeatherData(
    @SerialName("dt") var dt: Long? = null,
    @SerialName("main") var main: Main? = Main(),
    @SerialName("weather") var weather: ArrayList<Weather> = arrayListOf(),
    @SerialName("clouds") var clouds: Clouds? = Clouds(),
    @SerialName("wind") var wind: Wind? = Wind(),
    @SerialName("visibility") var visibility: Int? = null,
    @SerialName("pop") var pop: Double? = null,
    @SerialName("sys") var sys: Sys? = Sys(),
    @SerialName("dt_txt") var dtTxt: String? = null,
    @SerialName("rain") var rain: Rain? = null
)

@Serializable
data class Rain(
    @SerialName("3h") var last3Hours: Double? = null
)

@Serializable
data class Main(
    @SerialName("temp") var temp: Double? = null,
    @SerialName("feels_like") var feelsLike: Double? = null,
    @SerialName("temp_min") var tempMin: Double? = null,
    @SerialName("temp_max") var tempMax: Double? = null,
    @SerialName("pressure") var pressure: Int? = null,
    @SerialName("sea_level") var seaLevel: Int? = null,
    @SerialName("grnd_level") var grndLevel: Int? = null,
    @SerialName("humidity") var humidity: Int? = null,
    @SerialName("temp_kf") var tempKf: Double? = null
)

@Serializable
data class Weather(
    @SerialName("id") var id: Int? = null,
    @SerialName("main") var main: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("icon") var icon: String? = null
)

@Serializable
data class Clouds(
    @SerialName("all") var all: Int? = null
)

@Serializable
data class Wind(
    @SerialName("speed") var speed: Double? = null,
    @SerialName("deg") var deg: Int? = null,
    @SerialName("gust") var gust: Double? = null
)

@Serializable
data class Sys(
    @SerialName("pod") var pod: String? = null
)

@Serializable
data class UvIndexResponse(
    @SerialName("lat") val lat: Double,
    @SerialName("lon") val lon: Double,
    @SerialName("date_iso") val dateIso: String,
    @SerialName("date") val date: Long,
    @SerialName("value") val value: Double
)
