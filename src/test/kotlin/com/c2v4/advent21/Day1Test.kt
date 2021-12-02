package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day1Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            sonarSweep(
                "199\n" +
                        "200\n" +
                        "208\n" +
                        "210\n" +
                        "200\n" +
                        "207\n" +
                        "240\n" +
                        "269\n" +
                        "260\n" +
                        "263"
            )
        ).isEqualTo(7)
    }
}
