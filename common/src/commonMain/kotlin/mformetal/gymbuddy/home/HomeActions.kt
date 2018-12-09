package mformetal.gymbuddy.home

sealed class HomeActions {

    object NextClicked : HomeActions()

    object PrevClicked : HomeActions()

    object JumpToToday : HomeActions()
}