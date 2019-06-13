package com.nomensvyat.exchange.di

import com.nomensvyat.exchange.TheApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NavigationModule::class
    ]
)
interface ApplicationComponent {
    fun injectTo(target: TheApp)
}