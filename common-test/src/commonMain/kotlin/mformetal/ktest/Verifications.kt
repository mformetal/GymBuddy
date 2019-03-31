package mformetal.ktest

import io.mockk.verify

fun <T : Any> never(lamdbda: () -> T) {
    verify(exactly = 0) {
        lamdbda()
    }
}

fun <T : Any> once(lamdbda: () -> T) {
    verify(exactly = 1) {
        lamdbda()
    }
}