package dk.shape.dtu.weatherApp.model.data

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.runtime.mutableStateListOf
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import dk.shape.dtu.weatherApp.MainActivity

val citiesWeather = mutableStateListOf<WeatherResponse>()

fun getLastKnownLocation(fusedLocationClient: FusedLocationProviderClient, activity: MainActivity, callback: (Double, Double) -> Unit) {
    // Default fallback location (Copenhagen)
    var latitude = 55.6761
    var longitude = 12.5683

    // Check permissions
    if (ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
        || ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // If no permission, return default values
        callback(latitude, longitude)
        return
    }

    // Asynchronous location fetch
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        if (location != null) {
            latitude = location.latitude
            longitude = location.longitude
        }
        callback(latitude, longitude)
    }.addOnFailureListener {
        // In case of failure, fallback to default values
        callback(latitude, longitude)
    }
}


fun addCityToList(newCityWeather: WeatherResponse?) {
    if (newCityWeather != null && citiesWeather.none{it.city?.name == newCityWeather.city?.name}) {
        citiesWeather.add(newCityWeather)
    }
}

