package dk.shape.dtu.weatherApp.view;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a>\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"AppContent", "", "navController", "Landroidx/navigation/NavController;", "weatherData", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "uvIndex", "", "City", "cityName", "", "viewModel", "Ldk/shape/dtu/weatherApp/viewModel/CityViewModel;", "Location", "latitude", "longitude", "Ldk/shape/dtu/weatherApp/viewModel/LocationViewModel;", "onWeatherFetched", "Lkotlin/Function1;", "app_debug"})
public final class AppContentKt {
    
    @androidx.compose.runtime.Composable()
    public static final void AppContent(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse weatherData, double uvIndex) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Location(double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    dk.shape.dtu.weatherApp.viewModel.LocationViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super dk.shape.dtu.weatherApp.model.data.WeatherResponse, kotlin.Unit> onWeatherFetched) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void City(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    dk.shape.dtu.weatherApp.viewModel.CityViewModel viewModel) {
    }
}