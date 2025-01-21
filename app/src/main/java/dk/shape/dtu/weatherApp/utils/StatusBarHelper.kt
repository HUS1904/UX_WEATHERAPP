package dk.shape.dtu.weatherApp.utils

import android.graphics.Color
import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat

fun setStatusBarColor(window: Window, color: String = "#282828", isLightIcons: Boolean = false) {
    window.statusBarColor = Color.parseColor(color)
    WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLightIcons
}
