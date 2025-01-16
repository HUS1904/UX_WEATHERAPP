package dk.shape.dtu.weatherApp.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.CitiesList.citiesWeather
import fetchUvIndex
import fetchWeatherDataByCity
import kotlinx.coroutines.launch

class CitiesListViewModel : ViewModel() {
    val searchQuery = MutableLiveData("")  // Stores the current search query

    var previewWeather = MutableLiveData<WeatherResponse?>(null)  // Stores the weather data preview

    val previewUvIndex = MutableLiveData<Double?>(null)  // Stores the UV index preview

    val savedCities = citiesWeather  // List of saved cities' weather data

    // HashMap to track favorite status of cities (name -> isFavorite)
    private val _favoriteCities = MutableLiveData<Map<String, Boolean>>(emptyMap())


    // Function to handle search query changes
    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
        if (query.isNotBlank()) {
            viewModelScope.launch {
                fetchWeatherDataByCity(query) { weatherResponse ->
                    previewWeather.postValue(weatherResponse)
                    weatherResponse?.city?.coord?.let {
                        viewModelScope.launch {
                            fetchUvIndex(it.lat ?: 0.0, it.lon ?: 0.0) { uv ->
                                previewUvIndex.postValue(uv)
                            }
                        }
                    }
                }
            }
        } else {
            previewWeather.value = null
            previewUvIndex.value = null
        }
    }

    // Function to toggle the favorite status of a city
    fun toggleFavorite(cityName: String) {
        _favoriteCities.value = _favoriteCities.value?.toMutableMap()?.apply {
            this[cityName] = !(this[cityName] ?: false)
        }
    }

    fun isFavorite(cityName: String): Boolean {
        return _favoriteCities.value?.get(cityName) ?: false
    }

    fun removeCityFromSaved(weatherResponse: WeatherResponse) {
        savedCities.value = savedCities.value?.filterNot { it.city?.name == weatherResponse.city?.name }
    }

    fun addCityToList(newCityWeather: WeatherResponse?) {
        if (newCityWeather != null && citiesWeather.value?.none { it.city?.name == newCityWeather.city?.name } == true) {
            citiesWeather.postValue(citiesWeather.value?.plus(newCityWeather))
        }
    }
}
