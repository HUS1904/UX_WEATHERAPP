package dk.shape.dtu.weatherApp.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Ldk/shape/dtu/weatherApp/viewModel/CitiesListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "previewUvIndex", "Landroidx/lifecycle/MutableLiveData;", "", "getPreviewUvIndex", "()Landroidx/lifecycle/MutableLiveData;", "previewWeather", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "getPreviewWeather", "savedCities", "", "getSavedCities", "searchQuery", "", "kotlin.jvm.PlatformType", "getSearchQuery", "onSearchQueryChanged", "", "query", "app_debug"})
public final class CitiesListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> previewWeather = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> previewUvIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<dk.shape.dtu.weatherApp.model.data.WeatherResponse>> savedCities = null;
    
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
}