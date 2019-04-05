package mformetal.gymbuddy.kedux.arch

import kotlinx.coroutines.channels.*

class Store<S : Any>(initialState: S) {

    private val sendChannel = Channel<S>(Channel.UNLIMITED).apply {
        offer(initialState)
    }
    private val receiveChannel = sendChannel.broadcast()

    val states : ReceiveChannel<S>
        get() = receiveChannel.openSubscription()

    fun update(state: S) = sendChannel.offer(state)
}