package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import mformetal.gymbuddy.kedux.Store
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class CoroutinesStore<S : Any>(initialState: S) {

    private val stateStream = ConflatedBroadcastChannel<S>().apply {
        offer(initialState)
    }

    val state : S
        get() = stateStream.value

    fun update(state: S) = stateStream.offer(state)

    fun subscribe() : ReceiveChannel<S> = stateStream.openSubscription()

}