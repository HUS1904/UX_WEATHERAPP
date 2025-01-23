package dk.shape.dtu.stateincompose

import dk.shape.dtu.weatherApp.screen.formatDay
import dk.shape.dtu.weatherApp.screen.formatTimeFromTimestamp
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
}
