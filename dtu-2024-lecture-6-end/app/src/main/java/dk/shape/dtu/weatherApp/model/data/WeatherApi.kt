package dk.shape.dtu.weatherApp.model.data

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Header

interface WeatherApi {
    @GET("forecast")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Header("Cache-Control") cacheControl: String = "only-if-cached, max-stale=${60 * 60 * 24}"
    ): Call<WeatherResponse>


    @GET("forecast")
    fun getWeatherByCoordinates(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Header("Cache-Control") cacheControl: String = "only-if-cached, max-stale=${60 * 60 * 24}"
    ): Call<WeatherResponse>

    @GET("uvi")
    fun getUvIndex(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Header("Cache-Control") cacheControl: String = "only-if-cached, max-stale=${60 * 60 * 24}"
    ): Call<UvIndexResponse>
}