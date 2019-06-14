package com.nomensvyat.exchange.core.data.currencies

import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import io.reactivex.Single

interface CurrencyRemoteStore {

    fun getCurrencyRates(): Single<List<CurrencyRate>>
}