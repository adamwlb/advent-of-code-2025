package io.github.adamwlb.aoc2025.day6

import io.github.adamwlb.aoc2025.day6.Problem.Operator.MULTIPLY
import io.github.adamwlb.aoc2025.day6.Problem.Operator.PLUS
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day6Test {

    val testInputPath = "src/test/resources/day6.txt"

    lateinit var underTest: Day6

    @BeforeEach
    fun setup() {
        underTest = Day6(testInputPath)
    }

    @Test
    fun `can parse sample input for part 1`() {
        val expected = listOf(
            Problem(listOf(123, 45, 6), MULTIPLY),
            Problem(listOf(328, 64, 98), PLUS),
            Problem(listOf(51, 387, 215), MULTIPLY),
            Problem(listOf(64, 23, 314), PLUS)
        )
        assertEquals(expected, underTest.problems)
    }

    @Test
    fun `solves part 1 with sample input`() {
        assertEquals(BigInteger("4277556"), underTest.part1())
    }

    @Test
    fun `can parse sample input for part 2`() {
        val expected = listOf(
            Problem(listOf(4, 431, 623), PLUS),
            Problem(listOf(175, 581, 32), MULTIPLY),
            Problem(listOf(8, 248, 369), PLUS),
            Problem(listOf(356, 24, 1), MULTIPLY),
        )
        assertEquals(expected, underTest.problemsPart2)
    }

    @Test
    fun `solves part 2 with sample input`() {
        assertEquals(BigInteger("3263827"), underTest.part2())
    }
}