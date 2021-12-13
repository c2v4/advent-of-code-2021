package com.c2v4.advent21


fun transparentOrigami(input: String) = input.split(PARAGRAPH).let {
    val dots = it.first().split(EOL).map {
        val split = it.split(",")
        Point(split[0].toInt(), split[1].toInt())
    }.toSet()
    val folds = it.last().split(EOL).map {
        val split = it.split("=")
        val line = split[1].toInt()
        when (split[0].last()) {
            'y' -> Fold.Vertical(line)
            'x' -> Fold.Horizontal(line)
            else -> throw IllegalArgumentException("Unknown fold direction: ${split[0]}")
        }
    }
    dots to folds
}.let { (initialDots, folds) ->
    folds.first().fold(initialDots).size
}

sealed class Fold(val line: Int) {
    abstract fun fold(dots: Set<Point>): Set<Point>
    class Horizontal(x: Int) : Fold(x) {
        override fun fold(dots: Set<Point>): Set<Point> =
            dots.filter { it.x != line }.map { if (it.x > line) it.copy(x = it.x - (it.x - line) * 2) else it }.toSet()

    }

    class Vertical(y: Int) : Fold(y) {
        override fun fold(dots: Set<Point>): Set<Point> =
            dots.filter { it.y != line }.map { if (it.y > line) it.copy(y = it.y - (it.y - line) * 2) else it }.toSet()

    }
}

fun main(args: Array<String>) {
    println(transparentOrigami("day13.txt".asResource()))
}

