package dk.shape.dtu.weatherApp.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dk.shape.dtu.weatherApp.model.data.WeatherResponse
import kotlin.math.ceil
import dk.shape.dtu.weatherApp.model.data.CitiesList

@Composable
fun CityItem(
    weatherResponse: WeatherResponse,
    uvIndex: Double?,
    onCityClick: (String) -> Unit,
    onCityRemove: (WeatherResponse) -> Unit
) {
    val city = weatherResponse.city?.name ?: "Unknown City"
    val country = weatherResponse.city?.country ?: "Unknown Country"
    val description = weatherResponse.list.firstOrNull()?.weather?.firstOrNull()?.description ?: "No data"
    val humidity = weatherResponse.list.firstOrNull()?.main?.humidity ?: 0
    val rainVolume = weatherResponse.list.firstOrNull()?.rain?.last3Hours ?: 0.0
    val time = getCityTime(weatherResponse.city?.timezone ?: 0)
    val currentTemp = weatherResponse.list.firstOrNull()?.main?.temp?.minus(273.15)?.let { ceil(it).toInt() }
    val iconResource = getCurrentWeatherIconResource(
        description = description,
        weatherData = weatherResponse,
        sunrise = weatherResponse.city?.sunrise?.toLong() ?: 0L,
        sunset = weatherResponse.city?.sunset?.toLong() ?: 0L
    )
    val tint = remember { mutableStateOf(if(CitiesList.isFavourite(city)) Color.Yellow else Color.Gray) }




    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 0.dp, vertical = 5.dp).clickable { onCityClick(city) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF383838)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.weight(1f).height(100.dp)
            ) {
                Image(
                    painter = painterResource(id = iconResource),
                    contentDescription = description,
                    modifier = Modifier.fillMaxSize().alpha(0.4f)
                )

                Column(
                    modifier = Modifier.padding(top = 14.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "$city, $country",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Time: $time",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "${currentTemp ?: "--"}°, $description",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove City",
                        tint = Color(0xFFFF0000),
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                            //.offset(x = (6).dp, y = (10).dp)
                            .clickable {
                                onCityRemove(weatherResponse)
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        imageVector = if (CitiesList.isFavourite(city)) Icons.Filled.Star else Icons.Outlined.Star,
                        contentDescription = "Star Icon",
                        tint = tint.value,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                            //.offset(x = (-24).dp, y = (-30).dp)
                            .clickable {
                                tint.value = if (tint.value == Color.Gray) Color.Yellow else Color.Gray
                                CitiesList.toggleFavourite(city) // Toggle the favorite status

                            }
                    )
                }
                Text(text = "Humidity: $humidity%", style = MaterialTheme.typography.bodySmall, color = Color.White)
                Text(text = "Rain: ${"%.1f".format(rainVolume)} mm", style = MaterialTheme.typography.bodySmall, color = Color.White)
                Text(text = "UV Index: ${"%.1f".format(uvIndex ?: 0.0)}", style = MaterialTheme.typography.bodySmall, color = Color.White)
            }
        }
    }
}


