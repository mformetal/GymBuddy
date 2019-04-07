package mformetal.gymbuddy.di

import com.soywiz.klock.Month
import mformetal.gymbuddy.expectations.DispatcherHolder
import mformetal.gymbuddy.expectations.ExpectedDispatchers
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.state.AppState
import mformetal.gymbuddy.kedux.state.CalendarState
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton

object Deps {

    val rootModule = Kodein.Module {
        bind() from singleton {
            val appState = AppState(
                    calendarState = CalendarState(
                            Month.April
                    )
            )
            Store(appState)
        }

        bind() from singleton {
            DispatcherHolder(
                    ExpectedDispatchers.io,
                    ExpectedDispatchers.ui
            )
        }
    }
}