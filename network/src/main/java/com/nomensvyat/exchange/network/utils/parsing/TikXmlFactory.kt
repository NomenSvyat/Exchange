package com.nomensvyat.exchange.network.utils.parsing

import com.tickaroo.tikxml.TikXml
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TikXmlFactory @Inject constructor() {

    val tiXml: TikXml = TikXml.Builder().build()
}