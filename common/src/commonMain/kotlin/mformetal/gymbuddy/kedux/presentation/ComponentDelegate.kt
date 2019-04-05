package mformetal.gymbuddy.kedux.presentation

import mformetal.gymbuddy.kedux.state.AppState

interface ComponentDelegate<S : Any> {

    val componentController: ComponentController<S>

    fun onViewCreated() {

    }

    fun onViewDestroyed() {

    }


    fun listen(onStateChanged: (S) -> Unit)
}