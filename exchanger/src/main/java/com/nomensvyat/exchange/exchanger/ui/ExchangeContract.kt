package com.nomensvyat.exchange.exchanger.ui

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.nomensvyat.exchange.core.ui.base.BasePresenter
import com.nomensvyat.exchange.core.ui.base.BaseView
import com.nomensvyat.exchange.exchanger.ui.list.CurrencyViewModel

class ExchangeContract private constructor() {

    interface View : BaseView {
        @StateStrategyType(AddToEndSingleStrategy::class)
        fun setCurrencies(
            fromCurrencies: List<CurrencyViewModel>,
            toCurrencies: List<CurrencyViewModel>
        )
    }

    abstract class Presenter : BasePresenter<View>()
}
