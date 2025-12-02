package io.github.adamwlb.aoc2025.day2

import java.io.File
import java.math.BigInteger

class Day2(val inputPath: String) {

    val idRanges: List<Range> = parseInput()

    fun parseInput(): List<Range> =
        File(inputPath).readLines().flatMap { input ->
            input.split(',').map { line ->
                val (start, end) = line.split('-')
                Range(start.toBigInteger(), end.toBigInteger())
            }
        }

    fun part1(): BigInteger = idRanges.flatMap { it.asSequence() }.filter { isInvalidId(it) }.sumOf { it }

    fun isInvalidId(id: BigInteger): Boolean {
        val idString = id.toString()
        val mid = idString.length / 2
        val first = idString.take(mid)
        val second = idString.substring(mid)

        if (first.length != second.length) return false
        return first == second
    }

    fun part2(): BigInteger {
        return idRanges.flatMap { it.asSequence() }.filter { isInvalidIdPart2(it) }.sumOf { it }
    }

    fun isInvalidIdPart2(id: BigInteger): Boolean {
        val idString = id.toString()

        for (blockSize in 1..idString.length / 2) {
            val candidate = idString.take(blockSize)
            if (candidate.repeat(idString.length / blockSize) == idString) return true
        }
        return false
    }
}