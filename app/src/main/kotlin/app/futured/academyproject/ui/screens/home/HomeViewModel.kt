package app.futured.academyproject.ui.screens.home

import app.futured.academyproject.domain.GetCulturalPlacesUseCase
import app.futured.academyproject.tools.arch.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override val viewState: HomeViewState,
    private val getCulturalPlacesUseCase: GetCulturalPlacesUseCase,
) : BaseViewModel<HomeViewState>(), Home.Actions {

    init {
        loadCulturalPlaces()
    }

    private fun loadCulturalPlaces() {
        getCulturalPlacesUseCase.execute {
            onSuccess {
                Timber.d("Cultural places: $it")

                viewState.places = viewState.places.run {
                    clear()
                    addAll(it)
                }
            }
            onError {
                Timber.e(it)
            }
        }
    }

    override fun navigateToDetailScreen(placeId: Int) {
        sendEvent(NavigateToDetailEvent(placeId))
    }
}
