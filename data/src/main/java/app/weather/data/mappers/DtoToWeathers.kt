package app.weather.data.mappers

import app.weather.data.entities.Weather
import app.weather.metaweather.dto.WeatherResponseDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DtoToWeathers @Inject constructor() : Mapper<WeatherResponseDto, List<Weather>> {
    override suspend fun map(from: WeatherResponseDto): List<Weather> {
        return from.consolidatedWeather.take(2)
            .map {
                Weather(
                    stateName = it.stateName,
                    currentTemperature = it.temperature.toInt().toString(),
                    iconAbbr = it.iconAbbr,
                    humidity = it.humidity
                )
            }
    }
}
