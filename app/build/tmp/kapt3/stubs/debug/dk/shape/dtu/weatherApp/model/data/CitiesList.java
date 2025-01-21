package dk.shape.dtu.weatherApp.model.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0006J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0015R,\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Ldk/shape/dtu/weatherApp/model/data/CitiesList;", "", "()V", "citiesWeather", "Landroidx/lifecycle/MutableLiveData;", "", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "", "getCitiesWeather", "()Landroidx/lifecycle/MutableLiveData;", "setCitiesWeather", "(Landroidx/lifecycle/MutableLiveData;)V", "json", "Lkotlinx/serialization/json/Json;", "sharedPreferences", "Landroid/content/SharedPreferences;", "addCityToList", "", "newCityWeather", "decodeWeatherData", "cachedData", "", "initialize", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isFavourite", "cityName", "removeCityFromList", "weatherResponse", "saveCitiesWeatherToPreferences", "toggleFavourite", "app_debug"})
public final class CitiesList {
    public static androidx.lifecycle.MutableLiveData<java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean>> citiesWeather;
    private static android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.serialization.json.Json json = null;
    @org.jetbrains.annotations.NotNull()
    public static final dk.shape.dtu.weatherApp.model.data.CitiesList INSTANCE = null;
    
    private CitiesList() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean>> getCitiesWeather() {
        return null;
    }
    
    public final void setCitiesWeather(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean>> p0) {
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    public final void addCityToList(@org.jetbrains.annotations.Nullable()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse newCityWeather) {
    }
    
    public final void removeCityFromList(@org.jetbrains.annotations.NotNull()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse weatherResponse) {
    }
    
    public final void toggleFavourite(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
    }
    
    public final boolean isFavourite(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
        return false;
    }
    
    private final java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean> decodeWeatherData(java.lang.String cachedData) {
        return null;
    }
    
    private final void saveCitiesWeatherToPreferences() {
    }
}