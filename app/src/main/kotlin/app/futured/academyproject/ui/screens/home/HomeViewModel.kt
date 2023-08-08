package app.futured.academyproject.ui.screens.home

import app.futured.academyproject.tools.arch.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override val viewState: HomeViewState,
) : BaseViewModel<HomeViewState>(), Home.Actions {

    init {
        loadCulturalPlaces()
    }

    private fun loadCulturalPlaces() {
        //TODO load somehow data by usecase and pass them to viewstate so they will be shown in UI
    }

    // this is action from UI so it overrides method from Home.Actions interface
    override fun navigateToDetailScreen(placeId: Int) {
        sendEvent(NavigateToDetailEvent(placeId))
    }
}
