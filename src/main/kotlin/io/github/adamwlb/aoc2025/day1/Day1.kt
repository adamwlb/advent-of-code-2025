package io.github.adamwlb.aoc2025.day1

import io.github.adamwlb.aoc2025.day1.Rotation.Direction.LEFT
import io.github.adamwlb.aoc2025.day1.Rotation.Direction.RIGHT
import java.io.File

class Day1(val inputPath: String) {

    val rotations: List<Rotation> = parseInput()
    var dialPosition = 50
    var password = 0

    fun parseInput(): List<Rotation> =
        File(inputPath).readLines().map { line ->
            val direction = if (line.startsWith("L")) LEFT else RIGHT
            val distance = line.substring(1).toInt()
            Rotation(distance, direction)
        }

    fun part1(): Int {
        rotations.forEach { r ->
            rotateDial(r)
            if (dialPosition == 0) {
                password++
            }
        }
        return password
    }

    fun part2(): Int {
        var password = 0
        rotations.forEach { r ->
            password += getWraps(r)
        }
        return password
    }

    fun getWraps(r: Rotation): Int {
        val fullRotation = 100
        val direction = r.direction

        var remainingDistance = r.distance
        var wraps = 0

        // If we move 100, we pass 0 and return to the original position
        while (remainingDistance >= fullRotation) {
            wraps++
            remainingDistance -= fullRotation
        }
        if (remainingDistance == 0) return wraps

        // Handle remaining distance (less than 100)
        val prev = dialPosition
        rotateDial(Rotation(remainingDistance, direction))
        val current = dialPosition
        if (passedZero(prev, current, direction)) wraps++

        return wraps
    }

    fun rotateDial(r: Rotation) {
        dialPosition = when (r.direction) {
            LEFT -> (dialPosition - r.distance).mod(100)
            RIGHT -> (dialPosition + r.distance).mod(100)
        }
    }

    fun passedZero(prev: Int, current: Int, direction: Rotation.Direction): Boolean {
        if (current == 0) return true
        if (prev == 0) return false
        return when (direction) {
            LEFT -> prev < current
            RIGHT -> prev > current
        }
    }
}
