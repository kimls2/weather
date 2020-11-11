package app.weather.metaweather.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("consolidated_weather") val consolidatedWeather: List<WeatherDto>
)

data class WeatherDto(
    @SerializedName("weather_state_name") val stateName: String,
    @SerializedName("the_temp") val temperature: Double,
    @SerializedName("weather_state_abbr") val iconAbbr: String,
    @SerializedName("humidity") val humidity: Int
)
