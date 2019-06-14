package com.nomensvyat.exchange.core.domain.currencies.models

import java.math.BigDecimal

data class CurrencyRate(
    val currency: Currency,
    val rate: BigDecimal
)