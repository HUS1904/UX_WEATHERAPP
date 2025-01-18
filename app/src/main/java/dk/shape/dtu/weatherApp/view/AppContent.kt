package dk.shape.dtu.weatherApp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.viewModel.CityViewModel
import dk.shape.dtu.weatherApp.viewModel.LocationViewModel
import androidx.compose.material3.*



@Composable
fun AppContent(
    navController: NavController,
    weatherData: WeatherResponse,
    uvIndex: Double
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
    viewModel: LocationViewModel,
    onWeatherFetched: (WeatherResponse?) -> Unit
) {
    val weatherData by viewModel.weatherData.observeAsState()
    val uvIndex by viewModel.uvIndex.observeAsState()

    // Start fetching weather data when this composable becomes active
    LaunchedEffect(latitude, longitude) {
        viewModel.startFetchingWeather(latitude, longitude, onWeatherFetched)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF282828) // Match app's primary background color
    ) {

        // Only display AppContent if weather data is available
        if (weatherData != null && uvIndex != null) {
            Box(Modifier.fillMaxSize(), Alignment.Center) {
                AppContent(navController, weatherData!!, uvIndex!!)
            }
        } else {
            // Show a loading state
            Box(Modifier.fillMaxSize(), Alignment.Center) {
                Text(
                    text = "Loading...",
                    color = Color(0xFFE2376C), // Custom text color
                    style = MaterialTheme.typography.bodyLarge // Optional style
                )
            }
        }
    }
}

@Composable
fun City(
    cityName: String,
    navController: NavController,
    viewModel: CityViewModel,
    onWeatherFetched: (WeatherResponse?) -> Unit,
) {
    val weatherData by viewModel.weatherData.observeAsState()
    val uvIndex by viewModel.uvIndex.observeAsState()

    // Start fetching weather data when this composable becomes active
    LaunchedEffect(cityName) {
        viewModel.startFetchingWeather(cityName, onWeatherFetched)
    }

    // Only display AppContent if weather data is available
    if (weatherData != null && uvIndex != null) {
        Box(Modifier.fillMaxSize(), Alignment.Center) {
            AppContent(navController, weatherData!!, uvIndex!!)
        }
    } else {
        // Show a loading state
        Box(Modifier.fillMaxSize(), Alignment.Center) {
            Text("Loading...")
        }
    }
}
