package com.nomensvyat.exchange.exchanger.data

import com.nomensvyat.exchange.core.data.currencies.CurrencyRemoteStore
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class CurrencyRepository @Inject constructor(
    private val currencyRemoteStore: CurrencyRemoteStore
) {
    fun getCurrencyRates(): Single<List<CurrencyRate>> = currencyRemoteStore.getCurrencyRates()
}