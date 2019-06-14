package com.nomensvyat.exchange.core.di.dependencies

import com.nomensvyat.exchange.core.data.currencies.CurrencyRemoteStore

interface CurrencyStoreProvider {
    fun getCurrencyRemoteStore(): CurrencyRemoteStore
}