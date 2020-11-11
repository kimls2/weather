@file:Suppress("UNUSED_PARAMETER")

package app.weather.home

import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.weather.data.entities.Location
import app.weather.data.entities.Weather
import dev.chrisbanes.accompanist.coil.CoilImage

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun Home(state: HomeFragmentViewState) {
    if (state.locationWeathers.isEmpty()) {
        Box(alignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Box(Modifier.fillMaxSize()) {
            LazyColumn(Modifier.fillMaxSize()) {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = "Local",
                            modifier = Modifier.preferredWidth(50.dp).border(
                                width = 0.5.dp,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                                shape = RectangleShape
                            ),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Today",
                            modifier = Modifier.weight(1f, fill = true).border(
                                width = 0.5.dp,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                                shape = RectangleShape
                            ),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Tomorrow",
                            modifier = Modifier.weight(1f, fill = true).border(
                                width = 0.5.dp,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                                shape = RectangleShape
                            ),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                item {
                    Divider()
                }

                state.locationWeathers.forEach {
                    item {
                        ResultRow(result = it)
                        Divider()
                    }
                }
            }
        }
    }
}

@Composable
private fun ResultRow(result: Pair<Location, List<Weather>>) {
    Row(Modifier.fillMaxWidth().preferredHeight(70.dp)) {
        Text(
            modifier = Modifier.size(50.dp, 70.dp).border(
                width = 0.5.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                shape = RectangleShape
            ).alignByBaseline(),
            text = result.first.title,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier.weight(1f, fill = true)
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    shape = RectangleShape
                )
        ) {
            WeatherItem(weather = result.second[0])
        }
        Box(
            modifier = Modifier.weight(1f, fill = true)
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    shape = RectangleShape
                )
        ) {
            WeatherItem(weather = result.second[1])
        }
    }
}

@Composable
private fun WeatherItem(weather: Weather) {
    Row {
        WeatherIcon(weather = weather)
        WeatherStatusColumn(
            weather = weather,
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun WeatherIcon(weather: Weather) {
    Box(Modifier.padding(8.dp)) {
        val imageUrl =
            "https://www.metaweather.com/static/img/weather/png/64/${weather.iconAbbr}.png"
        CoilImage(
            data = imageUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier.preferredSize(64.dp)
        )
    }

}

@Composable
private fun WeatherStatusColumn(weather: Weather, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = weather.stateName,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.preferredHeight(8.dp))
        Row {
            Text(
                text = weather.currentTemperature + "\u2103",
                color = Color.Red
            )
            Spacer(Modifier.preferredWidth(8.dp))
            Text(
                text = "${weather.humidity}%",
                fontWeight = FontWeight.Medium
            )
        }
    }
}
