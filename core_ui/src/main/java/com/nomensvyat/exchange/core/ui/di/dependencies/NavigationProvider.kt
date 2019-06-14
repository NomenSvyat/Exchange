package com.nomensvyat.exchange.core.ui.di.dependencies

import com.nomensvyat.exchange.core.ui.routing.ScreenFactory
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface NavigationProvider {
    fun getRouter(): Router
    fun getNavigatorHolder(): NavigatorHolder
    fun getScreenFactory(): ScreenFactory
}