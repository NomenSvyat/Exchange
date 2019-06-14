package com.nomensvyat.exchange.network.models.mappers

import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import com.nomensvyat.exchange.network.models.CurrencyRateRaw
import dagger.Reusable
import java.math.BigDecimal
import javax.inject.Inject

@Reusable
class CurrencyRateMapper @Inject constructor() {

    fun map(currencyRateRaw: CurrencyRateRaw): CurrencyRate = with(currencyRateRaw) {
        CurrencyRate(
            currency = Currency(currency),
            rate = BigDecimal(rate)
        )
    }
}