package com.nomensvyat.exchange.core.ui.base

import android.content.Context
import com.arellomobile.mvp.MvpAppCompatFragment
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.ui.utils.extensions.findFragment
import com.nomensvyat.exchange.core.ui.utils.extensions.inTransaction

@Suppress("unused")
abstract class BaseFragment : MvpAppCompatFragment() {

    protected val componentManager get() = ComponentManager

    override fun onAttach(context: Context) {
        inject(componentManager)
        super.onAttach(context)
    }

    abstract fun inject(componentManager: ComponentManager)

    protected fun closeSelf() {
        val fragment = fragmentManager?.findFragment(this::class) ?: return
        fragmentManager?.inTransaction {
            remove(fragment)
        }
    }
}