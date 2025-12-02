package io.github.adamwlb.aoc2025

import io.github.adamwlb.aoc2025.day1.Day1

fun main() {
    day1()
}

fun day1() {
    val inputPath = "src/main/resources/day1.txt"
    println("Day 1 part 1: " + Day1(inputPath).part1())
    println("Day 1 part 2: " + Day1(inputPath).part2())
}