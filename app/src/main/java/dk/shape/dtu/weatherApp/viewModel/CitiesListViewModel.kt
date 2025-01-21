package dk.shape.dtu.weatherApp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import fetchUvIndex
import fetchWeatherDataByCity
import kotlinx.coroutines.launch

class CitiesListViewModel : ViewModel() {
    val searchQuery = MutableLiveData("")  // Stores the current search query

    val previewWeather = MutableLiveData<WeatherResponse?>(null)  // Stores the weather data preview

    val previewUvIndex = MutableLiveData<Double?>(null)  // Stores the UV index preview

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
}