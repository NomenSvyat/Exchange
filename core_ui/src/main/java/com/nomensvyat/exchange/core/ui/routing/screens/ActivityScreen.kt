package com.nomensvyat.exchange.core.ui.routing.screens

import android.content.Context
import android.content.Intent
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ActivityScreen(
    private val screenName: String,
    private val block: (Context) -> Intent
) : SupportAppScreen() {

    override fun getScreenKey(): String {
        return screenName
    }

    override fun getActivityIntent(context: Context): Intent {
        return block(context)
    }
}