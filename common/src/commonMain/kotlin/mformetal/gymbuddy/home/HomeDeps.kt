package mformetal.gymbuddy.home

import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

object HomeDeps {

    val module = Kodein.Module(name = "Home") {
        bind() from singleton {
            HomeViewModel(instance(), instance())
        }
    }
}