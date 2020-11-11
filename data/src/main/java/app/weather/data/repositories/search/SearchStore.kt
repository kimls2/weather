package app.weather.data.repositories.search

import androidx.collection.LruCache
import app.weather.data.entities.Location
import app.weather.data.entities.Weather
import javax.inject.Inject

class SearchStore @Inject constructor() {
    private val cache = LruCache<String, List<Pair<Location, List<Weather>>>>(32)

    fun getResults(query: String) = cache[query]

    fun setResults(query: String, results: List<Pair<Location, List<Weather>>>) {
        cache.put(query, results)
    }
}
