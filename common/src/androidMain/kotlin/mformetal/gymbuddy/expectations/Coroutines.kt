package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

actual fun runTest(block: suspend (scope : CoroutineScope) -> Unit) = runBlocking { block(this) }

actual object ExpectedDispatchers {

    actual val io: CoroutineDispatcher = Dispatchers.IO

    actual val ui: CoroutineDispatcher = Dispatchers.Main
}