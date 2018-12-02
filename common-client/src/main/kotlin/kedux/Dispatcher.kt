package kedux

interface Dispatcher<E, A> {

    fun dispatch(event: E) : A

}

class SimpleDispatcher<E, S: State>(val store: Store<S>,
                                            val reducer: Reducer<E, S>) : Dispatcher<E, E> {

    override fun dispatch(event: E) : E {
        store.state = reducer.reduce(event, store.state)
        return event
    }
}


object Dispatchers {

    fun <E, S: State> create(store: Store<S>, reducer: Reducer<E, S>) : Dispatcher<E, E> {
        return SimpleDispatcher(store, reducer)
    }
}