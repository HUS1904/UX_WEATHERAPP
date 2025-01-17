package dk.shape.dtu.weatherApp

import RetrofitInstance
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.google.android.gms.location.*
import dk.shape.dtu.weatherApp.model.data.CitiesList
import dk.shape.dtu.weatherApp.model.data.CitiesList.addCityToList
import dk.shape.dtu.weatherApp.model.data.getLastKnownLocation
import dk.shape.dtu.weatherApp.view.CitiesListScreen
import dk.shape.dtu.weatherApp.view.City
import dk.shape.dtu.weatherApp.view.Location
import dk.shape.dtu.weatherApp.viewModel.CitiesListViewModel
import dk.shape.dtu.weatherApp.viewModel.CityViewModel
import dk.shape.dtu.weatherApp.viewModel.LocationViewModel

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitInstance.initialize(applicationContext)
        CitiesList.initialize(applicationContext)
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
                    val viewModel: LocationViewModel = viewModel(it)
                    getLastKnownLocation(fusedLocationClient, this@MainActivity) {lat, lon -> latitude = lat; longitude = lon}

                    Location(latitude, longitude, navController, viewModel) {newCityWeather ->
                        addCityToList(newCityWeather)
                    }
                }
                composable("citiesListScreen") {
                    val viewModel: CitiesListViewModel = viewModel(it)
                    CitiesListScreen(navController = navController, viewModel)
                }
                composable("weatherScreen/{cityName}") {
                    val cityName = it.arguments?.getString("cityName") ?: "Copenhagen"
                    val viewModel: CityViewModel = viewModel(it)
                    City(cityName, navController, viewModel) {newCityWeather ->
                        addCityToList(newCityWeather)
                    }
                }
            }
        }
    }
}