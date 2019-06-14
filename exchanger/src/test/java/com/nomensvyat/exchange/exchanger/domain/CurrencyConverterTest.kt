package com.nomensvyat.exchange.exchanger.domain

import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode

class CurrencyConverterTest {
    private val currencyConverter = CurrencyConverter()

    @Before
    fun setRates() {
        currencyConverter.setRates(
            listOf(
                CurrencyRate(USD, BigDecimal.ONE),
                CurrencyRate(EUR, BigDecimal("1.2")),
                CurrencyRate(PHP, BigDecimal("2.0")),
                CurrencyRate(RUB, BigDecimal("1.5"))
            )
        )
    }

    @Test
    fun convertFromBaseToBase() {
        val amount = BigDecimal("300.25")
        val converted = currencyConverter.convert(USD, USD, amount)

        assertEquals(amount, converted)
    }

    @Test
    fun convertFromSomeToBase() {
        val converted = currencyConverter.convert(PHP, USD, BigDecimal("300"))

        assertEquals(BigDecimal("150").setScale(4), converted!!.setScale(4))
    }

    @Test
    fun convertFromSomeToSome() {
        val converted = currencyConverter.convert(PHP, RUB, BigDecimal("300"))

        assertEquals(BigDecimal("225").setScale(4), converted!!.setScale(4))
    }

    @Test
    fun convertFromSomeToSomeBig() {
        val converted = currencyConverter.convert(PHP, RUB, BigDecimal("300.1235"))

        println("Converted: $converted")
        assertEquals(
            BigDecimal("225.0926").setScale(4, RoundingMode.DOWN),
            converted
        )
    }

    @Test
    fun convertFromSomeToSomeZero() {
        val converted = currencyConverter.convert(PHP, RUB, BigDecimal("0"))

        assertEquals(
            BigDecimal("0").setScale(4, RoundingMode.DOWN),
            converted
        )
    }

    companion object {
        val USD = Currency.fromName("USD")
        val EUR = Currency.fromName("EUR")
        val PHP = Currency.fromName("PHP")
        val RUB = Currency.fromName("RUB")

    }
}