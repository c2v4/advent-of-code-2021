package com.c2v4.advent21

val neighbors = setOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun smokeBasin(input: String) =
    input.split(EOL).map { it.toCharArray().map { Character.getNumericValue(it).toLong() } }.let { map ->
        (map.indices).flatMap { y ->
            (map[0].indices).filter { x ->
                isLocalLowestPoint(map, x, y)
            }.map { x ->
                map[y][x]
            }
        }
    }.sumOf { it + 1 }

fun isLocalLowestPoint(map: List<List<Long>>, x: Int, y: Int): Boolean {
    val currentPoint = map[y][x]
    val neighborPoints = neighbors.mapNotNull { (dx, dy) ->
        map.getOrNull(y + dy)?.getOrNull(x + dx)
    }
    return neighborPoints.all { it > currentPoint }
}

fun main(args: Array<String>) {
    println(smokeBasin("day9.txt".asResource()))
}

