package com.c2v4.advent21

fun sonarSweep(input: String) = input.split(EOL)
    .map { it.toInt() }
    .zipWithNext()
    .fold(0) { acc, (a, b) -> acc + if (b > a) 1 else 0 }

fun main(args: Array<String>) {
    println(sonarSweep("day1.txt".asResource()))
}
