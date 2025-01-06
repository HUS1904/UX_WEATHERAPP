package dk.shape.dtu.weatherApp.viewModel

import dk.shape.dtu.weatherApp.model.data.RetrofitInstance
import dk.shape.dtu.weatherApp.model.data.UvIndexResponse
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.apiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun fetchWeatherDataByCity(city: String, onResult: (WeatherResponse?) -> Unit) {
    val call = RetrofitInstance.api.getWeather(city, apiKey)

    call.enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                onResult(response.body())
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            onResult(null)
        }
    })
}

fun fetchWeatherDataByCoordinates(lat: Double, lon: Double, onResult: (WeatherResponse?) -> Unit) {
    val call = RetrofitInstance.api.getWeatherByCoordinates(lat, lon, apiKey)

    call.enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                onResult(response.body())
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            onResult(null)
        }
    })
}

fun fetchUvIndex(lat: Double, lon: Double, onResult: (Double?) -> Unit) {
    val call = RetrofitInstance.api.getUvIndex(lat, lon, apiKey)

    call.enqueue(object : Callback<UvIndexResponse> {
        override fun onResponse(call: Call<UvIndexResponse>, response: Response<UvIndexResponse>) {
            if (response.isSuccessful) {
                val uvIndex = response.body()?.value
                onResult(uvIndex)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<UvIndexResponse>, t: Throwable) {
            onResult(null)
        }
    })
}
