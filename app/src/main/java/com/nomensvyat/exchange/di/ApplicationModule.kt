package com.nomensvyat.exchange.di

import android.app.Application
import android.content.Context
import com.nomensvyat.exchange.core.domain.config.AppConfig
import com.nomensvyat.exchange.core.ui.routing.ScreenFactory
import com.nomensvyat.exchange.domain.config.AppConfigImpl
import com.nomensvyat.exchange.routing.AppScreenFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule.Bindings::class])
class ApplicationModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application


    @Module
    abstract class Bindings {

        @Singleton
        @Binds
        abstract fun provideAppConfig(appConfigImpl: AppConfigImpl): AppConfig

        @Singleton
        @Binds
        abstract fun provideScreenFactory(appScreenFactory: AppScreenFactory): ScreenFactory
    }
}