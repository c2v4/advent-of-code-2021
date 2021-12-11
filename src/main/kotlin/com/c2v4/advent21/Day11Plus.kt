package com.c2v4.advent21


fun dumboOctopus2(input: String) = input.split(EOL)
    .foldIndexed(emptyMap<Point, Int>()) { y, acc, line ->
        acc + line.toCharArray().mapIndexed { x, char -> Point(x, y) to Character.getNumericValue(char) }
    }
    .let { simulate(it) }

private fun simulate(initialMap: Map<Point, Int>): Int {
    tailrec fun go(map: Map<Point, Int>, step: Int): Int {
        val (newMap, newFlashes) = calculateStep(map)
        if (newFlashes == 100) return step
        return go(newMap, step + 1)
    }
    return go(initialMap, 1)
}

private fun calculateStep(initialMap: Map<Point, Int>): Pair<Map<Point, Int>, Int> {

    tailrec fun go(map: Map<Point, Int>, flashed: Set<Point>): Pair<Map<Point, Int>, Int> {
        val newMap = map + flashed.map { it to 0 }
        val newFlashed = newMap.filter { it.value > 9 }.keys
        if (newFlashed.isEmpty()) return newMap to flashed.size
        val allFlashed = flashed + newFlashed
        val afterFlashMap =
            newFlashed.asSequence().flatMap { getNeighbors(it) }.filterNot { allFlashed.contains(it) }
                .filter { it.x in (0 until 10) && it.y in (0 until 10) }
                .fold(newMap) { acc, point -> acc + (point to (acc[point] ?: 0) + 1) }
        return go(afterFlashMap, allFlashed)
    }
    return go(initialMap.mapValues { it.value + 1 }, emptySet())
}

fun main(args: Array<String>) {
    println(dumboOctopus2("day11.txt".asResource()))
}

