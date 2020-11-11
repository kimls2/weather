@file:Suppress("NOTHING_TO_INLINE")

package app.weather.common.compose

import androidx.compose.runtime.Composable
import com.google.android.material.composethemeadapter.MdcTheme

/**
 * Just groups some common Compose content setup
 */
@Composable
inline fun WeatherContentSetup(noinline content: @Composable () -> Unit) {
    MdcTheme {
        content()
    }
}
