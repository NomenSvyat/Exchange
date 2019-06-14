package com.nomensvyat.exchange.exchanger.di

import com.nomensvyat.exchange.core.ui.di.dependencies.NavigationProvider
import com.nomensvyat.exchange.exchanger.ui.ExchangeActivity
import dagger.Component

@Component(dependencies = [NavigationProvider::class])
interface ExchangeComponent {
    fun injectTo(target: ExchangeActivity)
}