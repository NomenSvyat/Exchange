package com.nomensvyat.exchange.exchanger.ui.list

import androidx.databinding.ObservableBoolean
import com.nomensvyat.exchange.core.domain.currencies.models.Currency
import com.nomensvyat.exchange.core.ui.utils.listeners.OnItemSelectedListener

class CurrencyViewModel(
    val currency: Currency,
    onItemSelectedListener: OnItemSelectedListener<Currency>,
    isSelected: Boolean = false
) {
    val isSelected = ObservableBoolean(isSelected)

    val onItemSelectedListener: OnItemSelectedListener<Currency> = { isSelected, currency ->
        val canBeSelected = onItemSelectedListener(isSelected, currency)
        if (canBeSelected) {
            this.isSelected.set(isSelected)
        }
        canBeSelected
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CurrencyViewModel

        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        return currency.hashCode()
    }


}