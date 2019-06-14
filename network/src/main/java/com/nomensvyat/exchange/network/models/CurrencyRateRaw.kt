package com.nomensvyat.exchange.network.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "Cube")
data class CurrencyRateRaw(
    @JvmField
    @field:Attribute
    var currency: String = "",
    @JvmField
    @field:Attribute
    var rate: String = ""
)
