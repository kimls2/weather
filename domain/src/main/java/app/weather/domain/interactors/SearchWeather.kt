package app.weather.domain.interactors

import app.weather.data.entities.Location
import app.weather.data.entities.Weather
import app.weather.data.repositories.search.SearchRepository
import app.weather.domain.SuspendingWorkInteractor
import app.weather.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchWeather @Inject constructor(
    private val searchRepository: SearchRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SuspendingWorkInteractor<SearchWeather.Params, List<Pair<Location, List<Weather>>>>() {
    data class Params(val query: String)

    override suspend fun doWork(params: Params): List<Pair<Location, List<Weather>>> {
        return withContext(dispatchers.io) {
            searchRepository.search(params.query)
        }
    }
}
