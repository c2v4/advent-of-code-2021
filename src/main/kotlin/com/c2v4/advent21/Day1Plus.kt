package com.c2v4.advent21

fun sonarSweep2(input: String): Int =
    input.split(EOL)
        .asSequence()
        .map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .zipWithNext()
        .fold(0) { acc, (a, b) -> acc + if (b > a) 1 else 0 }

fun main(args: Array<String>) {
    println(sonarSweep2("day1.txt".asResource()))
}
