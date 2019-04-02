package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlin.coroutines.CoroutineContext

actual typealias ActorScope<S> = kotlinx.coroutines.channels.ActorScope<S>

actual fun <S> CoroutineScope.createActor(context: CoroutineContext, capacity: Int,
                                          start: CoroutineStart,
                                          onCompletionHandler: CompletionHandler?,
                                          block: suspend ActorScope<S>.() -> Unit) : SendChannel<S> =
        this.actor(context, capacity, start, onCompletionHandler, block)