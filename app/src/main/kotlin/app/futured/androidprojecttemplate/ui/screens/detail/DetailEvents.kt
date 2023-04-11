package app.futured.androidprojecttemplate.ui.screens.detail

import app.futured.arkitekt.core.event.Event

sealed class DetailEvents : Event<DetailViewState>()
object NavigateBackEvent : DetailEvents()
