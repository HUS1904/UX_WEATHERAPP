package dk.shape.dtu.weatherApp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData

    private val _uvIndex = MutableLiveData<Double?>()
    val uvIndex: LiveData<Double?> = _uvIndex

    fun startFetchingWeather(latitude: Double, longitude: Double, onWeatherFetched: (WeatherResponse?) -> Unit) {
        viewModelScope.launch {
            while (true) {
                Log.d("LocationViewModel", "Fetching weather data...")
                fetchWeatherDataByCoordinates(latitude, longitude) { data ->
                    if(data != null){
                        _weatherData.value = data
                        onWeatherFetched(data)
                        data.city?.coord?.let {
                            fetchUvIndex(it.lat ?: 0.0, it.lon ?: 0.0) { uv ->
                                _uvIndex.value = uv
                            }
                        }
                    }
                }
                delay(5 * 60 * 1L)
            }
        }
    }
}