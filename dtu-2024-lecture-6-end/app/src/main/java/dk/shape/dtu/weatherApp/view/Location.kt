package dk.shape.dtu.weatherApp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.viewModel.fetchUvIndex
import dk.shape.dtu.weatherApp.viewModel.fetchWeatherDataByCity
import dk.shape.dtu.weatherApp.viewModel.fetchWeatherDataByCoordinates

@Composable
fun LocationScreen(
    navController: NavController,
    weatherData: WeatherResponse?,
    uvIndex: Double?
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF282828)
    ) {
        Column {
            WeatherScreen(navController, weatherData = weatherData, uvIndex = uvIndex)
        }
    }
}

@Composable
fun Location(
    latitude: Double,
    longitude: Double,
    navController: NavController,
    onWeatherFetched: (WeatherResponse?) -> Unit
) {
    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }
    var uvIndex by remember { mutableStateOf<Double?>(null) }

    LaunchedEffect(latitude, longitude) {
        while (true) {
            fetchWeatherDataByCoordinates(latitude, longitude) { data ->
                weatherData = data
                onWeatherFetched(data)
                data?.city?.coord?.let { coord ->
                    fetchUvIndex(coord.lat ?: 0.0, coord.lon ?: 0.0) { uv ->
                        uvIndex = uv
                    }
                }
            }
            kotlinx.coroutines.delay(5 * 60 * 1000L)
        }
    }

    Box(Modifier.fillMaxSize(), Alignment.Center) {
        LocationScreen(navController, weatherData, uvIndex)
    }
}
