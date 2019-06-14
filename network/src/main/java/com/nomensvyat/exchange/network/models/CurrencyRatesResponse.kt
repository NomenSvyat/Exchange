package com.nomensvyat.exchange.network.models

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(strict = false)
class CurrencyRatesResponse {
    @JvmField
    @field:Path("Cube")
    @field:ElementList(name = "Cube")
    var currencies: MutableList<CurrencyRateRaw> = mutableListOf()
}
