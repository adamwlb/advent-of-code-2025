package io.github.adamwlb.aoc2025.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankTest {

    @ParameterizedTest
    @MethodSource("joltageTestCases")
    fun calculatesMaxJoltage(bank: Bank, maxJoltage: Int) {
        assertEquals(maxJoltage, bank.maxJoltage())
    }

    @ParameterizedTest
    @MethodSource("overrideJoltageTestCases")
    fun calculatesOverrideMaxJoltage(bank: Bank, maxJoltage: BigInteger) {
        assertEquals(maxJoltage, bank.maxOverrideJoltage())
    }

    fun joltageTestCases() = listOf(
        arrayOf(Bank(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)), 98),
        arrayOf(Bank(listOf(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)), 89),
        arrayOf(Bank(listOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)), 78),
        arrayOf(Bank(listOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)), 92)
    )

    fun overrideJoltageTestCases() = listOf(
        arrayOf(Bank(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)), BigInteger("987654321111")),
        arrayOf(Bank(listOf(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)), BigInteger("811111111119")),
        arrayOf(Bank(listOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)), BigInteger("434234234278")),
        arrayOf(Bank(listOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)), BigInteger("888911112111"))
    )
}