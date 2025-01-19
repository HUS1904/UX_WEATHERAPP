package dk.shape.dtu.weatherApp.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\u0013R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Ldk/shape/dtu/weatherApp/viewModel/LocationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uvIndex", "Landroidx/lifecycle/MutableLiveData;", "", "_weatherData", "Ldk/shape/dtu/weatherApp/model/data/WeatherResponse;", "uvIndex", "Landroidx/lifecycle/LiveData;", "getUvIndex", "()Landroidx/lifecycle/LiveData;", "weatherData", "getWeatherData", "startFetchingWeather", "", "latitude", "longitude", "onWeatherFetched", "Lkotlin/Function1;", "app_debug"})
public final class LocationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> _weatherData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> weatherData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> _uvIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> uvIndex = null;
    
    public LocationViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dk.shape.dtu.weatherApp.model.data.WeatherResponse> getWeatherData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getUvIndex() {
        return null;
    }
    
    public final void startFetchingWeather(double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super dk.shape.dtu.weatherApp.model.data.WeatherResponse, kotlin.Unit> onWeatherFetched) {
    }
}