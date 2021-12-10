package com.c2v4.advent21

fun syntaxScoring2(input: String) =
    input.split(EOL).map { calculateLine(it) }.filter { it != 0L }.sorted().let { it[it.size / 2] }

private fun calculateLine(line: String): Long {
    tailrec fun go(index: Int, open: List<Char>): Long {
        if (index >= line.length) return calculateScore(open)
        val char = line[index]
        return when (char) {
            '(', '{', '[', '<' -> go(index + 1, open + char)
            ')', '}', ']', '>' -> {
                if (open.last() == counterParts[char]) go(index + 1, open.dropLast(1))
                else 0
            }
            else -> throw IllegalArgumentException("$char is not a valid character")
        }
    }

    return go(0, emptyList())
}

val scoreValues = mapOf(
    '(' to 1,
    '[' to 2,
    '{' to 3,
    '<' to 4,
)

private fun calculateScore(open: List<Char>): Long = open.map { scoreValues[it] }.foldRight(0L) { i, acc -> acc * 5L + i!! }


fun main(args: Array<String>) {
    println(syntaxScoring2("day10.txt".asResource()))
}

