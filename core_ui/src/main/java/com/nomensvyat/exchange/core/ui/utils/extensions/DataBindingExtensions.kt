package com.nomensvyat.exchange.core.ui.utils.extensions

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> Activity.setContentBinding(@LayoutRes layoutId: Int): T =
    DataBindingUtil.setContentView(this, layoutId)

inline fun BaseObservable.addOnPropertyChangedCallback(crossinline block: () -> Unit) {
    this.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            block()
        }
    })
}