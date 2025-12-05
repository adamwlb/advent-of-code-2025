package io.github.adamwlb.aoc2025.common

import java.math.BigInteger

class Range(val first: BigInteger, val last: BigInteger) {

    fun asSequence(): Sequence<BigInteger> =
        generateSequence(first) { prev ->
            val next = prev + BigInteger.ONE
            if (next > last) null else next
        }

    fun range(): BigInteger = last - first

    fun contains(range: Range) = first <= range.first && last + BigInteger.ONE >= range.last

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

}