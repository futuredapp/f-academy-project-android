package app.futured.androidprojecttemplate.ui.screens.detail

import app.futured.androidprojecttemplate.tools.arch.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    override val viewState: DetailViewState,
) : BaseViewModel<DetailViewState>(), Detail.Actions {

    override fun navigateBack() {
        sendEvent(NavigateBackEvent)
    }

    override fun incrementCounter() {
        viewState.counter++
    }
}
