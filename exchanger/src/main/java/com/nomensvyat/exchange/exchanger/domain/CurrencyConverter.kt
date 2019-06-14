package com.nomensvyat.exchange.exchanger.domain

import com.nomensvyat.exchange.core.di.PerFeature
import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock
import javax.inject.Inject

@PerFeature
class CurrencyConverter @Inject constructor() {

    private val currencyRates = HashMap<Currency, BigDecimal>()
    private val readWriteLock = ReentrantReadWriteLock()

    fun setRates(rates: List<CurrencyRate>) {
        readWriteLock.writeLock().lock()
        try {
            for ((currency, rate) in rates) {
                currencyRates[currency] = rate
            }
        } finally {
            readWriteLock.writeLock().unlock()
        }
    }

    fun convert(from: Currency, to: Currency, amount: BigDecimal): BigDecimal? {
        if (from == to) return amount
        if (amount.setScale(DEFAULT_SCALE) == BigDecimal.ZERO.setScale(DEFAULT_SCALE)) {
            return BigDecimal.ZERO.setScale(DEFAULT_SCALE)
        }

        readWriteLock.readLock().lock()
        val fromRate: BigDecimal
        val toRate: BigDecimal
        try {
            fromRate = currencyRates[from] ?: return null
            toRate = currencyRates[to] ?: return null
        } finally {
            readWriteLock.readLock().unlock()
        }

        return amount
            .divide(fromRate, DEFAULT_SCALE * 2, RoundingMode.CEILING)
            .multiply(toRate)
            .setScale(DEFAULT_SCALE, RoundingMode.DOWN)
    }

    private companion object {
        private const val DEFAULT_SCALE = 4
    }
}