package mformetal.gymbuddy.viewbinding

import mformetal.gymbuddy.kedux.v2.presentation.ComponentDelegate

abstract class AndroidComponentDelegate : ComponentDelegate {

    protected val delegatedViewFinder = DelegatedViewPropertyProvider()

    fun bind(viewFinder: ViewFinder) {
        delegatedViewFinder.bind(viewFinder)

        onViewsBound()
    }

    abstract fun onViewsBound()
}