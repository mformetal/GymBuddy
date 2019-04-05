package mformetal.gymbuddy.viewbinding

import mformetal.gymbuddy.kedux.presentation.ComponentDelegate

abstract class AndroidComponentDelegate<S : Any> : ComponentDelegate<S> {

    protected val delegatedViewFinder = DelegatedViewPropertyProvider()

    fun bind(viewFinder: ViewFinder) {
        delegatedViewFinder.bind(viewFinder)

        onViewsBound()
    }

    abstract fun onViewsBound()
}