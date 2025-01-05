package dk.shape.dtu.weatherApp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import dk.shape.dtu.weatherApp.apiKey
import dk.shape.dtu.weatherApp.model.data.RetrofitInstance
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.viewModel.fetchUvIndex
import dk.shape.dtu.weatherApp.viewModel.fetchWeatherDataByCoordinates
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun AppContent(
    latitude: Double?,
    longitude: Double?,
    cityName: String?,
    navController: NavController,
    onWeatherFetched: (WeatherResponse?) -> Unit
) {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }
    var uvIndex by remember { mutableStateOf<Double?>(null) }

    LaunchedEffect(latitude, longitude, cityName) {
        if (latitude != null && longitude != null) {
            fetchWeatherDataByCoordinates(latitude, longitude) { data ->
                weatherData = data
                onWeatherFetched(data)
                data?.city?.coord?.let { coord ->
                    fetchUvIndex(coord.lat ?: 0.0, coord.lon ?: 0.0) { uv ->
                        uvIndex = uv
                    }
                }
            }
        } else if (cityName != null) {
            fetchWeatherData(cityName) { data ->
                weatherData = data
                onWeatherFetched(data)
                data?.city?.coord?.let { coord ->
                    fetchUvIndex(coord.lat ?: 0.0, coord.lon ?: 0.0) { uv ->
                        uvIndex = uv
                    }
                }
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF282828)
    ) {
        Column {
            WeatherScreen(navController, weatherData = weatherData, uvIndex = uvIndex)
        }
    }
}

fun fetchWeatherData(city: String, onResult: (WeatherResponse?) -> Unit) {
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