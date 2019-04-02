package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.channels.ActorScope
import kotlinx.coroutines.channels.ReceiveChannel
import mformetal.gymbuddy.expectations.ActorScope
import kotlin.coroutines.CoroutineContext

actual typealias ActorScope<S> = ActorScope<S>

actual fun <S> CoroutineScope.actor(context: kotlin.coroutines.CoroutineContext, capacity: Int, start: kotlinx.coroutines.CoroutineStart, onCompletionHandler: kotlinx.coroutines.CompletionHandler?, block: suspend mformetal.gymbuddy.expectations.ActorScope<S>.() -> Unit) {
}