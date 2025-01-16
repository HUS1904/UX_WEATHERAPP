package dk.shape.dtu.weatherApp.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00060\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b\u00a8\u0006!"}, d2 = {"Ldk/shape/dtu/weatherApp/viewModel/CitiesListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_favoriteCities", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "previewUvIndex", "", "getPreviewUvIndex", "()Landroidx/lifecycle/MutableLiveData;", "previewWeather", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "getPreviewWeather", "setPreviewWeather", "(Landroidx/lifecycle/MutableLiveData;)V", "savedCities", "", "getSavedCities", "searchQuery", "kotlin.jvm.PlatformType", "getSearchQuery", "addCityToList", "", "newCityWeather", "isFavorite", "cityName", "onSearchQueryChanged", "query", "removeCityFromSaved", "weatherResponse", "toggleFavorite", "app_debug"})
public final class CitiesListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> previewWeather;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> previewUvIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<dk.shape.dtu.weatherApp.model.data.WeatherResponse>> savedCities = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Boolean>> _favoriteCities = null;
    
    public CitiesListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> getPreviewWeather() {
        return null;
    }
    
    public final void setPreviewWeather(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Double> getPreviewUvIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<dk.shape.dtu.weatherApp.model.data.WeatherResponse>> getSavedCities() {
        return null;
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
    }
    
    public final boolean isFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
        return false;
    }
    
    public final void removeCityFromSaved(@org.jetbrains.annotations.NotNull()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse weatherResponse) {
    }
    
    public final void addCityToList(@org.jetbrains.annotations.Nullable()
    dk.shape.dtu.weatherApp.model.data.WeatherResponse newCityWeather) {
    }
}