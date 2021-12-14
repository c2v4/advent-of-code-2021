package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day14Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            extendedPolymerization(
                "NNCB\n" +
                        "\n" +
                        "CH -> B\n" +
                        "HH -> N\n" +
                        "CB -> H\n" +
                        "NH -> C\n" +
                        "HB -> C\n" +
                        "HC -> B\n" +
                        "HN -> C\n" +
                        "NN -> C\n" +
                        "BH -> H\n" +
                        "NC -> B\n" +
                        "NB -> B\n" +
                        "BN -> B\n" +
                        "BB -> N\n" +
                        "BC -> B\n" +
                        "CC -> N\n" +
                        "CN -> C"
            )
        ).isEqualTo(1588)
    }
    @Test
    fun testPlus() {
        Assertions.assertThat(
            extendedPolymerization(
                "NNCB\n" +
                        "\n" +
                        "CH -> B\n" +
                        "HH -> N\n" +
                        "CB -> H\n" +
                        "NH -> C\n" +
                        "HB -> C\n" +
                        "HC -> B\n" +
                        "HN -> C\n" +
                        "NN -> C\n" +
                        "BH -> H\n" +
                        "NC -> B\n" +
                        "NB -> B\n" +
                        "BN -> B\n" +
                        "BB -> N\n" +
                        "BC -> B\n" +
                        "CC -> N\n" +
                        "CN -> C"
            ,40)
        ).isEqualTo(1588)
    }
}
