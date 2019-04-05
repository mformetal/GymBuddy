package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.channels.*

class Store<S : Any>(initialState: S) {

    private val sendChannel = Channel<S>(Channel.UNLIMITED).apply {
        offer(initialState)
    }

    val receiveChannel: ReceiveChannel<S> = sendChannel

    fun update(state: S) = sendChannel.offer(state)
}