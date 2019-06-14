package com.nomensvyat.exchange.exchanger.ui

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class ExchangeViewModel {
    val fromAmount = ObservableField<String>("")
    val toAmount = ObservableField<String>("")
    val isError = ObservableBoolean(false)
    val error = ObservableField<String>("")
}