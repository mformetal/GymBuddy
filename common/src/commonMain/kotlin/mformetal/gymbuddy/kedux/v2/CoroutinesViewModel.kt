package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import mformetal.gymbuddy.expectations.ExpectedDispatchers
import kotlin.coroutines.CoroutineContext

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class CoroutinesViewModel<S : Any>(private val store: CoroutinesStore<S>) : CoroutineScope {

    private lateinit var channel: ReceiveChannel<S>
    private val parentJob = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Default + parentJob

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @InternalCoroutinesApi
    fun observe(onStateChanged: (S) -> Unit) {
        launch(ExpectedDispatchers.io) {
            store.observe { newState ->
                withContext(ExpectedDispatchers.ui) {
                    onStateChanged(newState)
                }
            }
        }
    }

    fun destroy() {
        channel.cancel()
        parentJob.cancel()
    }
}