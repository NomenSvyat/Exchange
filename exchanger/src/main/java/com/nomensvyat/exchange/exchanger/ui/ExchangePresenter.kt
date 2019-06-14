package com.nomensvyat.exchange.exchanger.ui

import androidx.annotation.StringRes
import com.arellomobile.mvp.InjectViewState
import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.domain.currencies.models.CurrencyRate
import com.nomensvyat.exchange.core.ui.utils.ResourseManager
import com.nomensvyat.exchange.exchanger.R
import com.nomensvyat.exchange.exchanger.domain.CurrencyConverter
import com.nomensvyat.exchange.exchanger.domain.CurrencyInteractor
import com.nomensvyat.exchange.exchanger.ui.list.CurrencyViewModel
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class ExchangePresenter @Inject constructor(
    private val currencyInteractor: CurrencyInteractor,
    private val currencyConverter: CurrencyConverter,
    private val resourseManager: ResourseManager
) : ExchangeContract.Presenter() {

    private val fromCurrenciesViewModels = mutableListOf<CurrencyViewModel>()
    private val toCurrenciesViewModels = mutableListOf<CurrencyViewModel>()
    private val viewModel = ExchangeViewModel()

    init {
        Flowable.interval(0L, REQUEST_INTERVAL_SECONDS, TimeUnit.SECONDS, Schedulers.computation())
            .switchMapSingle { currencyInteractor.getCurrencyRates() }
            .subscribeAndBind({ rates ->
                currencyConverter.setRates(rates)

                setCurrencies(rates)
            })
    }

    private val selectedToCurrency
        get() =
            toCurrenciesViewModels.firstOrNull { it.isSelected.get() }?.currency

    private val selectedFromCurrency
        get() =
            fromCurrenciesViewModels.firstOrNull { it.isSelected.get() }?.currency

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setViewModel(viewModel)
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
            calculateConvertedAmount()
            true
        }
    }

    override fun onAmountFromTextChanged(amount: String) {
        calculateConvertedAmount()
    }

    private fun calculateConvertedAmount() {
        val currentAmount = try {
            BigDecimal(viewModel.fromAmount.get())
        } catch (e: NumberFormatException) {
            setError(R.string.exchange_amount_parse_error)
            return
        }

        val selectedToCurrency = selectedToCurrency
        val selectedFromCurrency = selectedFromCurrency

        if (selectedToCurrency == null || selectedFromCurrency == null) {
            setError(R.string.exchange_unselected_currency_error)
            return
        }

        val convertedAmount =
            currencyConverter.convert(selectedFromCurrency, selectedToCurrency, currentAmount)

        convertedAmount?.let {
            viewModel.isError.set(false)
            viewModel.toAmount.set(it.toPlainString())
        }
            ?: setError(R.string.exchange_rates_not_loaded)
    }

    private fun setError(@StringRes stringRes: Int) {
        viewModel.error.set(resourseManager.getString(stringRes))
        viewModel.isError.set(true)
    }

    private companion object {
        private const val REQUEST_INTERVAL_SECONDS = 30L
    }
}