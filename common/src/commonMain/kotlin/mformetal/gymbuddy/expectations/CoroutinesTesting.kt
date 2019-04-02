package mformetal.gymbuddy.expectations

import kotlinx.coroutines.CoroutineScope

expect fun launchBlocking(block: suspend (scope : CoroutineScope) -> Unit)

expect fun launchBackground(block: suspend (scope: CoroutineScope) -> Unit)