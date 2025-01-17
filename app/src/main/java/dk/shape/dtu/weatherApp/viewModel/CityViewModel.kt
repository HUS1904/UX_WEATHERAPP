package dk.shape.dtu.weatherApp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import fetchUvIndex
import fetchWeatherDataByCity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CityViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData

    private val _uvIndex = MutableLiveData<Double?>()
    val uvIndex: LiveData<Double?> = _uvIndex

    fun startFetchingWeather(cityName: String, onWeatherFetched: (WeatherResponse?) -> Unit) {
        viewModelScope.launch {
            while (true) {
                Log.d("CityViewModel", "Fetching weather data...")
                fetchWeatherDataByCity(cityName) { data ->
                    if (data != null) {
                        _weatherData.postValue(data)
                        onWeatherFetched(data)
                        data.city?.coord?.let {
                            // Launch a coroutine to fetch UV index
                            viewModelScope.launch {
                                fetchUvIndex(it.lat ?: 0.0, it.lon ?: 0.0) { uv ->
                                    _uvIndex.postValue(uv)
                                }
                            }
                        }
                    }
                }
                delay(5 * 60 * 1000L) // 5-minute delay
            }
        }
    }
}
