package com.c2v4.advent21


fun smokeBasin2(input: String) =
    input.split(EOL).map { it.toCharArray().map { Character.getNumericValue(it).toLong() } }.let { map ->
        (map.indices).flatMap { y ->
            (map[0].indices).filter { x ->
                isLocalLowestPoint(map, x, y)
            }.map { x ->
                x to y
            }.map { (x, y) ->
                val toVisit = mutableListOf(x to y)
                val visited = mutableListOf<Pair<Int, Int>>()
                var size = 1
                while (toVisit.isNotEmpty()) {
                    val current = toVisit.removeAt(0)
                    visited.add(current)
                    val considered = getNeighbors(current).filter {
                        val value = map.getOrNull(it.second)?.getOrNull(it.first) ?: 9L
                        it !in visited && it !in toVisit && value != 9L
                    }
                    size += considered.size
                    toVisit.addAll(considered)
                }
                size
            }
        }
    }.sorted().takeLast(3).fold(1L) { acc, i ->
        acc * i
    }

fun getNeighbors(point: Pair<Int, Int>) = neighbors.map { it.first + point.first to it.second + point.second }

fun main(args: Array<String>) {
    println(smokeBasin2("day9.txt".asResource()))
}

