package com.c2v4.advent21

/*
On the other hand, it might be wise to try a different strategy: let the giant squid win.

You aren't sure how many bingo boards a giant squid could play at once, so rather than waste time counting its arms, the safe thing to do is to figure out which board will win last and choose that one. That way, no matter which boards it picks, it will win for sure.

In the above example, the second board is the last to win, which happens after 13 is eventually called and its middle column is completely marked. If you were to keep playing until this point, the second board would have a sum of unmarked numbers equal to 148 for a final score of 148 * 13 = 1924.

Figure out which board will win last. Once it wins, what would its final score be?*/

fun giantSquid2(input: String) = input.split(EOL)
    .let { data ->
        data.first().split(",").map { it.toInt() }.cummulativeSublist() to
                data.drop(1).filter { it.isNotEmpty() }.windowed(5, 5)
                    .map { it.map { it.split(" ").filter { it.isNotBlank() }.map { it.toInt() } } }
    }.let { (drawHistories, boards) ->
        drawHistories.asSequence()
            .map { currentDrawlist -> currentDrawlist to boards.filter { isWinner(it, currentDrawlist) } }
            .first { it.second.size == boards.size }
            .let { (drawnNumbers,boards) -> drawnNumbers to boards.filter { !isWinner(it, drawnNumbers.dropLast(1)) } }
            .let { calculateScore(it.second.first(), it.first) }
    }



private fun List<List<Int>>.transpose(): List<List<Int>> =
    (0..4).map { index ->
        map { it[index] }
    }

private fun <T> List<T>.cummulativeSublist(): List<List<T>> {
    val list = mutableListOf<List<T>>()
    for (i in this.indices.drop(1)) {
        list.add(subList(0, i))
    }
    return list
}

private fun isWinner(board: List<List<Int>>, drawn: List<Int>): Boolean {
    val rows = board.map { it.filter { drawn.contains(it) }.toSet() }
    val cols = board.transpose().map { it.filter { drawn.contains(it) }.toSet() }
//    val diag1 = board.mapIndexed { i, row -> row[i] }.filter { drawn.contains(it) }.toSet()
//    val diag2 = board.mapIndexed { i, row -> row[4 - i] }.filter { drawn.contains(it) }.toSet()
    return rows.any { it.size == 5 } || cols.any { it.size == 5 } //|| diag1.size == 5 || diag2.size == 5
}

private fun calculateScore(board: List<List<Int>>, drawn: List<Int>) =
    board.map { it.filter { !drawn.contains(it) }.sum() }.sum() * drawn.last()

fun main(args: Array<String>) {
    println(giantSquid2("day4.txt".asResource()))
}

