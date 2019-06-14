package com.nomensvyat.exchange.di

import com.nomensvyat.exchange.TheApp
import com.nomensvyat.exchange.core.di.dependencies.ContextProvider
import com.nomensvyat.exchange.core.di.dependencies.CurrencyStoreProvider
import com.nomensvyat.exchange.core.ui.di.dependencies.NavigationProvider
import com.nomensvyat.exchange.network.di.RemoteStoreModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NavigationModule::class,
        RemoteStoreModule::class
    ]
)
interface ApplicationComponent : NavigationProvider,
    ContextProvider,
    CurrencyStoreProvider {

    fun injectTo(target: TheApp)
}