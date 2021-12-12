package com.c2v4.advent21

import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder


fun passagePathing(input: String) = input.split(EOL).fold(GraphBuilder.undirected().build<String>()) { graph, line ->
    val (a, b) = line.split("-")
    graph.putEdge(a, b)
    graph
}
    .let { calculatePaths(it) }

private fun calculatePaths(graph: Graph<String>): Int {
    fun go(pathSoFar: List<String>): Set<List<String>> {
        val current = pathSoFar.last()
        if (current == "end") return setOf(pathSoFar)
        val next = graph.successors(current).filter { isBigCave(it) || !pathSoFar.contains(it) }
        return next.flatMap { go(pathSoFar + it) }.toSet()
    }
    return go( listOf("start")).distinct().size
}

fun isBigCave(cave: String): Boolean = cave == cave.toUpperCase()

fun main(args: Array<String>) {
    println(passagePathing("day12.txt".asResource()))
}

