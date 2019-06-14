package com.nomensvyat.exchange.exchanger.ui.list

import androidx.databinding.ObservableBoolean
import com.nomensvyat.exchange.core.domain.currencies.models.Currency

class CurrencyViewModel(
    val currency: Currency,
    isSelected: Boolean = false
) {
    val isSelected = ObservableBoolean(isSelected)
}