package com.nomensvyat.exchange.exchanger.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.ui.base.BaseActivity
import com.nomensvyat.exchange.core.ui.utils.extensions.setContentBinding
import com.nomensvyat.exchange.exchanger.R
import com.nomensvyat.exchange.exchanger.databinding.ActivityExchangeBinding
import dagger.Lazy
import javax.inject.Inject

class ExchangeActivity : BaseActivity(), ExchangeContract.View {

    //region Presenter
    @Inject
    lateinit var presenterProvider: Lazy<ExchangePresenter>

    @InjectPresenter
    lateinit var presenter: ExchangePresenter

    @ProvidePresenter
    fun providePresenter(): ExchangePresenter = presenterProvider.get()
    //endregion

    override fun inject(componentManager: ComponentManager) {
        TODO()
    }

    private lateinit var binding: ActivityExchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentBinding(R.layout.activity_exchange)
    }
}
