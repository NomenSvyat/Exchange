package com.nomensvyat.exchange.splashscreen.ui

import com.arellomobile.mvp.InjectViewState
import com.nomensvyat.exchange.core.ui.routing.ScreenFactory
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashScreenPresenter @Inject constructor(
    private val router: Router,
    private val screenFactory: ScreenFactory
) : SplashScreenContract.Presenter() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.navigateTo(screenFactory.exchangeScreen)
    }
}