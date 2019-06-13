package com.nomensvyat.exchange.splashscreen.ui

import com.nomensvyat.exchange.core.ui.base.BasePresenter
import com.nomensvyat.exchange.core.ui.base.BaseView

class SplashScreenContract private constructor() {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View>()
}
