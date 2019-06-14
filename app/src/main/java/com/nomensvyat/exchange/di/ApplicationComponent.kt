package com.nomensvyat.exchange.di

import com.nomensvyat.exchange.TheApp
import com.nomensvyat.exchange.core.di.dependencies.ContextProvider
import com.nomensvyat.exchange.core.ui.di.dependencies.NavigationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NavigationModule::class
    ]
)
interface ApplicationComponent : NavigationProvider, ContextProvider {
    fun injectTo(target: TheApp)
}