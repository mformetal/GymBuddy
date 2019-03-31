package mformetal.gymbuddy.viewbinding

import mformetal.kedux.ComponentDelegate

abstract class AndroidComponentDelegate : ComponentDelegate {

    protected val delegatedViewFinder = DelegatedViewPropertyProvider()

    fun bind(viewFinder: ViewFinder) {
        delegatedViewFinder.bind(viewFinder)

        onViewsBound()
    }

    abstract fun onViewsBound()
}