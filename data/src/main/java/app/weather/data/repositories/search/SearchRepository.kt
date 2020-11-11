package app.weather.data.repositories.search

import app.weather.data.entities.Location
import app.weather.data.entities.Success
import app.weather.data.entities.Weather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(
    private val searchStore: SearchStore,
    private val searchDataSource: SearchDataSource
) {
    suspend fun search(query: String): List<Pair<Location, List<Weather>>> {
        if (query.isBlank()) {
            return emptyList()
        }
        val cacheValues = searchStore.getResults(query)
        if (cacheValues != null) {
            return cacheValues
        }
        when (val searchResult = searchDataSource.search(query)) {
            is Success -> {
                return searchResult.data.map { location ->
                    val locationResult = searchDataSource.location(location)
                    if (locationResult is Success) {
                        return@map Pair(location, locationResult.data)
                    } else {
                        return emptyList()
                    }
                }
            }
            else -> return emptyList()
        }
    }
}
