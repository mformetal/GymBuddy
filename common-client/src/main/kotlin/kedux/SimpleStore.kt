package kedux

import kotlin.properties.Delegates

open class SimpleStore<S : State>(initialState: S,
                                  private val subscribers: MutableList<StateChangeListener<S>> = mutableListOf()) : Store<S> {

    override var state by Delegates.observable(initialState) { _, _, _ ->
        notifySubscribers()
    }

    init {
        notifySubscribers()
    }

    private fun notifySubscribers() {
        subscribers.forEach { it.invoke(state) }
    }

    override fun subscribe(stateChangeListener: StateChangeListener<S>) {
        subscribers.add(stateChangeListener)
    }

    override fun unsubscribe(stateChangeListener: StateChangeListener<S>) {
        subscribers.remove(stateChangeListener)
    }
}