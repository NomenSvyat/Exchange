package com.nomensvyat.exchange

import android.app.Application
import com.arellomobile.mvp.RegisterMoxyReflectorPackages
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.di.ApplicationModule
import com.nomensvyat.exchange.di.DaggerApplicationComponent
import com.nomensvyat.exchange.utils.common.TimberInitializer
import javax.inject.Inject

@RegisterMoxyReflectorPackages(
    "com.nomensvyat.exchange.splashscreen",
    "com.nomensvyat.exchange.exchanger"
)
class TheApp : Application() {

    @Inject
    lateinit var timberInitializer: TimberInitializer

    override fun onCreate() {
        super.onCreate()
        initComponentManager()

        timberInitializer.init()
    }

    private fun initComponentManager() {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
            .also { ComponentManager.put(it) }
            .injectTo(this)
    }
}