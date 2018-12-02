package kedux

interface Reducer<E, S : State> {

    fun reduce(event: E, state: S) : S

}