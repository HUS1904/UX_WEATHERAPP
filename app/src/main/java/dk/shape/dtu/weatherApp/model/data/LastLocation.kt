package dk.shape.dtu.weatherApp.model.data

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import dk.shape.dtu.weatherApp.MainActivity

fun getLastKnownLocation(fusedLocationClient: FusedLocationProviderClient, activity: MainActivity, callback: (Double, Double) -> Unit) {
    // Default location
    var latitude = 55.6761
    var longitude = 12.5683

    Log.d("getLastKnownLocation", "Getting last known location")

    if (ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
        || ActivityCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        callback(latitude, longitude)
        return
    }
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        if (location != null) {
            latitude = location.latitude
            longitude = location.longitude
        }
        callback(latitude, longitude)
    }.addOnFailureListener {
        callback(latitude, longitude)
    }
}