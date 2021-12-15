package com.c2v4.advent21

import com.google.common.graph.ValueGraphBuilder

fun chiton2(input: String) =
    input.split(EOL)
        .flatMapIndexed { y, line ->
            line.toCharArray().mapIndexed { x, char -> Point(x, y) to Character.getNumericValue(char) }
        }.toMap()
        .let { map ->
            val last =
                map.keys.maxWithOrNull(compareBy<Point> { it.y } then compareBy { it.x }).let { it ?: Point(0, 0) }
            map.flatMap { entry ->
                (0..4).flatMap { x ->
                    (0..4).map { y ->
                        entry.key.move(x * (last.x + 1), y * (last.y + 1)) to (entry.value + x + y) % 10
                    }
                }
            }.toMap()
        }
        .let { map ->
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

private fun Point.move(x: Int, y: Int) = Point(this.x + x, this.y + y)

fun main(args: Array<String>) {
    println(chiton("day15.txt".asResource()))
}

