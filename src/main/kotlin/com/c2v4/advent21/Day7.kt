package com.c2v4.advent21

import kotlin.math.abs


/*
For example, consider the following horizontal positions:

16,1,2,0,4,2,7,1,2,14
This means there's a crab with horizontal position 16, a crab with horizontal position 1, and so on.

Each change of 1 step in horizontal position of a single crab costs 1 fuel. You could choose any horizontal position to align them all on, but the one that costs the least fuel is horizontal position 2:

Move from 16 to 2: 14 fuel
Move from 1 to 2: 1 fuel
Move from 2 to 2: 0 fuel
Move from 0 to 2: 2 fuel
Move from 4 to 2: 2 fuel
Move from 2 to 2: 0 fuel
Move from 7 to 2: 5 fuel
Move from 1 to 2: 1 fuel
Move from 2 to 2: 0 fuel
Move from 14 to 2: 12 fuel
This costs a total of 37 fuel. This is the cheapest possible outcome*/

fun theTreacheryOfWhales(input: String) =
    input.split(",").map { it.toInt() }.let { positions ->
        (0..positions.maxOrNull()!!).minOf { target ->
            positions.sumOf { abs(target - it) }
        }
    }

fun main(args: Array<String>) {
    println(theTreacheryOfWhales("day7.txt".asResource()))
}

