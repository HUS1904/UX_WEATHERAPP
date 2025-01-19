package dk.shape.dtu.weatherApp.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import dk.shape.dtu.weatherApp.model.data.CitiesList
import dk.shape.dtu.weatherApp.viewModel.CitiesListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitiesListScreen(
    navController: NavController,
    viewModel: CitiesListViewModel,
) {

    val searchQuery by viewModel.searchQuery.observeAsState("")
    val previewWeather by viewModel.previewWeather.observeAsState()
    val previewUvIndex by viewModel.previewUvIndex.observeAsState()
    val citiesWeather by CitiesList.citiesWeather.observeAsState(emptyMap())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Saved Cities",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFFE2376C)
                        )
                    }
                },
                modifier = Modifier.padding(9.dp),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF282828))
            )
        },
        containerColor = Color(0xFF282828)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFF383838), shape = MaterialTheme.shapes.extraLarge)
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = { viewModel.onSearchQueryChanged(it) },
                    placeholder = {
                        Text(
                            "Search for a city",
                            color = Color.Gray,
                            fontSize = 17.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Color(0xFFFFFFFF)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }

            // Preview Weather
            previewWeather?.let { weather ->
                CitySearchResult(
                    weatherResponse = weather,
                    onAddCity = { CitiesList.addCityToList(weather) },
                    isPreview = true
                )
            }

            // Combined List with Favorites first
            val favoriteCities = citiesWeather.keys.filter { it.city?.name?.let { CitiesList.isFavourite(it) } == true }.toList()
            val otherCities = citiesWeather.keys.filter { it.city?.name?.let { CitiesList.isFavourite(it) } == false }.toList()

            // Combined list where favorites come first
            val combinedCities = favoriteCities + otherCities

            if (combinedCities.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(combinedCities) { weatherResponse ->
                        CityItem(
                            weatherResponse = weatherResponse,
                            uvIndex = previewUvIndex,
                            onCityClick = { cityName ->
                                navController.navigate("weatherScreen/$cityName")
                            },
                            onCityRemove = { removedCity ->
                                CitiesList.removeCityFromList(removedCity)
                            }
                        )
                    }
                }
            }
        }
    }
}