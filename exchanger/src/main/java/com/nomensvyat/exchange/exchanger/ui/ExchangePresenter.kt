package com.nomensvyat.exchange.exchanger.ui

import com.arellomobile.mvp.InjectViewState
import com.nomensvyat.exchange.exchanger.domain.CurrencyInteractor
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class ExchangePresenter @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : ExchangeContract.Presenter() {

    init {
        Flowable.interval(0, 30, TimeUnit.SECONDS, Schedulers.computation())
            .switchMapSingle { currencyInteractor.getCurrencyRates() }
            .subscribeAndBind({ TODO() })
    }

}