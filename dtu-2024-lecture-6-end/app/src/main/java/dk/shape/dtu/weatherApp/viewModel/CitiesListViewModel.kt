package dk.shape.dtu.weatherApp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import dk.shape.dtu.weatherApp.model.data.CitiesList.citiesWeather

class CitiesListViewModel : ViewModel() {
    val searchQuery = MutableLiveData("")

    val previewWeather = MutableLiveData<WeatherResponse?>(null)

    val previewUvIndex = MutableLiveData<Double?>(null)

    val savedCities = citiesWeather

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
        if (query.isNotBlank()) {
            fetchWeatherDataByCity(query) { weatherResponse ->
                previewWeather.value = weatherResponse
                weatherResponse?.city?.coord?.let {
                    fetchUvIndex(it.lat ?: 0.0, it.lon ?: 0.0) { uv ->
                        previewUvIndex.value = uv
                    }
                }
            }
        } else {
            previewWeather.value = null
            previewUvIndex.value = null
        }
    }
}
