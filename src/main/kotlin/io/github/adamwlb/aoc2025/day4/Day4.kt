package io.github.adamwlb.aoc2025.day4

import java.io.File

class Day4(inputPath: String) {

    val grid: Grid<Char> = Grid(parseInput(inputPath))

    fun parseInput(inputPath: String): List<List<Char>> =
        File(inputPath).readLines().map(String::toList)

    fun part1(): Int {
        return accessibleRollCoordinates().size
    }

    fun accessibleRollCoordinates(): List<Pair<Int, Int>> {
        return (0 until grid.width()).flatMap { x ->
            (0 until grid.height())
                .filter { y -> isAccessibleRoll(x, y) }
                .map { y -> x to y }
        }
    }

    fun isAccessibleRoll(x: Int, y: Int): Boolean {
        if (!isPaper(grid.get(x, y))) {
            return false
        }
        return paperNeighbours(x, y).size < 4
    }

    fun part2(): Int {
        val maxIterations = 100 // Don't want to go on forever
        val totalRolls = countRolls()

        repeat(maxIterations) {
            val toRemove = accessibleRollCoordinates()
            for ((x, y) in toRemove) {
                grid.set(x, y, '.')
            }
        }

        val finalRolls = countRolls()
        return totalRolls - finalRolls
    }

    fun countRolls(): Int = grid.grid.flatten().count { isPaper(it) }

    fun paperNeighbours(x: Int, y: Int): List<Char> = grid.neighbours(x, y).filter { isPaper(it) }

    fun isPaper(value: Char): Boolean = value == '@'
}