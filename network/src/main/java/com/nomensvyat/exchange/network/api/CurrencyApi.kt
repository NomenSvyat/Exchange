package com.nomensvyat.exchange.network.api

import com.nomensvyat.exchange.network.models.CurrencyRatesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CurrencyApi {


    @GET("stats/eurofxref/eurofxref-daily.xml")
    fun getDailyCurrencyRates(): Single<CurrencyRatesResponse>

    companion object {
        const val BASE_URL = "https://www.ecb.europa.eu/"
    }
}