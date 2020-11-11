package app.weather.data.mappers

import app.weather.data.entities.Location
import app.weather.metaweather.dto.LocationDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DtoToLocation @Inject constructor() : Mapper<List<LocationDto>, List<Location>> {
    override suspend fun map(from: List<LocationDto>): List<Location> {
        return from.map {
            Location(
                id = it.woeid,
                title = it.title,
            )
        }
    }
}
