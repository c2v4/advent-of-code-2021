package com.c2v4.advent21

import kotlin.math.abs

private val allowedLengths = setOf(2, 3, 4, 7)

fun sevenSegment(input: String) =
    input.split(EOL).map { it.split(" | ")[1].split(" ").count { allowedLengths.contains(it.length) } }.sum()

fun main(args: Array<String>) {
    println(sevenSegment("day8.txt".asResource()))
}

