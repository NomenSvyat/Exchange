package com.nomensvyat.exchange.core.ui.utils

import android.content.Context
import androidx.annotation.StringRes
import dagger.Reusable
import javax.inject.Inject

@Reusable
class ResourseManager @Inject constructor(private val context: Context) {

    fun getString(@StringRes stringRes: Int, vararg params: Any): String =
        context.getString(stringRes, params)
}