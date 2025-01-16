package dk.shape.dtu.weatherApp.model.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@SuppressLint("StaticFieldLeak")
object CitiesList {
    lateinit var citiesWeather: MutableLiveData<Map<WeatherResponse, Boolean>>

    private var context: Context? = null
    private lateinit var sharedPreferences: SharedPreferences
    private val json = Json { allowStructuredMapKeys = true }

    fun initialize(context: Context) {
        this.context = context.applicationContext
        sharedPreferences = context.getSharedPreferences("CitiesList", Context.MODE_PRIVATE)

        // Check if cached data exists in SharedPreferences
        val cachedData = sharedPreferences.getString("citiesWeather", null)

        citiesWeather = if (cachedData != null) {
            // If there is cached data, deserialize it
            MutableLiveData(decodeWeatherData(cachedData))
        } else {
            MutableLiveData(emptyMap())
        }
    }

    fun addCityToList(newCityWeather: WeatherResponse?) {
        if (newCityWeather != null && citiesWeather.value?.none{it.key.city?.name == newCityWeather.city?.name} == true) {
            citiesWeather.postValue(citiesWeather.value?.plus(Pair(newCityWeather, false)))
        }
        saveCitiesWeatherToPreferences()
    }

    fun removeCityFromList(weatherResponse: WeatherResponse) {
        citiesWeather.postValue(citiesWeather.value?.filterNot { it.key.city?.name == weatherResponse.city?.name })
        saveCitiesWeatherToPreferences()
    }

    fun toggleFavourite(cityName: String) {
        citiesWeather.value?.let { currentMap ->
            val updatedMap = HashMap(currentMap)

            val matchingKey = updatedMap.keys.find { it.city?.name == cityName }

            matchingKey?.let {updatedMap[it] = if (updatedMap[it] == null) false else !updatedMap[it]!! }

            citiesWeather.postValue(updatedMap)
        }
        saveCitiesWeatherToPreferences()
    }

    fun isFavourite(cityName: String): Boolean {
        return citiesWeather.value?.get(citiesWeather.value?.keys?.find{it.city?.name == cityName}) ?: false
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
