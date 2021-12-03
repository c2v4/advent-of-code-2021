package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day3Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            binaryDiagnostic(
                "00100\n" +
                        "11110\n" +
                        "10110\n" +
                        "10111\n" +
                        "10101\n" +
                        "01111\n" +
                        "00111\n" +
                        "11100\n" +
                        "10000\n" +
                        "11001\n" +
                        "00010\n" +
                        "01010"
            )
        ).isEqualTo(198)
    }
}
