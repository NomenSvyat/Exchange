package com.nomensvyat.exchange.exchanger.domain

import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyConverter @Inject constructor() {

    private var baseCurrency: Currency? = null
    private val currencyRates = HashMap<Currency, BigDecimal>()

    @Synchronized
    fun setRates(rates: List<CurrencyRate>) {
        baseCurrency = rates.first { it.rate == BigDecimal.ONE }.currency
        for ((currency, rate) in rates) {
            currencyRates[currency] = rate
        }
    }

    fun convert(from: Currency, to: Currency, amount: BigDecimal): BigDecimal? {
        if (from == to) return amount


        val fromRate: BigDecimal
        val toRate: BigDecimal
        synchronized(this) {
            fromRate = currencyRates[from] ?: return null
            toRate = currencyRates[to] ?: return null
        }

        return amount.divide(fromRate).multiply(toRate).setScale(DEFAULT_SCALE, RoundingMode.DOWN)
    }

    private companion object {
        private const val DEFAULT_SCALE = 4
    }
}