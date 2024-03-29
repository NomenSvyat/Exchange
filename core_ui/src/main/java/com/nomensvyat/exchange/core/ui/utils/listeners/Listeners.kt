package com.nomensvyat.exchange.core.ui.utils.listeners

/**
 * @return false to indicate that item must not be selected/deselected
 * */
typealias OnItemSelectedListener<T> = (Boolean, T) -> Boolean
