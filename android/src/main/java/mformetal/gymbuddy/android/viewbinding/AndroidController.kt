package mformetal.gymbuddy.android.viewbinding

import mformetal.gymbuddy.kedux.presentation.ComponentController
import mformetal.gymbuddy.kedux.state.AppState

abstract class AndroidController : ComponentController<AppState> {

    protected val delegatedViewFinder = DelegatedViewPropertyProvider()

    override fun bind(view: Any) {
        delegatedViewFinder.bind(view as ViewFinder)

        onViewsBound()
    }

    abstract fun onViewsBound()

}