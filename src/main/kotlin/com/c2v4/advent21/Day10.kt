package com.c2v4.advent21

fun syntaxScoring(input: String) =
    input.split(EOL).sumOf { calculateScore(it) }

val counterParts = mapOf(
    ')' to '(',
    ']' to '[',
    '}' to '{',
    '>' to '<'
)

private fun calculateScore(line: String): Int {
    tailrec fun go(index: Int, open: List<Char>): Int {
        if (index >= line.length) return 0
        val char = line[index]
        return when (char) {
            '(', '{', '[', '<' -> go(index + 1, open + char)
            ')', '}', ']', '>' -> {
                if (open.last() == counterParts[char]) go(index + 1, open.dropLast(1))
                else when (char) {
                    ')' -> 3
                    ']' -> 57
                    '}' -> 1197
                    '>' -> 25137
                    else -> throw IllegalArgumentException("$char is not a valid character")
                }
            }
            else -> throw IllegalArgumentException("$char is not a valid character")
        }
    }

    return go(0, emptyList())
}

fun main(args: Array<String>) {
    println(syntaxScoring("day10.txt".asResource()))
}

