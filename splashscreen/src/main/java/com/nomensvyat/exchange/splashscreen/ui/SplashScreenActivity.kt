package com.nomensvyat.exchange.splashscreen.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.ui.base.BaseActivity
import com.nomensvyat.exchange.core.ui.utils.extensions.setContentBinding
import com.nomensvyat.exchange.splashscreen.R
import dagger.Lazy
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {

    //region Presenter
    @Inject
    lateinit var presenterProvider: Lazy<SplashScreenPresenter>

    @InjectPresenter
    lateinit var presenter: SplashScreenPresenter

    @ProvidePresenter
    fun providePresenter(): SplashScreenPresenter = presenterProvider.get()
    //endregion

    override fun inject(componentManager: ComponentManager) {
        TODO()
    }

    private lateinit var binding: com.nomensvyat.exchange.splashscreen.databinding.ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentBinding(R.layout.activity_splash_screen)
    }
}
