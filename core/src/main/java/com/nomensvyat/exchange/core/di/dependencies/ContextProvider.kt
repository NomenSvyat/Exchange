package com.nomensvyat.exchange.core.di.dependencies

import android.content.Context

interface ContextProvider {
    fun getContext(): Context
}