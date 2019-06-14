package com.nomensvyat.exchange.domain.config

import com.nomensvyat.exchange.BuildConfig
import com.nomensvyat.exchange.core.domain.config.AppConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppConfigImpl @Inject constructor() : AppConfig {
    override val isLoggingEnabled: Boolean = BuildConfig.DEBUG
}