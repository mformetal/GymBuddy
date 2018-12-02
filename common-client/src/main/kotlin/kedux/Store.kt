package kedux

/**
 * Stores your immutable state and allows you to dispatch actions to change it. Note: if you plan
 * on dispatching from multiple threads, [.getState] and [.setState] must be
 * thread-safe.
 */
interface Store<S> {

    /**
     * Returns the current state of the store.
     */
    /**
     * Sets the state of the store. Warning! You should not call this in normal application code,
     * instead preferring to update it through dispatching an action. It is however, useful for
     * tests.
     */
    var state: S
}
