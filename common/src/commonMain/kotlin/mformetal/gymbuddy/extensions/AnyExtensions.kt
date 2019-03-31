package mformetal.gymbuddy.extensions

fun <T : Any> T?.takeIfNull(doIfNull: () -> Unit) {
    if (this == null) doIfNull()
}