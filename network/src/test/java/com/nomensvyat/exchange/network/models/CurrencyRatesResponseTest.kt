package com.nomensvyat.exchange.network.models

import org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.simpleframework.xml.core.Persister

class CurrencyRatesResponseTest {

    private val testFileStream = javaClass.classLoader!!.getResourceAsStream("test_currencies.xml")

    @Test
    fun testParsing() {
        val persister = Persister()
        val ratesResponse = persister.read(CurrencyRatesResponse::class.java, testFileStream)

        assertEquals(2, ratesResponse.currencies.size)

        assertThat(
            ratesResponse.currencies, containsInAnyOrder(
                CurrencyRateRaw("USD", "1.1289"),
                CurrencyRateRaw("PHP", "58.556")
            )
        )
    }

}