package io.github.adamwlb.aoc2025.day2

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigInteger
import kotlin.test.assertEquals

class Day2Test {

    val testInputPath = "src/test/resources/day2.txt"

    lateinit var underTest: Day2

    @BeforeEach
    fun setup() {
        underTest = Day2(testInputPath)
    }

    @Test
    fun parseInput() {
        val expected: List<Range> = listOf(
            Range(11.toBigInteger(), 22.toBigInteger()),
            Range(95.toBigInteger(), 115.toBigInteger()),
            Range(998.toBigInteger(), 1012.toBigInteger()),
            Range(1188511880.toBigInteger(), 1188511890.toBigInteger()),
            Range(222220.toBigInteger(), 222224.toBigInteger()),
            Range(1698522.toBigInteger(), 1698528.toBigInteger()),
            Range(446443.toBigInteger(), 446449.toBigInteger()),
            Range(38593856.toBigInteger(), 38593862.toBigInteger()),
            Range(565653.toBigInteger(), 565659.toBigInteger()),
            Range(824824821.toBigInteger(), 824824827.toBigInteger()),
            Range(2121212118.toBigInteger(), 2121212124.toBigInteger())
        )

        val actual = underTest.parseInput()

        expected.zip(actual).forEachIndexed { i, (exp, act) ->
            assertEquals(exp, act, "Mismatch at index $i")
        }

        assertEquals(expected.size, actual.size, "Sizes differ")
    }

    @Test
    fun part1() {
        assertEquals(BigInteger("1227775554"), underTest.part1())
    }

    @ParameterizedTest
    @CsvSource(
        "55, true",
        "6464, true",
        "123123, true",
        "101, false",
        "998, false",
        "11122, false",
        "646464, false",
        "1, false"
    )
    fun checksIdsAreInvalid(id: BigInteger, expected: Boolean) {
        assertEquals(expected, underTest.isInvalidId(id))
    }

    @Test
    fun part2() {
        assertEquals(BigInteger("4174379265"), underTest.part2())
    }

    @ParameterizedTest
    @CsvSource(
        "55, true",
        "6464, true",
        "123123, true",
        "101, false",
        "998, false",
        "11122, false",
        "646464, true",
        "1, false",
        "1111111, true"
    )
    fun checksIdsAreInvalidPart2(id: BigInteger, expected: Boolean) {
        assertEquals(expected, underTest.isInvalidIdPart2(id))
    }

}