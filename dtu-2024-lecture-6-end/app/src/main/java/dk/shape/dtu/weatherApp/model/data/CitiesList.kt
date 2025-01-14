package dk.shape.dtu.weatherApp.model.data

import androidx.lifecycle.MutableLiveData

object CitiesList {
    val citiesWeather = MutableLiveData<List<WeatherResponse>>(emptyList())

    fun addCityToList(newCityWeather: WeatherResponse?) {
        if (newCityWeather != null && citiesWeather.value?.none{it.city?.name == newCityWeather.city?.name} == true) {
            citiesWeather.postValue(citiesWeather.value?.plus(newCityWeather))
        }
    }
}
