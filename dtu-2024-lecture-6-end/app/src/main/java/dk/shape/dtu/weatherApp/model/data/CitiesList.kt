package dk.shape.dtu.weatherApp.model.data

import androidx.lifecycle.MutableLiveData

object CitiesList {
    val citiesWeather = MutableLiveData<Map<WeatherResponse, Boolean>>(emptyMap())

    fun addCityToList(newCityWeather: WeatherResponse?) {
        if (newCityWeather != null && citiesWeather.value?.none{it.key.city?.name == newCityWeather.city?.name} == true) {
            citiesWeather.postValue(citiesWeather.value?.plus(Pair(newCityWeather, false)))
        }
    }

    fun removeCityFromList(weatherResponse: WeatherResponse) {
        citiesWeather.postValue(citiesWeather.value?.filterNot { it.key.city?.name == weatherResponse.city?.name })
    }

    fun toggleFavourite(cityName: String) {
        citiesWeather.value?.let { currentMap ->
            val updatedMap = HashMap(currentMap)

            val matchingKey = updatedMap.keys.find { it.city?.name == cityName }

            matchingKey?.let { key ->
                updatedMap[key] = if (updatedMap[key] == null) false else !updatedMap[key]!!
            }

            // Post the updated map back to LiveData
            citiesWeather.postValue(updatedMap)
        }
    }

    fun isFavourite(cityName: String): Boolean {
        return citiesWeather.value?.get(citiesWeather.value?.keys?.find{it.city?.name == cityName}) ?: false
    }
}
