package mformetal.kedux

/**
 * Dispatches actions with [Reducer]s and updates the state in the [Store]. You can chain [Middleware]
 * to implement cross-cutting concerns.
 *
 * @param <A> The action type.
 * @param <R> The return type of the dispatcher. This is implementation-defined.
</R></A> */
abstract class Dispatcher<A, R> {

    /**
     * Dispatches the given action.
     */
    abstract fun dispatch(action: A): R

    /**
     * Returns a new [Dispatcher] that runs the given [Middleware].
     */
    fun chain(middleware: Middleware<A, R>): Dispatcher<A, R> {
        return object : Dispatcher<A, R>() {
            override fun dispatch(action: A): R {
                return middleware.dispatch(object : Middleware.Next<A, R> {
                    override fun next(action: A): R {
                        return this@Dispatcher.dispatch(action)
                    }
                }, action)
            }
        }
    }

    /**
     * Returns a new `Dispatcher` that runs the given collection of [Middleware].
     */
    fun chain(middleware: Iterable<Middleware<A, R>>): Dispatcher<A, R> {
        return chain(middleware.iterator())
    }

    /**
     * Returns a new `Dispatcher` that runs the given collection of [Middleware].
     */
    fun chain(vararg middleware: Middleware<A, R>): Dispatcher<A, R> {
        return chain(*middleware)
    }

    fun chain(itr: Iterator<Middleware<A, R>>): Dispatcher<A, R> {
        return if (itr.hasNext()) {
            chain(itr.next()).chain(itr)
        } else {
            this
        }
    }

    companion object {

        /**
         * Constructs a `Dispatcher` from the given [Store] and [Reducer]. [.dispatch] will
         * run the action through the reducer and update the store with the resulting state.
         *
         * @param <S> The type of state in the store.
         * @param <A> The type of action.
         * @return the action dispatched.
        </A></S> */
        fun <S, A> forStore(store: Store<S>, reducer: Reducer<A, S>): Dispatcher<A, A> {
            return object : Dispatcher<A, A>() {
                override fun dispatch(action: A): A {
                    store.state = reducer.reduce(action, store.state)
                    return action
                }
            }
        }
    }
}
