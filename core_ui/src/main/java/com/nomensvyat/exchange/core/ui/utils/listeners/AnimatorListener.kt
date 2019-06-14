package com.nomensvyat.exchange.core.ui.utils.listeners

import android.animation.Animator

typealias OnAnimationEvent = (Animator) -> Unit

class AnimatorListener(
    private val onStart: OnAnimationEvent? = null,
    private val onRepeat: OnAnimationEvent? = null,
    private val onEnd: OnAnimationEvent? = null,
    private val onCancel: OnAnimationEvent? = null
) : Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator) {
        onRepeat?.invoke(animation)
    }

    override fun onAnimationEnd(animation: Animator) {
        onEnd?.invoke(animation)
    }

    override fun onAnimationCancel(animation: Animator) {
        onCancel?.invoke(animation)
    }

    override fun onAnimationStart(animation: Animator) {
        onStart?.invoke(animation)
    }
}