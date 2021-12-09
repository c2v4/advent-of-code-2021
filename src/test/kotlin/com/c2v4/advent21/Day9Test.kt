package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day9Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            smokeBasin(
                "2199943210\n" +
                        "3987894921\n" +
                        "9856789892\n" +
                        "8767896789\n" +
                        "9899965678"
            )
        ).isEqualTo(15)
    }
}
