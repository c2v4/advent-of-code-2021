package com.c2v4.advent21


fun String.asResource() = Thread.currentThread().contextClassLoader.getResource(this).readText()

val EOL = Regex("\\r?\\n")

val PARAGRAPH = Regex("\\r?\\n\\r?\\n")