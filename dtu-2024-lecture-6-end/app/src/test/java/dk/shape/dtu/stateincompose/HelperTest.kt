package dk.shape.dtu.stateincompose

import androidx.compose.runtime.Composable
import dk.shape.dtu.weatherApp.view.formatDay
import dk.shape.dtu.weatherApp.view.formatTimeFromTimestamp
import dk.shape.dtu.weatherApp.view.getCityTime
import dk.shape.dtu.weatherApp.view.getCurrentWeatherIconResource
import org.junit.Assert.assertEquals
import org.junit.Test

class HelperTest {
    @Test
    fun formatDayNull() {
        assertEquals(formatDay(null), "--")
    }

    @Test
    fun formatDayProper() {
        assertEquals(formatDay(123), "Thu")
    }

    @Test
    fun formatTimeFromTimeStampTest() {
        assertEquals(formatTimeFromTimestamp(123, 456), "01:09")
    }

    @Test
    fun getCityTimeTest() {
        assertEquals(getCityTime(12), "21:35")
    }
}