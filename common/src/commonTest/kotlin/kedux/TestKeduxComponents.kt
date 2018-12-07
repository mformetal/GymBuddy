package kedux

class SimpleState(val ordinal: Int)

sealed class SimpleEvents {
    object EventOne : SimpleEvents()
    object EventTWo : SimpleEvents()
}

class SimpleReducer : Reducer<SimpleEvents, SimpleState> {
    override fun reduce(action: SimpleEvents, state: SimpleState): SimpleState {
        return when (action) {
            is SimpleEvents.EventOne -> SimpleState(1)
            is SimpleEvents.EventTWo -> SimpleState(2)
        }
    }
}