package com.c2v4.advent21

import kotlin.math.max
import kotlin.math.min

/*
They tend to form in lines; the submarine helpfully produces a list of nearby lines of vents (your puzzle input) for you to review. For example:

0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
Each line of vents is given as a line segment in the format x1,y1 -> x2,y2 where x1,y1 are the coordinates of one end the line segment and x2,y2 are the coordinates of the other end. These line segments include the points at both ends. In other words:

An entry like 1,1 -> 1,3 covers points 1,1, 1,2, and 1,3.
An entry like 9,7 -> 7,7 covers points 9,7, 8,7, and 7,7.
For now, only consider horizontal and vertical lines: lines where either x1 = x2 or y1 = y2.

So, the horizontal and vertical lines from the above list would produce the following diagram:

.......1..
..1....1..
..1....1..
.......1..
.112111211
..........
..........
..........
..........
222111....
In this diagram, the top left corner is 0,0 and the bottom right corner is 9,9. Each position is shown as the number of lines which cover that point or . if no line covers that point. The top-left pair of 1s, for example, comes from 2,2 -> 2,1; the very bottom row is formed by the overlapping lines 0,9 -> 5,9 and 0,9 -> 2,9.

To avoid the most dangerous areas, you need to determine the number of points where at least two lines overlap. In the above example, this is anywhere in the diagram with a 2 or larger - a total of 5 points.
*/

fun hydrothermalVenture(input: String) = input.split(EOL)
    .asSequence()
    .map {
        it.split(" -> ").map { it.split(",").map { it.toInt() } }.let { Line(it[0][0], it[0][1], it[1][0], it[1][1]) }
    }.filter { it.isStraight() }
    .flatMap { it.getPoints() }
    .fold(mutableMapOf<Point, Int>()) { acc, point ->
        acc[point] = (acc[point] ?: 0) + 1
        acc
    }.values.count { it >= 2 }


data class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int)

fun Line.isHorizontal() = x1 == x2
fun Line.isVertical() = y1 == y2
fun Line.isStraight() = isHorizontal() || isVertical()

fun Line.getPoints(): List<Point> = when {
    isHorizontal() -> {
        val min = min(y1, y2)
        val max = max(y1, y2)
        (min..max).map { Point(x1, it) }
    }
    isVertical() -> {
        val min = min(x1, x2)
        val max = max(x1, x2)
        (min..max).map { Point(it, y1) }
    }
    isDiagonal() -> {
        val minX = min(x1, x2)
        val maxX = max(x1, x2)
        val minY = if (x1 == minX) y1 else y2
        (minX..maxX).map { x ->
            Point(x, minY + if (isRaising()) (x - minX) else -(x - minX))
        }
    }
    else -> throw IllegalArgumentException("Line is not horizontal, vertical or diagonal")
}

private fun Line.isRaising() = (x1 == min(x1, x2)) == (y1 == min(y1, y2))

data class Point(val x: Int, val y: Int)

fun main(args: Array<String>) {
    println(hydrothermalVenture("day5.txt".asResource()))
}

