package kedux

class SimpleState(val ordinal: Int) : State

sealed class SimpleEvents {
    class EventOne : SimpleEvents()
    class EventTWo : SimpleEvents()
}

class SimpleReducer : Reducer<SimpleEvents, SimpleState> {
    override fun reduce(event: SimpleEvents, state: SimpleState): SimpleState {
        return when (event) {
            is SimpleEvents.EventOne -> SimpleState(1)
            is SimpleEvents.EventTWo -> SimpleState(2)
        }
    }
}