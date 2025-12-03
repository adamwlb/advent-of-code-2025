package io.github.adamwlb.aoc2025.day3

import java.io.File
import java.math.BigInteger

class Day3(val inputPath: String) {

    val banks = parseInput()

    fun parseInput(): List<Bank> =
        File(inputPath).readLines().map { line ->
            Bank(line.map { it.digitToInt() })
        }


    fun part1(): Int {
        return banks.sumOf { it.maxJoltage() }
    }

    fun part2(): BigInteger {
        return banks.sumOf { it.maxOverrideJoltage() }
    }
}