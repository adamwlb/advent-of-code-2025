package io.github.adamwlb.aoc2025.day1

import io.github.adamwlb.aoc2025.day1.Rotation.Direction.LEFT
import io.github.adamwlb.aoc2025.day1.Rotation.Direction.RIGHT
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    val testInputPath = "src/test/resources/day1.txt"

    lateinit var underTest: Day1

    @BeforeEach
    fun setup() {
        underTest = Day1(testInputPath)
    }

    @Test
    fun canParseInput() {
        val expected: List<Rotation> = listOf(
            Rotation(68, LEFT),
            Rotation(30, LEFT),
            Rotation(48, RIGHT),
            Rotation(5, LEFT),
            Rotation(60, RIGHT),
            Rotation(55, LEFT),
            Rotation(1, LEFT),
            Rotation(99, LEFT),
            Rotation(14, RIGHT),
            Rotation(82, LEFT)
        )

        val actual = underTest.parseInput()

        expected.zip(actual).forEachIndexed { i, (exp, act) ->
            assertEquals(exp, act, "Mismatch at index $i")
        }

        assertEquals(expected.size, actual.size, "Sizes differ")
    }

    @Test
    fun part1SampleInput() {
        assertEquals(3, underTest.part1())
    }

    @Test
    fun part2SampleInput() {
        assertEquals(6, underTest.part2())
    }
}