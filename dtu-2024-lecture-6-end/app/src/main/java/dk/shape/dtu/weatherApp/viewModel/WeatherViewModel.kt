package dk.shape.dtu.weatherApp.viewModel

import android.util.Log
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
                Log.d("Response successful", "Weather data: ${response.body()!!.list}")
                onResult(response.body())
            } else {
                Log.d("Response failed", "Could not retrieve data")
                onResult(null)
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            Log.d("Call failed", "Could not retrieve data")
            onResult(null)
        }
    })
}

fun fetchWeatherDataByCoordinates(lat: Double, lon: Double, onResult: (WeatherResponse?) -> Unit) {
    val call = RetrofitInstance.api.getWeatherByCoordinates(lat, lon, apiKey)

    call.enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                Log.d("Response successful", "Weather data: ${response.body()!!.list}")
                onResult(response.body())
            } else {
                Log.d("Response failed", "Could not retrieve data")
                onResult(null)
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            Log.d("Call failed", "Could not retrieve data")
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
                Log.d("Response successful", "Weather data: ${response.body()}")
                onResult(uvIndex)
            } else {
                Log.d("Response failed", "Could not retrieve data")
                onResult(null)
            }
        }

        override fun onFailure(call: Call<UvIndexResponse>, t: Throwable) {
            Log.d("Call failed", "Could not retrieve data")
            onResult(null)
        }
    })
}
