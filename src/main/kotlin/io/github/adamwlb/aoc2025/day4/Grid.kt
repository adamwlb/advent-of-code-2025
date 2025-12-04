package io.github.adamwlb.aoc2025.day4

class Grid<T>(input: List<List<T>>) {

    val grid: MutableList<MutableList<T>> = input.reversed().map { it.toMutableList() }.toMutableList()

    fun height(): Int = grid.size
    fun width(): Int = grid[0].size

    fun get(x: Int, y: Int): T {
        if (!inBounds(x, y)) {
            throw IndexOutOfBoundsException("")
        }
        return grid[y][x]
    }

    fun set(x: Int, y: Int, value: T) {
        if (!inBounds(x, y)) {
            throw IndexOutOfBoundsException("")
        }
        grid[y][x] = value
    }

    fun safeGet(x: Int, y: Int): T? {
        return try {
            get(x, y)
        } catch (_: IndexOutOfBoundsException) {
            null
        }
    }

    fun neighbours(x: Int, y: Int): List<T> {
        if (!inBounds(x, y)) {
            throw IndexOutOfBoundsException("")
        }
        return listOfNotNull(
            safeGet(x + 1, y + 1),
            safeGet(x + 1, y - 1),
            safeGet(x - 1, y + 1),
            safeGet(x - 1, y - 1),
            safeGet(x, y - 1),
            safeGet(x + 1, y),
            safeGet(x, y + 1),
            safeGet(x - 1, y)
        )
    }


    fun inBounds(x: Int, y: Int): Boolean = x >= 0 && x < width() && y >= 0 && y < height()
}