package io.github.adamwlb.aoc2025.day4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridTest {

    val underTest = Grid(
        listOf(
            listOf('.', '.', '@', '@', '.', '@', '@', '@', '@', '.'),
            listOf('@', '@', '@', '.', '@', '.', '@', '.', '@', '@'),
            listOf('@', '@', '@', '@', '@', '.', '@', '.', '@', '@'),
            listOf('@', '.', '@', '@', '@', '@', '.', '.', '@', '.'),
            listOf('@', '@', '.', '@', '@', '@', '@', '.', '@', '@'),
            listOf('.', '@', '@', '@', '@', '@', '@', '@', '.', '@'),
            listOf('.', '@', '.', '@', '.', '@', '.', '@', '@', '@'),
            listOf('@', '.', '@', '@', '@', '.', '@', '@', '@', '@'),
            listOf('.', '@', '@', '@', '@', '@', '@', '@', '@', '.'),
            listOf('@', '.', '@', '.', '@', '@', '@', '.', '@', '.')
        )
    )

    @Test
    fun `get height of grid`() {
        assertEquals(10, underTest.height())
    }

    @Test
    fun `get width of grid`() {
        assertEquals(10, underTest.width())
    }

    @Test
    fun `get specific grid values by coordinate pair`() {
        assertEquals('@', underTest.get(0, 0))
        assertEquals('.', underTest.get(9, 9))
        assertEquals('@', underTest.get(5, 5))
        assertEquals('.', underTest.get(7, 8))
    }

    @Test
    fun `out of bounds coordinates should throw`() {
        assertThrows<IndexOutOfBoundsException> {
            underTest.get(-1, 0)
        }
    }

    @Test
    fun `test coordinate pairs are in bounds`() {
        assertTrue(underTest.inBounds(3, 3))
        assertTrue(underTest.inBounds(0, 7))
        assertTrue(underTest.inBounds(5, 0))
        assertTrue(underTest.inBounds(2, 8))

        assertFalse(underTest.inBounds(-1, 3))
        assertFalse(underTest.inBounds(5, -6))
        assertFalse(underTest.inBounds(11, 3))
        assertFalse(underTest.inBounds(2, 12))
    }

    @Test
    fun `neighbours of a center cell should return 8 values`() {
        val x = 5
        val y = 5

        val result = underTest.neighbours(x, y)

        val expected = listOf(
            // Cardinals
            underTest.get(5, 4),
            underTest.get(6, 5),
            underTest.get(5, 6),
            underTest.get(4, 5),

            // Diagonals
            underTest.get(6, 4),
            underTest.get(6, 6),
            underTest.get(4, 6),
            underTest.get(4, 4)
        )

        assertEquals(8, result.size)
        assertEquals(expected.toSet(), result.toSet())
    }

    @Test
    fun `neighbours of a top edge cell should return 5 values`() {
        val x = 5
        val y = 0

        val result = underTest.neighbours(x, y)

        val expected = listOfNotNull(
            // right, down, left
            underTest.get(6, 0),
            underTest.get(5, 1),
            underTest.get(4, 0),

            // diagonals down-right and down-left
            underTest.get(6, 1),
            underTest.get(4, 1)
        )

        assertEquals(5, result.size)
        assertEquals(expected.toSet(), result.toSet())
    }

    @Test
    fun `neighbours of a left edge cell should return 5 values`() {
        val x = 0
        val y = 5

        val result = underTest.neighbours(x, y)

        val expected = listOfNotNull(
            underTest.get(0, 4),
            underTest.get(1, 5),
            underTest.get(0, 6),
            underTest.get(1, 4),
            underTest.get(1, 6)
        )

        assertEquals(5, result.size)
        assertEquals(expected.toSet(), result.toSet())
    }

    @Test
    fun `neighbours of top-left corner should return 3 values`() {
        val result = underTest.neighbours(0, 0)

        val expected = listOf(
            underTest.get(1, 0),
            underTest.get(0, 1),
            underTest.get(1, 1)
        )

        assertEquals(3, result.size)
        assertEquals(expected.toSet(), result.toSet())
    }

    @Test
    fun `neighbours of bottom-right corner should return 3 values`() {
        val x = underTest.width() - 1
        val y = underTest.height() - 1

        val result = underTest.neighbours(x, y)

        val expected = listOf(
            underTest.get(x - 1, y),
            underTest.get(x, y - 1),
            underTest.get(x - 1, y - 1)
        )

        assertEquals(3, result.size)
        assertEquals(expected.toSet(), result.toSet())
    }

    @Test
    fun `neighbours should throw for out of bounds coordinates`() {
        assertThrows<IndexOutOfBoundsException> {
            underTest.neighbours(-1, 0)
        }
        assertThrows<IndexOutOfBoundsException> {
            underTest.neighbours(20, 5)
        }
    }

    @Test
    fun `set specific grid values by coordinate pair`() {
        assertEquals('@', underTest.get(0, 0))
        assertEquals('.', underTest.get(9, 9))
        assertEquals('@', underTest.get(5, 5))
        assertEquals('.', underTest.get(7, 8))

        underTest.set(0, 0, '.')
        underTest.set(9, 9, '@')
        underTest.set(5, 5, '.')
        underTest.set(7, 8, '@')

        assertEquals('.', underTest.get(0, 0))
        assertEquals('@', underTest.get(9, 9))
        assertEquals('.', underTest.get(5, 5))
        assertEquals('@', underTest.get(7, 8))
    }

    @Test
    fun `setting out of bounds coordinates should throw`() {
        assertThrows<IndexOutOfBoundsException> {
            underTest.set(-1, 0, '@')
        }
    }
}