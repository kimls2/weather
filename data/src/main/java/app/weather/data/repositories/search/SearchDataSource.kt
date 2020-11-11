package app.weather.data.repositories.search

import app.weather.data.entities.ErrorResult
import app.weather.data.entities.Location
import app.weather.data.entities.Result
import app.weather.data.entities.Weather
import app.weather.data.mappers.DtoToLocation
import app.weather.data.mappers.DtoToWeathers
import app.weather.extensions.executeWithRetry
import app.weather.extensions.toResult
import app.weather.metaweather.api.WeatherApi
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    private val weatherApi: WeatherApi,
    private val mapper: DtoToLocation,
    private val weatherMapper: DtoToWeathers
) {
    suspend fun search(query: String): Result<List<Location>> = try {
        weatherApi.search(query)
            .executeWithRetry()
            .toResult(mapper::map)
    } catch (t: Throwable) {
        ErrorResult(t)
    }

    suspend fun location(location: Location): Result<List<Weather>> = try {
        weatherApi.location(location.id)
            .executeWithRetry()
            .toResult(weatherMapper::map)
    } catch (t: Throwable) {
        ErrorResult(t)
    }
}
