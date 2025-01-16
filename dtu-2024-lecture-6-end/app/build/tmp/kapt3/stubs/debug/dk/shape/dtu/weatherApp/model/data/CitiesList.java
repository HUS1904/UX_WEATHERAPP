package dk.shape.dtu.weatherApp.model.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Ldk/shape/dtu/weatherApp/model/data/CitiesList;", "", "()V", "citiesWeather", "Landroidx/lifecycle/MutableLiveData;", "", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "", "getCitiesWeather", "()Landroidx/lifecycle/MutableLiveData;", "addCityToList", "", "newCityWeather", "isFavourite", "cityName", "", "removeCityFromList", "weatherResponse", "toggleFavourite", "app_debug"})
public final class CitiesList {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.lifecycle.MutableLiveData<java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean>> citiesWeather = null;
    @org.jetbrains.annotations.NotNull()
    public static final dk.shape.dtu.weatherApp.model.data.CitiesList INSTANCE = null;
    
    private CitiesList() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.Map<dk.shape.dtu.weatherApp.model.data.WeatherResponse, java.lang.Boolean>> getCitiesWeather() {
        return null;
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
}