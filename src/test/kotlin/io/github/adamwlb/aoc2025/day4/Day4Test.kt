package io.github.adamwlb.aoc2025.day4

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day4Test {

    val testInputPath = "src/test/resources/day4.txt"

    lateinit var underTest: Day4

    @BeforeEach
    fun setup() {
        underTest = Day4(testInputPath)
    }

    @Test
    fun `parses sample input`() {
        val expected = listOf(
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
        val actual = underTest.parseInput(testInputPath)

        expected.zip(actual).forEachIndexed { i, (exp, act) ->
            assertEquals(exp, act, "Mismatch at index $i")
        }

        assertEquals(expected.size, actual.size, "Sizes differ")
    }

    @Test
    fun `center paper cell with all 8 neighbours should not be accessible`() {
        assertFalse(underTest.isAccessibleRoll(5, 5))
    }

    @Test
    fun `edge paper cell with more than 4 neighbours should not be accessible`() {
        assertFalse(underTest.isAccessibleRoll(5, 0))
    }

    @Test
    fun `edge paper cell with fewer than 4 neighbours should be accessible`() {
        assertTrue(underTest.isAccessibleRoll(3, 9))
    }

    @Test
    fun `corner paper cell should be accessible`() {
        assertTrue(underTest.isAccessibleRoll(0, 0))
    }

    @Test
    fun `non-paper cell should not be accessible`() {
        assertFalse(underTest.isAccessibleRoll(0, 1))
    }

    @Test
    fun `solves part 1 for sample input`() {
        assertEquals(13, underTest.part1())
    }

    @Test
    fun `solves part 2 for sample input`() {
        assertEquals(43, underTest.part2())
    }
}