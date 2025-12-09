package io.github.adamwlb.aoc2025.day6

import io.github.adamwlb.aoc2025.day6.Problem.Operator
import java.io.File
import java.math.BigInteger

class Day6(inputPath: String) {

    val problems: List<Problem> = parseInput(inputPath)

    private fun parseInput(inputPath: String): List<Problem> {
        val allLines = File(inputPath).readLines()

        val dataLines = allLines.dropLast(1)
        val operationLine = allLines.last()

        val grid: List<List<Int>> = dataLines.map { line ->
            line.trim().split(Regex("\\s+")).map { it.toInt() }
        }

        val parsedOperations: List<Operator> = operationLine.trim()
            .split(Regex("\\s+"))
            .map { operationString -> Operator.fromSymbol(operationString.first()) }

        val numColumns = grid.first().size

        val transposedColumns: List<List<Int>> =
            (0 until numColumns).map { colIndex -> grid.map { row -> row[colIndex] } }

        return transposedColumns.zip(parsedOperations, ::Problem)
    }

    fun part1(): BigInteger = problems.map { it.solve() }.sumOf { it }

    fun part2(): BigInteger = throw NotImplementedError()
}