package com.c2v4.advent21

import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder


fun passagePathing2(input: String) = input.split(EOL).fold(GraphBuilder.undirected().build<String>()) { graph, line ->
    val (a, b) = line.split("-")
    graph.putEdge(a, b)
    graph
}.let { calculatePaths(it) }

private fun calculatePaths(graph: Graph<String>): Int {
    fun smallCavesVisitedAtMostOnce(pathSoFar: List<String>): Boolean =
        pathSoFar.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.all { isBigCave(it) }


    fun go(pathSoFar: List<String>): Set<List<String>> {
        val current = pathSoFar.last()
        if (current == "end") return setOf(pathSoFar)
        val next = graph.successors(current)
            .filter {
                it != "start" && (isBigCave(it) || smallCavesVisitedAtMostOnce(pathSoFar) || !pathSoFar.contains(
                    it
                ))
            }
        return next.flatMap { go(pathSoFar + it) }.toSet()
    }
    return go(listOf("start")).filter { it.isNotEmpty() }.distinct().size
}


fun main(args: Array<String>) {
    println(passagePathing2("day12.txt".asResource()))
}

