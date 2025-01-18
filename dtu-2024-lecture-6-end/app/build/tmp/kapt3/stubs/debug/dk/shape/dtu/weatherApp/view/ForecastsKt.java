package dk.shape.dtu.weatherApp.view;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007\u001a\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u00a8\u0006\u0011"}, d2 = {"HourlyForecast", "", "forecasts", "", "Ldk/shape/dtu/weatherApp/model/data/WeatherData;", "weatherData", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "WeeklyForecast", "getHourlyWeatherIconResource", "", "description", "", "forecastTime", "", "sunrise", "sunset", "getWeeklyWeatherIconResource", "app_debug"})
public final class ForecastsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HourlyForecast(@org.jetbrains.annotations.NotNull()
    java.util.List<dk.shape.dtu.weatherApp.model.data.WeatherData> forecasts, @org.jetbrains.annotations.Nullable()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse weatherData) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final int getHourlyWeatherIconResource(@org.jetbrains.annotations.Nullable()
    java.lang.String description, long forecastTime, long sunrise, long sunset) {
        return 0;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void WeeklyForecast(@org.jetbrains.annotations.NotNull()
    java.util.List<dk.shape.dtu.weatherApp.model.data.WeatherData> forecasts) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final int getWeeklyWeatherIconResource(@org.jetbrains.annotations.Nullable()
    java.lang.String description) {
        return 0;
    }
}