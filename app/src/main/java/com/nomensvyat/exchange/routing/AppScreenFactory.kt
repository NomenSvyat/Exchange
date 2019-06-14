package com.nomensvyat.exchange.routing

import com.nomensvyat.exchange.core.ui.routing.ScreenFactory
import com.nomensvyat.exchange.core.ui.routing.screens.ActivityScreen
import com.nomensvyat.exchange.exchanger.ui.ExchangeActivity
import ru.terrakok.cicerone.Screen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppScreenFactory @Inject constructor() : ScreenFactory {
    override val exchangeScreen: Screen
        get() = ActivityScreen("Exchange") { ExchangeActivity.getStartIntent(it) }
}