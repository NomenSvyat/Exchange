package com.nomensvyat.exchange.exchanger.ui

import com.nomensvyat.exchange.core.ui.base.BasePresenter
import com.nomensvyat.exchange.core.ui.base.BaseView

class ExchangeContract private constructor() {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View>()
}
