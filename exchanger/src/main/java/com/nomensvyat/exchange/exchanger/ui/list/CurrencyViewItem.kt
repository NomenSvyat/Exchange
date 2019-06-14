package com.nomensvyat.exchange.exchanger.ui.list

import com.nomensvyat.exchange.exchanger.R
import com.nomensvyat.exchange.exchanger.databinding.ItemCurrencyBinding
import com.xwray.groupie.databinding.BindableItem

class CurrencyViewItem(
    private val currencyViewModel: CurrencyViewModel
) : BindableItem<ItemCurrencyBinding>() {
    override fun getLayout(): Int = R.layout.item_currency

    override fun bind(viewBinding: ItemCurrencyBinding, position: Int) {
        viewBinding.viewModel = currencyViewModel
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CurrencyViewItem

        if (currencyViewModel != other.currencyViewModel) return false

        return true
    }

    override fun hashCode(): Int {
        return currencyViewModel.hashCode()
    }

}