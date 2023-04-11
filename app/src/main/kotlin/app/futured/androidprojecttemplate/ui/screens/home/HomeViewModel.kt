package app.futured.androidprojecttemplate.ui.screens.home

import app.futured.androidprojecttemplate.tools.arch.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override val viewState: HomeViewState,
) : BaseViewModel<HomeViewState>(), Home.Actions {

    override fun incrementCounter() {
        viewState.counter++
    }

    override fun navigateToDetailScreen() {
        sendEvent(NavigateToDetailEvent)
    }
}
