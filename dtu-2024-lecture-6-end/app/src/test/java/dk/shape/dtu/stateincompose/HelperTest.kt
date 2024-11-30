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
        val timezoneOffset = 12
        val calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.add(java.util.Calendar.SECOND, timezoneOffset)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        assertEquals(getCityTime(timezoneOffset), timeFormat.format(calendar.time))
    }
}
