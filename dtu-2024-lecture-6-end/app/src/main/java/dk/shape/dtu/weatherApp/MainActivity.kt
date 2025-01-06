package dk.shape.dtu.weatherApp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.compose.*
import com.google.android.gms.location.*
import dk.shape.dtu.weatherApp.model.data.addCityToList
import dk.shape.dtu.weatherApp.model.data.getLastKnownLocation
import dk.shape.dtu.weatherApp.view.CitiesListScreen
import dk.shape.dtu.weatherApp.view.City
import dk.shape.dtu.weatherApp.view.Location

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {}

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "weatherScreen") {
                composable("weatherScreen") {
                    var latitude = 55.6761
                    var longitude = 12.5683
                    getLastKnownLocation(fusedLocationClient, this@MainActivity) {lat, lon -> latitude = lat; longitude = lon}

                    Location(latitude, longitude, navController) {newCityWeather ->
                        addCityToList(newCityWeather)
                    }
                }
                composable("citiesListScreen") {
                    CitiesListScreen(navController = navController)
                }
                composable("weatherScreen/{cityName}") { backStackEntry ->
                    val cityName = backStackEntry.arguments?.getString("cityName") ?: "Copenhagen"
                    City(cityName, navController) {newCityWeather ->
                        addCityToList(newCityWeather)
                    }
                }
            }
        }
    }
}