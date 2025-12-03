package io.github.adamwlb.aoc2025

import io.github.adamwlb.aoc2025.day1.Day1
import io.github.adamwlb.aoc2025.day2.Day2
import io.github.adamwlb.aoc2025.day3.Day3

fun main() {
    day1()
    day2()
    day3()
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