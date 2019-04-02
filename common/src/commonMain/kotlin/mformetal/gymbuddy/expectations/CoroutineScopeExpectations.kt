package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlin.coroutines.CoroutineContext

expect interface ActorScope<S> {

    val channel : Channel<S>
}

expect fun <S> CoroutineScope.createActor(context: CoroutineContext,
                                          capacity: Int = 0,
                                          start: CoroutineStart = CoroutineStart.DEFAULT,
                                          onCompletionHandler: CompletionHandler? = null,
                                          block: suspend ActorScope<S>.() -> Unit) : SendChannel<S>