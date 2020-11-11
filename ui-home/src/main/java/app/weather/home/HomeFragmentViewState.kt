package app.weather.home

import androidx.compose.runtime.Immutable
import app.weather.data.entities.Location
import app.weather.data.entities.Weather

@Immutable
data class HomeFragmentViewState(
    val loading: Boolean = false,
    val locationWeathers: List<Pair<Location, List<Weather>>> = emptyList()
)
