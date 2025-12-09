package io.github.adamwlb.aoc2025.day6

import io.github.adamwlb.aoc2025.day6.Problem.Operator.MULTIPLY
import io.github.adamwlb.aoc2025.day6.Problem.Operator.PLUS
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProblemTest {
    
    @ParameterizedTest
    @MethodSource("problemTestCases")
    fun `can solve individual sample input problems`(problem: Problem, solution: BigInteger) {
        assertEquals(solution, problem.solve())
    }

    fun problemTestCases() = listOf(
        arrayOf(Problem(listOf(123, 45, 6), MULTIPLY), BigInteger("33210")),
        arrayOf(Problem(listOf(328, 64, 98), PLUS), BigInteger("490")),
        arrayOf(Problem(listOf(51, 387, 215), MULTIPLY), BigInteger("4243455")),
        arrayOf(Problem(listOf(64, 23, 314), PLUS), BigInteger("401"))
    )
}