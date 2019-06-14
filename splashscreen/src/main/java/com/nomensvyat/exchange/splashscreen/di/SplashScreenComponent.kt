package com.nomensvyat.exchange.splashscreen.di

import com.nomensvyat.exchange.core.ui.di.dependencies.NavigationProvider
import com.nomensvyat.exchange.splashscreen.ui.SplashScreenActivity
import dagger.Component

@Component(dependencies = [NavigationProvider::class])
interface SplashScreenComponent {
    fun injectTo(target: SplashScreenActivity)
}