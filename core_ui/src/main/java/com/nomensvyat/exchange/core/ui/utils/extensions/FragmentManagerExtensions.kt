package com.nomensvyat.exchange.core.ui.utils.extensions

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlin.reflect.KClass

val Class<out Fragment>.TAG: String
    get() = name

fun <T : DialogFragment> FragmentManager.showSingle(dialog: T): T {
    closeDialog(dialog::class)
    dialog.show(this, dialog::class.java.TAG)
    return dialog
}

fun <T : DialogFragment> T.showSingle(fragmentManager: FragmentManager): T {
    (fragmentManager.findFragmentByTag(this.javaClass.TAG) as? DialogFragment)?.dismiss()
    this.show(fragmentManager, this.javaClass.TAG)
    return this
}

fun <T : KClass<out DialogFragment>> T.closeDialog(fragmentManager: FragmentManager) {
    val dialog = fragmentManager.findFragmentByTag(java.TAG) as? DialogFragment?
    dialog?.dismiss()
}

fun <T : DialogFragment> FragmentManager.closeDialog(klass: KClass<T>) {
    findFragment(klass)?.dismiss()
}

@Suppress("UNCHECKED_CAST")
fun <T : Fragment> FragmentManager.findFragment(klass: KClass<T>): T? =
    findFragmentByTag(klass.java.TAG) as? T?

inline fun FragmentManager.inTransaction(block: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        block()
        commit()
    }
}