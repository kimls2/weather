package app.weather.data.entities

data class Weather(
    val stateName: String,
    val currentTemperature: String,
    val iconAbbr: String,
    val humidity: Int
)
