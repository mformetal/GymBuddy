package mformetal.gymbuddy.kedux

interface ViewController<T> {

    fun render(state: T)
}