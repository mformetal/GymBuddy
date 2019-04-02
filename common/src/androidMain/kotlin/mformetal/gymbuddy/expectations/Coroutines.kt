package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

actual fun launchBlocking(block: suspend (scope : CoroutineScope) -> Unit) = runBlocking(Dispatchers.Default) { block(this) }

actual fun launchBackground(block: suspend (scope: CoroutineScope) -> Unit) = runBlocking(Dispatchers.IO) { block(this) }

actual val applicationDispatcher: CoroutineDispatcher = Dispatchers.Default