package kedux

interface Store<S : State> {

    var state: S

    fun subscribe(stateChangeListener: StateChangeListener<S>)

    fun unsubscribe(stateChangeListener: StateChangeListener<S>)
}
