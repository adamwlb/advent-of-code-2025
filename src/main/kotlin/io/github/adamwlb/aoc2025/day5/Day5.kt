package io.github.adamwlb.aoc2025.day5

import io.github.adamwlb.aoc2025.common.Range
import java.io.File
import java.math.BigInteger

class Day5(inputPath: String) {

    val inventory = parseInput(inputPath)

    fun parseInput(path: String): Inventory {
        // Normalize line endings to ensure this works on both Windows and Mac
        val normalizedText = File(path).readText().replace("\r\n", "\n").trim()
        val (rangeLines, idLines) = normalizedText.split("\n\n")

        val ranges = rangeLines.lineSequence().map { line ->
                val (start, end) = line.split('-')
                Range(start.toBigInteger(), end.toBigInteger())
            }.toList()

        val ids = idLines.lineSequence().map { it.toBigInteger() }.toList()

        return Inventory(ranges, ids)
    }


    fun part1(): Int = inventory.ingredientIds.count { isFresh(it) }

    fun part2(): BigInteger = countRangeIds(inventory.freshRanges)

    fun isFresh(ingredientId: BigInteger): Boolean =
        inventory.freshRanges.any { ingredientId >= it.first && ingredientId <= it.last }

    fun countRangeIds(ranges: List<Range>): BigInteger {
        var total = BigInteger.ZERO
        val sortedIntervals = ranges.flatMap { listOf(it.first, it.last + BigInteger.ONE) }.distinct().sorted()

        for (i: Int in 0..<sortedIntervals.size - 1) {
            val interval = Range(sortedIntervals[i], sortedIntervals[i + 1])
            if (ranges.any { it.contains(interval) }) {
                total += interval.range()
            }
        }

        return total
    }
}