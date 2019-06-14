package com.nomensvyat.exchange.network.data.currency

import com.nomensvyat.exchange.core.data.currencies.CurrencyRemoteStore
import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import com.nomensvyat.exchange.core.utils.extensions.listMap
import com.nomensvyat.exchange.network.api.CurrencyApi
import com.nomensvyat.exchange.network.models.mappers.CurrencyRateMapper
import dagger.Reusable
import io.reactivex.Single
import java.math.BigDecimal
import javax.inject.Inject

@Reusable
class CurrencyRemoteStoreImp @Inject constructor(
    private val currencyApi: CurrencyApi,
    private val currencyRateMapper: CurrencyRateMapper
) : CurrencyRemoteStore {
    override fun getCurrencyRates(): Single<List<CurrencyRate>> =
        currencyApi.getDailyCurrencyRates()
            .map { it.currencies }
            .listMap { currencyRateMapper.map(it) }
            //Add Euro as base currency
            .map { it + CurrencyRate(Currency.fromName("EUR"), BigDecimal.ONE) }
}