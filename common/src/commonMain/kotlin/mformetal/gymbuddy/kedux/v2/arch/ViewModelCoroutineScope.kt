package mformetal.gymbuddy.kedux.v2.arch

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import mformetal.gymbuddy.expectations.ExpectedDispatchers

fun ViewModelScope(dispatcher: CoroutineDispatcher) : CoroutineScope = CoroutineScope(dispatcher + SupervisorJob())