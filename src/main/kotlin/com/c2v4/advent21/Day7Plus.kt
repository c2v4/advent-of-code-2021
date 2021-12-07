package com.c2v4.advent21

import kotlin.math.abs
import kotlin.math.pow

/*
As it turns out, crab submarine engines don't burn fuel at a constant rate. Instead, each change of 1 step in horizontal position costs 1 more unit of fuel than the last: the first step costs 1, the second step costs 2, the third step costs 3, and so on.

As each crab moves, moving further becomes more expensive. This changes the best horizontal position to align them all on; in the example above, this becomes 5:

Move from 16 to 5: 66 fuel
Move from 1 to 5: 10 fuel
Move from 2 to 5: 6 fuel
Move from 0 to 5: 15 fuel
Move from 4 to 5: 1 fuel
Move from 2 to 5: 6 fuel
Move from 7 to 5: 3 fuel
Move from 1 to 5: 10 fuel
Move from 2 to 5: 6 fuel
Move from 14 to 5: 45 fuel
This costs a total of 168 fuel. This is the new cheapest possible outcome; */

fun theTreacheryOfWhales2(input: String) =
    input.split(",").map { it.toInt() }.let { positions ->
        (0..positions.maxOrNull()!!).minOf { target ->
            positions.sumOf { (1 + abs(target - it)) * abs(target - it) / 2 }
        }
    }

fun main(args: Array<String>) {
    println(theTreacheryOfWhales2("day7.txt".asResource()))
}

