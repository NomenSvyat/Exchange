package com.nomensvyat.exchange.exchanger.ui

import android.util.ArrayMap
import com.arellomobile.mvp.InjectViewState
import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import com.nomensvyat.exchange.exchanger.domain.CurrencyInteractor
import com.nomensvyat.exchange.exchanger.ui.list.CurrencyViewModel
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class ExchangePresenter @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : ExchangeContract.Presenter() {

    private val currencyRates = ArrayMap<Currency, BigDecimal>()
    private val fromCurrenciesViewModels = mutableListOf<CurrencyViewModel>()
    private val toCurrenciesViewModels = mutableListOf<CurrencyViewModel>()

    init {
        Flowable.interval(0L, REQUEST_INTERVAL_SECONDS, TimeUnit.SECONDS, Schedulers.computation())
            .switchMapSingle { currencyInteractor.getCurrencyRates() }
            .subscribeAndBind({ rates ->
                setRates(rates)

                setCurrencies(rates)
            })
    }

    private val selectedToCurrency
        get() =
            toCurrenciesViewModels.firstOrNull { it.isSelected.get() }?.currency

    private val selectedFromCurrency
        get() =
            fromCurrenciesViewModels.firstOrNull { it.isSelected.get() }?.currency


    private fun setRates(rates: List<CurrencyRate>) {
        currencyRates.clear()
        rates.forEach { (currency, rate) -> currencyRates[currency] = rate }
    }

    private fun setCurrencies(rates: List<CurrencyRate>) {
        //only first time
        if (fromCurrenciesViewModels.isNotEmpty()) return

        val currencies = rates.map { it.currency }

        fromCurrenciesViewModels.addAll(
            currencies.map { createCurrencyViewModel(it, fromCurrenciesViewModels) }
        )
        fromCurrenciesViewModels.firstOrNull()?.isSelected?.set(true)
        toCurrenciesViewModels.addAll(
            currencies.map { createCurrencyViewModel(it, toCurrenciesViewModels) }
        )
        //select second
        toCurrenciesViewModels.drop(1).firstOrNull()?.isSelected?.set(true)

        viewState.setCurrencies(fromCurrenciesViewModels, toCurrenciesViewModels)
    }

    private fun createCurrencyViewModel(currency: Currency, viewModels: List<CurrencyViewModel>) =
        CurrencyViewModel(
            currency = currency,
            onItemSelectedListener = { isSelected, _currency ->
                onCurrencySelected(isSelected, _currency, viewModels)
            }
        )

    private fun onCurrencySelected(
        isSelected: Boolean,
        currency: Currency,
        viewModels: List<CurrencyViewModel>
    ): Boolean {
        //already selected
        val currentViewModel = viewModels.first { it.currency == currency }
        return if (currentViewModel.isSelected.get()) {
            false
        } else {
            currentViewModel.isSelected.set(true)
            viewModels
                .asSequence()
                .filter { it.currency != currency }
                .forEach { it.isSelected.set(false) }
            true
        }
    }

    private companion object {
        private const val REQUEST_INTERVAL_SECONDS = 30L
    }
}