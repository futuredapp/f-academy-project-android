package app.futured.academyproject.ui.screens.home

import app.futured.arkitekt.core.event.Event

sealed class HomeEvents : Event<HomeViewState>()

object NavigateToDetailEvent : HomeEvents()
