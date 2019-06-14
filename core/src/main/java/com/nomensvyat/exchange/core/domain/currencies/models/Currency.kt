package com.nomensvyat.exchange.core.domain.currencies.models

class Currency private constructor(
    val name: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Currency

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Currency(name='$name')"
    }

    companion object {
        fun fromName(name: String): Currency = Currency(name)
    }
}