package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

expect fun runTest(block: suspend (scope : CoroutineScope) -> Unit)

expect object ExpectedDispatchers {
    val io : CoroutineDispatcher
    val ui : CoroutineDispatcher
}