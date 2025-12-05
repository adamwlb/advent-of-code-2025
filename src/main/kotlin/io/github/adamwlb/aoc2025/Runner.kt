package io.github.adamwlb.aoc2025

import io.github.adamwlb.aoc2025.day1.Day1
import io.github.adamwlb.aoc2025.day2.Day2
import io.github.adamwlb.aoc2025.day3.Day3
import io.github.adamwlb.aoc2025.day4.Day4
import io.github.adamwlb.aoc2025.day5.Day5

fun main() {
    day1()
    day2()
    day3()
    day4()
    day5()
}

fun day1() {
    val inputPath = "src/main/resources/day1.txt"
    println("Day 1 part 1: " + Day1(inputPath).part1())
    println("Day 1 part 2: " + Day1(inputPath).part2())
}

fun day2() {
    val inputPath = "src/main/resources/day2.txt"
    println("Day 2 part 1: " + Day2(inputPath).part1())
    println("Day 2 part 2: " + Day2(inputPath).part2())
}

fun day3() {
    val inputPath = "src/main/resources/day3.txt"
    println("Day 3 part 1: " + Day3(inputPath).part1())
    println("Day 3 part 2: " + Day3(inputPath).part2())
}

fun day4() {
    val inputPath = "src/main/resources/day4.txt"
    println("Day 4 part 1: " + Day4(inputPath).part1())
    println("Day 4 part 2: " + Day4(inputPath).part2())
}

fun day5() {
    val inputPath = "src/main/resources/day5.txt"
    println("Day 5 part 1: " + Day5(inputPath).part1())
    println("Day 5 part 2: " + Day5(inputPath).part2())
}