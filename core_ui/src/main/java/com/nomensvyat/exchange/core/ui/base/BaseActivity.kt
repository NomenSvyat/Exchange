package com.nomensvyat.exchange.core.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.nomensvyat.exchange.core.di.ComponentManager
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    @Inject
    @JvmField
    var navigatorHolder: NavigatorHolder? = null

    protected val componentManager get() = ComponentManager

    @Suppress("MemberVisibilityCanBePrivate")
    protected open val navigator: Navigator by lazy {
        SupportAppNavigator(this, supportFragmentManager, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(ComponentManager)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
    }

    abstract fun inject(componentManager: ComponentManager)

    override fun onResume() {
        super.onResume()
        navigatorHolder?.setNavigator(navigator)
            ?: Timber.w("NavigatorHolder is null. Maybe forgotten injection")
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder?.removeNavigator()
    }
}