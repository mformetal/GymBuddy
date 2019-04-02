package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import mformetal.gymbuddy.expectations.ExpectedDispatchers
import mformetal.gymbuddy.expectations.createActor
import mformetal.gymbuddy.kedux.Store
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class CoroutinesStore<S : Any>(initialState: S) {

    private val stateChannel = Channel<S>(Channel.UNLIMITED).apply {
        offer(initialState)
    }

    suspend fun observe(onStateReceived: suspend (S) -> Unit) {
        stateChannel.consumeEach { newState ->
            onStateReceived(newState)
        }
    }

    fun update(state: S) = stateChannel.offer(state)
}