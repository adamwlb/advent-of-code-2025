package io.github.adamwlb.aoc2025.day1

class Rotation(val distance: Int, val direction: Direction) {

    enum class Direction {
        LEFT,
        RIGHT
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rotation

        if (distance != other.distance) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = distance
        result = 31 * result + direction.hashCode()
        return result
    }
}