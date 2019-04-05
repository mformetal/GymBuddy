package mformetal.gymbuddy.kedux.presentation

interface ComponentController<S : Any> {

    val render: (S) -> Unit

    fun bind(view: Any)
}