package dk.shape.dtu.weatherApp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.CitiesList.citiesWeather
import fetchUvIndex
import fetchWeatherDataByCity
import kotlinx.coroutines.launch

class CitiesListViewModel : ViewModel() {
    val searchQuery = MutableLiveData("")

    val previewWeather = MutableLiveData<WeatherResponse?>(null)

    val previewUvIndex = MutableLiveData<Double?>(null)

    val savedCities = citiesWeather

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
}
