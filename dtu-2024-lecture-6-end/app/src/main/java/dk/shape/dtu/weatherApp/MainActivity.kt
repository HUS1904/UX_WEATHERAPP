package dk.shape.dtu.weatherApp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import androidx.navigation.compose.*
import com.google.android.gms.location.*
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.addCityToList
import dk.shape.dtu.weatherApp.model.data.getLastKnownLocation
import dk.shape.dtu.weatherApp.view.AppContent
import dk.shape.dtu.weatherApp.view.CitiesListScreen

const val apiKey = "d63ace15f43fa9ad250fcd0b88a420cd"

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude by mutableStateOf<Double?>(null)
    private var longitude by mutableStateOf<Double?>(null)
    private val citiesWeather = mutableStateListOf<WeatherResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getLastKnownLocation(fusedLocationClient, this) {lat, lon ->
                    latitude = lat
                    longitude = lon
                }
            } else {
                latitude = 55.6761
                longitude = 12.5683
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            getLastKnownLocation(fusedLocationClient, this) {lat, lon ->
                latitude = lat
                longitude = lon
            }
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "weatherScreen") {
                composable("weatherScreen") {
                    val lat = latitude
                    val lon = longitude
                    if (lat != null && lon != null) {
                        AppContent(lat, lon, null, navController) { newCityWeather ->
                            addCityToList(newCityWeather)
                        }
                    }
                }
                composable("citiesListScreen") {
                    CitiesListScreen(navController = navController, citiesWeather = citiesWeather)
                }
                composable("weatherScreen/{cityName}") { backStackEntry ->
                    val cityName = backStackEntry.arguments?.getString("cityName") ?: "Copenhagen"
                    AppContent(null, null, cityName, navController) { newCityWeather ->
                        addCityToList(newCityWeather)
                    }
                }
            }
        }
    }
}