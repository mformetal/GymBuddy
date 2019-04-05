package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.distinct

class ViewModel<S : Any>(private val store: Store<S>,
                         private val mainDispatcher: CoroutineDispatcher,
                         ioDispatcher: CoroutineDispatcher) : CoroutineScope by ViewModelScope(ioDispatcher) {

    private val channel: ReceiveChannel<S> ?= null
    private var job: Job ?= null

    fun start(onStateChanged: (S) -> Unit) {
        job = launch {
            store.receiveChannel
                    .distinct()
                    .consumeEach { newState ->
                        withContext(mainDispatcher) {
                            onStateChanged(newState)
                        }
                    }
        }
    }

    fun stop() {
        channel?.cancel()
        job?.cancel()
    }

    fun destroy() {
        coroutineContext.cancelChildren()
    }
}