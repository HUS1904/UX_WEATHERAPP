import android.util.Log
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.apiKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun fetchWeatherDataByCity(city: String, onResult: (WeatherResponse?) -> Unit) {
    withContext(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getWeather(city, apiKey).execute()
            if (response.isSuccessful) {
                Log.d("Response successful", "Weather data: ${response.body()!!.list}")
                onResult(response.body())
            } else {
                Log.d("Response failed", "Could not retrieve data, attempting cache.")
                val cachedResponse = tryCache(city)
                onResult(cachedResponse)
            }
        } catch (e: Exception) {
            Log.e("Call failed", "Error: ${e.message}, attempting cache.")
            val cachedResponse = tryCache(city)
            onResult(cachedResponse)
        }
    }
}

suspend fun fetchWeatherDataByCoordinates(lat: Double, lon: Double, onResult: (WeatherResponse?) -> Unit) {
    withContext(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getWeatherByCoordinates(lat, lon, apiKey).execute()
            if (response.isSuccessful) {
                Log.d("Response successful", "Weather data: ${response.body()!!.list}")
                onResult(response.body())
            } else {
                Log.d("Response failed", "Could not retrieve data, attempting cache.")
                val cachedResponse = tryCache("$lat,$lon")
                onResult(cachedResponse)
            }
        } catch (e: Exception) {
            Log.e("Call failed", "Error: ${e.message}, attempting cache.")
            val cachedResponse = tryCache("$lat,$lon")
            onResult(cachedResponse)
        }
    }
}

suspend fun fetchUvIndex(lat: Double, lon: Double, onResult: (Double?) -> Unit) {
    withContext(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getUvIndex(lat, lon, apiKey).execute()
            if (response.isSuccessful) {
                val uvIndex = response.body()?.value
                Log.d("Response successful", "UV Index: $uvIndex")
                onResult(uvIndex)
            } else {
                Log.d("Response failed", "Could not retrieve UV index. Cache cannot be queried for UV index.")
                onResult(null)
            }
        } catch (e: Exception) {
            Log.e("Call failed", "Error: ${e.message}. Cache cannot be queried for UV index.")
            onResult(null)
        }
    }
}

private fun tryCache(key: String): WeatherResponse? {
    return try {
        RetrofitInstance.api.getWeather(key, apiKey).request()
            .newBuilder()
            .header("Cache-Control", "only-if-cached, max-stale=${60 * 60 * 24}")
            .build()
        val response: Response<WeatherResponse> = RetrofitInstance.api.getWeather(key, apiKey).clone().execute()
        if (response.isSuccessful) response.body() else null
    } catch (e: Exception) {
        Log.e("Cache retrieval failed", "Error: ${e.message}")
        null
    }
}
