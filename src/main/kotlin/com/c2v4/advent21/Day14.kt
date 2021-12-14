package com.c2v4.advent21

import arrow.syntax.function.memoize


fun extendedPolymerization(input: String, steps: Int = 10) = input.split(PARAGRAPH).let { (template, replacements) ->
    template to replacements.split(EOL).fold(emptyMap<String, String>()) { acc, replacement ->
        val split = replacement.split(" -> ")
        acc + (split[0] to (split[0].first() + "" + split[1].first() + split[0].last()))

    }
}.let { (template, replacements) ->
    val frequency = calculateSteps(template, replacements, steps)
    (frequency.maxByOrNull { it.value }?.value ?: 0) - (frequency
        .minByOrNull { it.value }?.value ?: 0)
}

//Could be solved with an array long[24] and changed by array[char - 'A']++ but I wanted to have an immutable data structure
private fun calculateSteps(
    input: String,
    replacements: Map<String, String>,
    steps: Int
): Map<Char, Long> {
    var memoized: (String, Int) -> Map<Char, Long> = {s, i -> emptyMap() }
     memoized =
        { input: String,
          steps: Int ->
            when {
                (input.isEmpty()) -> emptyMap()
                (input.length == 1) -> mapOf(input.first() to 1L)
                (steps == 0) -> input.groupingBy { it }.eachCount().mapValues { it.value.toLong() }
                else -> input.asSequence().windowed(2).mapIndexed { index, window ->
                    val s = replacements[window.joinToString("") { it.toString() }]
                    if (s == null) mapOf(window.first() to 1L)
                    else {
                        val calculateSteps = memoized(s, steps - 1)
                        if (index == 0) calculateSteps
                        else calculateSteps + (window.first() to calculateSteps.getOrDefault(window.first(), 0L) - 1)
                    }
                }.reduce { acc, map -> combineValuesInMaps(acc, map) }
            }
        }.memoize()
    return memoized(input, steps)
}

private fun combineValuesInMaps(
    first: Map<Char, Long>,
    second: Map<Char, Long>
) = (first.asSequence() + second.asSequence())
    .groupBy({ it.key }, { it.value })
    .mapValues { (_, values) -> values.sum() }

fun main(args: Array<String>) {
    println(extendedPolymerization("day14.txt".asResource(), 40))
}

