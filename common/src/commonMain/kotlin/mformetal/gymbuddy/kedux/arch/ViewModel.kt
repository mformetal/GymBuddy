package mformetal.gymbuddy.kedux.arch

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.distinct

open class ViewModel<S : Any>(protected val store: Store<S>,
                              protected val mainDispatcher: CoroutineDispatcher,
                              protected val ioDispatcher: CoroutineDispatcher) : CoroutineScope by ViewModelScope(ioDispatcher) {

    private var job : Job ?= null

    fun subscribe(onStateChanged: (S) -> Unit) {
        job = launch {
            store.states
                    .distinct()
                    .consumeEach { newState ->
                        withContext(mainDispatcher) {
                            onStateChanged(newState)
                        }
                    }
        }
    }

    fun unsubscribe() {
        job?.cancel()
        job = Job()
    }

    fun destroy() {
        coroutineContext.cancelChildren()
    }
}