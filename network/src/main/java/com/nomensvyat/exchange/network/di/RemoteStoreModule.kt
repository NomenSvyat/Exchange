package com.nomensvyat.exchange.network.di

import com.nomensvyat.exchange.core.data.currencies.CurrencyRemoteStore
import com.nomensvyat.exchange.network.data.currency.CurrencyRemoteStoreImp
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [NetworkModule::class])
abstract class RemoteStoreModule {
    @Reusable
    @Binds
    abstract fun provideCurrencyStore(currencyRemoteStoreImp: CurrencyRemoteStoreImp): CurrencyRemoteStore
}