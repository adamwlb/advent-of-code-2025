package io.github.adamwlb.aoc2025.day3

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class Day3Test {

    val testInputPath = "src/test/resources/day3.txt"

    lateinit var underTest: Day3

    @BeforeEach
    fun setup() {
        underTest = Day3(testInputPath)
    }

    @Test
    fun canParseInput() {
        val expected: List<Bank> = listOf(
            Bank(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)),
            Bank(listOf(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)),
            Bank(listOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)),
            Bank(listOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1))
        )
        val actual = underTest.parseInput()

        expected.zip(actual).forEachIndexed { i, (exp, act) ->
            assertEquals(exp, act, "Mismatch at index $i")
        }

        assertEquals(expected.size, actual.size, "Sizes differ")
    }

    @Test
    fun part1SampleInput() {
        assertEquals(357, underTest.part1())
    }

    @Test
    fun part2SampleInput() {
        assertEquals(BigInteger("3121910778619"), underTest.part2())
    }
}