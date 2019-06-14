package com.nomensvyat.exchange.exchanger.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.di.getOrThrow
import com.nomensvyat.exchange.core.ui.base.BaseActivity
import com.nomensvyat.exchange.core.ui.utils.extensions.setContentBinding
import com.nomensvyat.exchange.exchanger.R
import com.nomensvyat.exchange.exchanger.databinding.ActivityExchangeBinding
import com.nomensvyat.exchange.exchanger.di.DaggerExchangeComponent
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
        DaggerExchangeComponent.builder()
            .navigationProvider(componentManager.getOrThrow())
            .build()
            .injectTo(this)
    }

    private lateinit var binding: ActivityExchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentBinding(R.layout.activity_exchange)
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, ExchangeActivity::class.java)
    }
}
