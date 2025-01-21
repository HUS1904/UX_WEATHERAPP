package dk.shape.dtu.weatherApp.model.data

import android.content.SharedPreferences
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CitiesList {
    lateinit var citiesWeather: MutableLiveData<Map<WeatherResponse, Boolean>>

    private lateinit var sharedPreferences: SharedPreferences
    private val json = Json { allowStructuredMapKeys = true }

    fun initialize(sharedPreferences: SharedPreferences, lifecycleOwner: LifecycleOwner) {
        this.sharedPreferences = sharedPreferences

        // Check if cached data exists in SharedPreferences
        val cachedData = sharedPreferences.getString("citiesWeather", null)

        citiesWeather = if (cachedData != null) {
            // If there is cached data, deserialize it
            MutableLiveData(decodeWeatherData(cachedData))
        } else {
            MutableLiveData(emptyMap())
        }

        citiesWeather.observe(lifecycleOwner) {
            saveCitiesWeatherToPreferences()
        }
    }

    fun addCityToList(newCityWeather: WeatherResponse?) {
        if (newCityWeather != null && citiesWeather.value?.none { it.key.city?.name == newCityWeather.city?.name } == true) {
            // Preserve order by using LinkedHashMap
            val updatedMap = LinkedHashMap(citiesWeather.value)
            updatedMap[newCityWeather] = false
            citiesWeather.postValue(updatedMap)
        }
    }

    fun removeCityFromList(weatherResponse: WeatherResponse) {
        // Preserve order by using LinkedHashMap
        val updatedMap = LinkedHashMap(citiesWeather.value)
        updatedMap.entries.removeIf { it.key.city?.name == weatherResponse.city?.name }
        citiesWeather.postValue(updatedMap)
    }

    fun toggleFavourite(cityName: String) {
        citiesWeather.value?.let { currentMap ->
            // Preserve order by using LinkedHashMap
            val updatedMap = LinkedHashMap(currentMap)

            // Find the key matching the city name and toggle its value
            updatedMap.keys.find { it.city?.name == cityName }?.let { key ->
                updatedMap[key] = !(updatedMap[key] ?: false)
            }

            citiesWeather.postValue(updatedMap)
        }
    }

    fun isFavourite(cityName: String): Boolean {
        return citiesWeather.value?.get(citiesWeather.value?.keys?.find { it.city?.name == cityName }) ?: false
    }

    private fun decodeWeatherData(cachedData: String): Map<WeatherResponse, Boolean> {
        return try {
            json.decodeFromString(cachedData)
        } catch (e: Exception) {
            emptyMap()
        }
    }

    private fun saveCitiesWeatherToPreferences() {
        val weatherMap = citiesWeather.value ?: emptyMap()

        val serializedData = json.encodeToString(weatherMap)

        sharedPreferences.edit().putString("citiesWeather", serializedData).apply()
    }
}
