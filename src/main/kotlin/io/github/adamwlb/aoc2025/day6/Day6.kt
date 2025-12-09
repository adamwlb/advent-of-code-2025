package io.github.adamwlb.aoc2025.day6

import io.github.adamwlb.aoc2025.day6.Problem.Operator
import java.io.File
import java.math.BigInteger

class Day6(inputPath: String) {

    val problems: List<Problem> = parseInput(inputPath)
    val problemsPart2: List<Problem> = parseInputPart2(inputPath)

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

    private fun parseInputPart2(inputPath: String): List<Problem> {
        val allLines = File(inputPath).readLines()
        val dataLines = allLines.dropLast(1)
        val operationLine = allLines.last().trim()

        val problemStarts = mutableListOf<Int>()
        for (i in operationLine.indices) {
            if (operationLine[i] != ' ') {
                problemStarts.add(i)
            }
        }

        val problems = mutableListOf<Problem>()
        val maxWidth = dataLines.maxOfOrNull { it.length } ?: 0

        for (i in problemStarts.indices) {
            val startChar = problemStarts[i]
            val endChar = problemStarts.getOrElse(i + 1) { maxWidth }
            val operator = Operator.fromSymbol(operationLine[startChar])

            val finalOperands = mutableListOf<Int>()
            val numOperands = endChar - startChar

            for (j in 0 until numOperands) {
                val charIndex = startChar + j

                val operandString = dataLines.mapNotNull { row ->
                    val char = row.getOrNull(charIndex)
                    if (char != null && char.isDigit()) {
                        char
                    } else {
                        null
                    }
                }.joinToString("")

                if (operandString.isNotEmpty()) {
                    finalOperands.add(operandString.toInt())
                }
            }

            problems.add(Problem(finalOperands.toList(), operator))
        }

        return problems.reversed()
    }

    fun part1(): BigInteger = problemsGrandTotal(problems)

    fun part2(): BigInteger = problemsGrandTotal(problemsPart2)

    private fun problemsGrandTotal(problems: Iterable<Problem>): BigInteger = problems.map { it.solve() }.sumOf { it }

}