package com.c2v4.advent21

import com.google.common.graph.ValueGraph
import com.google.common.graph.ValueGraphBuilder

fun chiton(input: String) =
    input.split(EOL)
        .flatMapIndexed { y, line ->
            line.toCharArray().mapIndexed { x, char -> Point(x, y) to Character.getNumericValue(char) }
        }.toMap().let { map ->
            val graph = map.keys.fold(ValueGraphBuilder.undirected().build<Point, Int>()) { mutableGraph, point ->
                val right = point.copy(x = point.x + 1)
                val left = point.copy(x = point.x - 1)
                val down = point.copy(y = point.y + 1)
                val up = point.copy(y = point.y - 1)
                setOf(right, left, down, up).filter { map.containsKey(it) }
                    .forEach { mutableGraph.putEdgeValue(point, it, map[it]!!) }
                mutableGraph
            }
            val last =
                map.keys.maxWithOrNull(compareBy<Point> { it.y } then compareBy { it.x }).let { it ?: Point(0, 0) }
            dijkstra(graph, Point(0, 0), last)
        }

fun <T> dijkstra(graph: ValueGraph<T, Int>, start: T, end: T): Int {
    val distances = mutableMapOf<T, Int>()
    val predecessors = mutableMapOf<T, T>()
    val queue = mutableListOf(start)
    distances[start] = 0
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        if (current == end) break
        val currentDistance = distances[current]!!
        for (neighbor in graph.adjacentNodes(current)) {
            val neighborDistance = distances[neighbor]
            val edgeValue = graph.edgeValue(current, neighbor)
            val newDistance = currentDistance + edgeValue.orElseGet { throw IllegalStateException("No edge value") }
            if (neighborDistance == null || newDistance < neighborDistance) {
                distances[neighbor] = newDistance
                predecessors[neighbor] = current
                queue.add(neighbor)
            }
        }
    }
    return distances[end]!!
}

fun main(args: Array<String>) {
    println(chiton("day15.txt".asResource()))
}

