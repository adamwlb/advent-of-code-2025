package io.github.adamwlb.aoc2025.day5

import io.github.adamwlb.aoc2025.common.Range
import java.math.BigInteger

class Inventory(val freshRanges: List<Range>, val ingredientIds: List<BigInteger>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Inventory

        if (freshRanges != other.freshRanges) return false
        if (ingredientIds != other.ingredientIds) return false

        return true
    }

    override fun hashCode(): Int {
        var result = freshRanges.hashCode()
        result = 31 * result + ingredientIds.hashCode()
        return result
    }
}