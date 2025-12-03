package io.github.adamwlb.aoc2025.day3

import java.math.BigInteger

private const val SAFE_BATTERY_COUNT = 2
private const val SAFETY_OVERRIDE_BATTERY_COUNT = 12

class Bank(val batteries: List<Int>) {

    fun maxJoltage(): Int {
        return getJoltageString(SAFE_BATTERY_COUNT).toInt()
    }

    fun maxOverrideJoltage(): BigInteger {
        return BigInteger(getJoltageString(SAFETY_OVERRIDE_BATTERY_COUNT))
    }

    fun getJoltageString(noOfBatteries: Int): String {
        val joltageBatteries = mutableListOf<Int>()
        var startIndex = 0

        while (joltageBatteries.size < noOfBatteries) {
            val toChoose = noOfBatteries - joltageBatteries.size - 1
            val end = batteries.size - toChoose - 1

            var candidate = -1
            var candidateIndex = -1
            for (i in startIndex..end) {
                if (batteries[i] > candidate) {
                    candidate = batteries[i]
                    candidateIndex = i
                }
            }

            joltageBatteries.add(candidate)
            startIndex = candidateIndex + 1
        }

        return joltageBatteries.joinToString("")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bank

        return batteries == other.batteries
    }

    override fun hashCode(): Int {
        return batteries.hashCode()
    }

    override fun toString(): String {
        return batteries.toString()
    }
}