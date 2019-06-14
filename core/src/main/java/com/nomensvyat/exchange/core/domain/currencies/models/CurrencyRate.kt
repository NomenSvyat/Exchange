package com.nomensvyat.exchange.core.domain.currencies.models

import java.math.BigDecimal

class CurrencyRate(
    val currency: Currency,
    val rate: BigDecimal
)