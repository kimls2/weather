package app.weather.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import app.weather.ReduxViewModel
import app.weather.domain.interactors.SearchWeather
import app.weather.util.ObservableLoadingCounter
import kotlinx.coroutines.launch

class HomeFragmentViewModel @ViewModelInject constructor(
    private val searchWeather: SearchWeather
) : ReduxViewModel<HomeFragmentViewState>(
    HomeFragmentViewState()
) {
    private val loadingState = ObservableLoadingCounter()

    init {
        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(loading = it) }
        }
        viewModelScope.launch {
            searchWeather.observe().collectAndSetState { copy(locationWeathers = it) }
        }
        viewModelScope.launch {
            val job = launch {
                loadingState.addLoader()
                searchWeather(SearchWeather.Params(query = "se"))
            }
            job.invokeOnCompletion { loadingState.removeLoader() }
            job.join()
        }
    }
}
