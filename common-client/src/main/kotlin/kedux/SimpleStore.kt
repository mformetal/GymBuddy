package kedux

import kotlin.jvm.Volatile

/**
 * A thread-safe store that allows you to attach and remove listeners for when the state changes.
 */
open class SimpleStore<S>(initialState: S) : Store<S> {

    @Volatile
    override var state: S = initialState
        set(newState) {
            if (field != newState) {
                field = newState
                notifyListeners()
            }
        }
    private val listeners = mutableListOf<Listener<S>>()

    /**
     * Registers as listener to receive state changes. The current state will be delivered
     * immediately.
     */
    fun addListener(listener: Listener<S>) {
        listeners.add(listener)
        notifyListeners()
    }

    /**
     * Removes the listener so it no longer receives state changes.
     */
    fun removeListener(listener: Listener<S>) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach {
            it.onNewState(state)
        }
    }

    interface Listener<S> {
        /**
         * Called when a new state is set. This is called on the same thread as  or [.setState].
         */
        fun onNewState(state: S?)
    }
}

