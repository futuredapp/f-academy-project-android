package app.futured.academyproject.tools.arch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.futured.arkitekt.core.ViewState
import app.futured.arkitekt.core.event.Event
import app.futured.arkitekt.crusecases.CoroutineScopeOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS : ViewState> : ViewModel(), CoroutineScopeOwner {
    abstract val viewState: VS

    override val coroutineScope: CoroutineScope = viewModelScope

    private val eventChannel = Channel<Event<VS>>(Channel.BUFFERED)
    val events = eventChannel
        .receiveAsFlow()
        .flowOn(Dispatchers.Main)

    fun sendEvent(event: Event<VS>) = viewModelScope.launch {
        eventChannel.send(event)
    }
}

/**
 * When [EventsEffect] enters composition, it will start observing the event flow from it's viewModel.
 * Each event sent from ViewModel goes through [observer] lambda which can be used to react to a specific event.
 * Use the [onEvent] function to filter out the event you are interested in.
 *
 * @param observer Event receiver lambda.
 */
@Composable
fun <VS : ViewState> BaseViewModel<VS>.EventsEffect(
    observer: suspend Event<VS>.() -> Unit,
) {
    LaunchedEffect(this) {
        events.collect {
            observer(it)
        }
    }
}

inline fun <reified E : Event<*>> Event<*>.onEvent(action: (E) -> Unit) {
    if (this is E) {
        action(this)
    }
}
