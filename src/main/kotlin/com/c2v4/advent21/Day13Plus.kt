package com.c2v4.advent21


fun transparentOrigami2(input: String) = input.split(PARAGRAPH).let {
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
    folds.fold(initialDots) { dots, fold ->
        fold.fold(dots)
    }.sortedWith(compareBy<Point> { it.x }.thenBy { it.y })
}.let {
    (0..it.last().y).forEach { y ->
        val currentLine = it.filter { it.y == y }
        val maxX = currentLine.maxByOrNull { it.x }!!
        (0..maxX.x).forEach { x ->
            val currentPoint = Point(x, y)
            if (currentLine.contains(currentPoint)) {
                print("#")
            } else {
                print(".")
            }
        }
        println()
    }
}


fun main(args: Array<String>) {
    println(transparentOrigami2("day13.txt".asResource()))
}

