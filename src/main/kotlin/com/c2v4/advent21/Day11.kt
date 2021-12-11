package com.c2v4.advent21


fun dumboOctopus(input: String, steps: Int = 100) = input.split(EOL)
    .foldIndexed(emptyMap<Point, Int>()) { y, acc, line ->
        acc + line.toCharArray().mapIndexed { x, char -> Point(x, y) to Character.getNumericValue(char) }
    }
    .let { simulate(it, steps) }

private fun simulate(initialMap: Map<Point, Int>, initialSteps: Int): Int {
    tailrec fun go(map: Map<Point, Int>, steps: Int, flashes: Int): Int {
        if (steps < 1) return flashes
        val (newMap, newFlashes) = calculateStep(map)
        return go(newMap, steps - 1, flashes + newFlashes)
    }
    return go(initialMap, initialSteps, 0)
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

fun getNeighbors(point: Point): Set<Point> =
    (point.x - 1..point.x + 1).flatMap { x ->
        (point.y - 1..point.y + 1).map { y -> Point(x, y) }
    }.filter { it != point }.toSet()

fun main(args: Array<String>) {
    println(dumboOctopus("day11.txt".asResource()))
}

