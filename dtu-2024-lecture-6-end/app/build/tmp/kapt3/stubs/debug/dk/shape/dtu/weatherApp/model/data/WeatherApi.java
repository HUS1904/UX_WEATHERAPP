package dk.shape.dtu.weatherApp.model.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\tH\'J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\tH\'J6\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\tH\'\u00a8\u0006\u000f"}, d2 = {"Ldk/shape/dtu/weatherApp/model/data/WeatherApi;", "", "getUvIndex", "Lretrofit2/Call;", "Ldk/shape/dtu/weatherApp/model/data/UvIndexResponse;", "lat", "", "lon", "apiKey", "", "cacheControl", "getWeather", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "city", "getWeatherByCoordinates", "app_debug"})
public abstract interface WeatherApi {
    
    @retrofit2.http.GET(value = "forecast")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<dk.shape.dtu.weatherApp.model.data.WeatherResponse> getWeather(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String city, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Header(value = "Cache-Control")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cacheControl);
    
    @retrofit2.http.GET(value = "forecast")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<dk.shape.dtu.weatherApp.model.data.WeatherResponse> getWeatherByCoordinates(@retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Header(value = "Cache-Control")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cacheControl);
    
    @retrofit2.http.GET(value = "uvi")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<dk.shape.dtu.weatherApp.model.data.UvIndexResponse> getUvIndex(@retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Header(value = "Cache-Control")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cacheControl);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}