import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dk.shape.dtu.weatherApp.model.data.WeatherApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.File

@SuppressLint("StaticFieldLeak")
object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private var context: Context? = null

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    @SuppressLint("StaticFieldLeak")
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    val api: WeatherApi by lazy {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        val cacheDir = File(context?.cacheDir, "http_cache")
        val cache = Cache(cacheDir, cacheSize)

        val cachingInterceptor = Interceptor { chain ->
            val request = chain.request()
            val updatedRequest = if (context?.isNetworkAvailable() == false) {
                request.newBuilder()
                    .header("Cache-Control", "only-if-cached, max-stale=${60 * 60 * 24}") // Cache to 24 hours
                    .build()
            } else {
                request.newBuilder()
                    .header("Cache-Control", "public, max-age=${60 * 60}") // Cache 1 hour
                    .build()
            }
            chain.proceed(updatedRequest)
        }

        val client = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(cachingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(WeatherApi::class.java)
    }
}


fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
