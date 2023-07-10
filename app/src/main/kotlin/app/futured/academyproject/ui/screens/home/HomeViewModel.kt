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
        // load places for viewState
    }

    override fun navigateToDetailScreen(placeId: Int) {
        sendEvent(NavigateToDetailEvent(placeId))
    }
}
