package io.github.adamwlb.aoc2025.day5

import io.github.adamwlb.aoc2025.common.Range
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day5Test {

    val testInputPath = "src/test/resources/day5.txt"

    lateinit var underTest: Day5

    @BeforeEach
    fun setup() {
        underTest = Day5(testInputPath)
    }

    @Test
    fun `parses sample input`() {
        val expected = Inventory(
            listOf(
                Range(3.toBigInteger(), 5.toBigInteger()),
                Range(10.toBigInteger(), 14.toBigInteger()),
                Range(16.toBigInteger(), 20.toBigInteger()),
                Range(12.toBigInteger(), 18.toBigInteger())
            ),
            listOf(
                1.toBigInteger(),
                5.toBigInteger(),
                8.toBigInteger(),
                11.toBigInteger(),
                17.toBigInteger(),
                32.toBigInteger()
            )
        )

        val actual = underTest.parseInput(testInputPath)

        assertEquals(expected, actual)
    }

    @Test
    fun `solves part 1 with sample input`() {
        assertEquals(3, underTest.part1())
    }

    @Test
    fun `checks an ingredient ID is fresh`() {
        assertTrue(underTest.isFresh(5.toBigInteger()))
        assertTrue(underTest.isFresh(11.toBigInteger()))
        assertTrue(underTest.isFresh(17.toBigInteger()))

        assertFalse(underTest.isFresh(1.toBigInteger()))
        assertFalse(underTest.isFresh(8.toBigInteger()))
        assertFalse(underTest.isFresh(32.toBigInteger()))
    }

    @Test
    fun `solves part 2 with sample input`() {
        assertEquals(14.toBigInteger(), underTest.part2())
    }

    @Test
    fun `counts number of fresh IDs in two ranges`() {
        val range1 = Range(3.toBigInteger(), 5.toBigInteger())
        val range2 = Range(10.toBigInteger(), 14.toBigInteger())

        val expected = 8.toBigInteger()

        assertEquals(expected, underTest.countRangeIds(listOf(range1, range2)))
    }

    @Test
    fun `counts number of fresh IDs in two overlapping ranges`() {
        val range1 = Range(12.toBigInteger(), 18.toBigInteger())
        val range2 = Range(10.toBigInteger(), 14.toBigInteger())

        val expected = 9.toBigInteger()

        assertEquals(expected, underTest.countRangeIds(listOf(range1, range2)))
    }
}