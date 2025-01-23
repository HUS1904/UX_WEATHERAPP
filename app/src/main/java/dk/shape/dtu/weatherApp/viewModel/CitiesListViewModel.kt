package dk.shape.dtu.weatherApp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import fetchWeatherDataByCity
import kotlinx.coroutines.launch

class CitiesListViewModel : ViewModel() {
    val searchQuery = MutableLiveData("")  // Stores the current search query

    val previewWeather = MutableLiveData<WeatherResponse?>(null)  // Stores the weather data preview

    // Function to handle search query changes
    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
        if (query.isNotBlank()) {
            viewModelScope.launch {
                fetchWeatherDataByCity(query) { previewWeather.postValue(it) }
            }
        } else {
            previewWeather.value = null
        }
    }
}