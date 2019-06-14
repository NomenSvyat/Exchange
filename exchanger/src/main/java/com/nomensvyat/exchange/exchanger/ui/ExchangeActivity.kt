package com.nomensvyat.exchange.exchanger.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.di.getOrThrow
import com.nomensvyat.exchange.core.ui.base.BaseActivity
import com.nomensvyat.exchange.core.ui.utils.extensions.setContentBinding
import com.nomensvyat.exchange.core.utils.extensions.onMain
import com.nomensvyat.exchange.core.utils.extensions.safeSubscribe
import com.nomensvyat.exchange.exchanger.R
import com.nomensvyat.exchange.exchanger.databinding.ActivityExchangeBinding
import com.nomensvyat.exchange.exchanger.di.DaggerExchangeComponent
import com.nomensvyat.exchange.exchanger.ui.list.CurrencyViewItem
import com.nomensvyat.exchange.exchanger.ui.list.CurrencyViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Lazy
import java.util.concurrent.TimeUnit
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
            .currencyStoreProvider(componentManager.getOrThrow())
            .contextProvider(componentManager.getOrThrow())
            .build()
            .injectTo(this)
    }

    private lateinit var binding: ActivityExchangeBinding
    private val fromCurrenciesAdapter = GroupAdapter<ViewHolder>()
    private val toCurrenciesAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentBinding(R.layout.activity_exchange)
        initCurrencyLists()

        RxTextView.textChanges(binding.etAmountFrom)
            .debounce(300, TimeUnit.MILLISECONDS)
            .map { it.toString() }
            .distinctUntilChanged()
            .onMain()
            .safeSubscribe({ presenter.onAmountFromTextChanged(it) })
    }

    private fun initCurrencyLists() {
        binding.rvFromCurrency.initCurrencyList(fromCurrenciesAdapter)
        binding.rvToCurrency.initCurrencyList(toCurrenciesAdapter)
    }

    private fun RecyclerView.initCurrencyList(adapter: RecyclerView.Adapter<*>) {
        LinearSnapHelper().attachToRecyclerView(this)
        layoutManager =
            LinearLayoutManager(this@ExchangeActivity, LinearLayoutManager.HORIZONTAL, false)
        this.adapter = adapter
    }

    override fun setCurrencies(
        fromCurrencies: List<CurrencyViewModel>,
        toCurrencies: List<CurrencyViewModel>
    ) {
        fromCurrenciesAdapter.updateAsync(fromCurrencies.map { CurrencyViewItem(it) })
        toCurrenciesAdapter.updateAsync(toCurrencies.map { CurrencyViewItem(it) })
    }

    override fun setViewModel(viewModel: ExchangeViewModel) {
        binding.viewModel = viewModel
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, ExchangeActivity::class.java)
    }
}
