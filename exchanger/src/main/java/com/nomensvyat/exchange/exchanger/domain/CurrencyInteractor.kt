package com.nomensvyat.exchange.exchanger.domain

import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import com.nomensvyat.exchange.exchanger.data.CurrencyRepository
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class CurrencyInteractor @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

    fun getCurrencyRates(): Single<List<CurrencyRate>> = currencyRepository.getCurrencyRates()
}