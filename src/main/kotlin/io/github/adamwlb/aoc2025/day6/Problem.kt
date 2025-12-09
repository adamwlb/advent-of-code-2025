package io.github.adamwlb.aoc2025.day6

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

class Problem(val operands: List<Int>, val operator: Operator) {

    fun solve(): BigInteger {
        return when (operator) {
            Operator.PLUS -> operands.fold(ZERO) { acc, num -> acc + BigInteger.valueOf(num.toLong()) }
            Operator.MULTIPLY -> operands.fold(ONE) { acc, num -> acc * BigInteger.valueOf(num.toLong()) }
        }
    }

    enum class Operator(val symbol: Char) {
        PLUS('+'),
        MULTIPLY('*');

        companion object {
            fun fromSymbol(symbol: Char): Operator {
                return entries.first { it.symbol == symbol }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}


