package com.nomensvyat.exchange.utils.common

import com.nomensvyat.exchange.BuildConfig
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class used to plant [trees][Timber.Tree] into [Timber]
 * */
@Singleton
class TimberInitializer @Inject constructor() {

    @Suppress("ConstantConditionIf")
    fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}