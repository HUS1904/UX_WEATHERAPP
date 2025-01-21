package dk.shape.dtu.weatherApp.utils
import kotlin.math.ln

data class HumidityInfo(
    val humidity: Int,
    val dewPoint: Double
)
// WeatherUtils.kt (in a 'utils' or 'domain' package)
fun calculateDewPoint(humidity: Int, tempKelvin: Double): Double {
    val a = 17.27
    val b = 237.7
    val currentTempCelsius = tempKelvin - 273.15
    val alpha = (a * currentTempCelsius) / (b + currentTempCelsius) + ln(humidity / 100.0)
    return (b * alpha) / (a - alpha)
}
