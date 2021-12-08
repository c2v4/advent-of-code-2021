package com.c2v4.advent21


fun sevenSegment2(input: String) =
    input.split(EOL).sumOf { calculateALine(it) }

fun calculateALine(line: String): Int {
    val dictionary: MutableMap<Set<Char>, Char> = mutableMapOf()
    val dictionaryInput = line.split(" | ")[0].split(" ").map { it.toCharArray().toSet() }.toMutableSet()
    val value = line.split(" | ")[1].split(" ").map { it.toCharArray().toSet() }

    dictionaryInput.find { it.size == 2 }?.apply { dictionary[this] = '1';dictionaryInput.remove(this) }
    val seven =
        dictionaryInput.find { it.size == 3 }?.apply { dictionary[this] = '7';dictionaryInput.remove(this) }!!
    dictionaryInput.find { it.size == 4 }?.apply { dictionary[this] = '4';dictionaryInput.remove(this) }
    dictionaryInput.find { it.size == 7 }?.apply { dictionary[this] = '8';dictionaryInput.remove(this) }

    val three = dictionaryInput.find { it.size == 5 && it.containsAll(seven) }
        ?.apply { dictionary[this] = '3';dictionaryInput.remove(this) }!!
    dictionaryInput.find { it.size == 6 && !it.containsAll(seven) }
        ?.apply { dictionary[this] = '6';dictionaryInput.remove(this) }!!
    dictionaryInput.find { it.size == 6 && it.minus(three).size == 2 }
        ?.apply { dictionary[this] = '0';dictionaryInput.remove(this) }
    val nine = dictionaryInput.find { it.size == 6 }?.apply { dictionary[this] = '9';dictionaryInput.remove(this) }!!


    dictionaryInput.find { nine.minus(it).size == 1 }?.apply { dictionary[this] = '5';dictionaryInput.remove(this) }
    dictionary[dictionaryInput.first()] = '2'

    return value.map { dictionary[it] }.joinToString(separator = "").toInt()
}

fun main(args: Array<String>) {
    println(sevenSegment2("day8.txt".asResource()))
}

