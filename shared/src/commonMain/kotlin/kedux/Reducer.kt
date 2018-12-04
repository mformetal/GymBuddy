package kedux

/**
 * A reducer takes in an action and the current state and returns a new state as a result. The
 * incoming state must be treated as immutable.
 *
 * @param <A> the action type.
 * @param <S> the state type.
</S></A> */
interface Reducer<A, S> {

    fun reduce(action: A, state: S): S

}
