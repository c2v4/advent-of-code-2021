package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day2PlusTest : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            dive2(
                "forward 5\n" +
                        "down 5\n" +
                        "forward 8\n" +
                        "up 3\n" +
                        "down 8\n" +
                        "forward 2"
            )
        ).isEqualTo(900)
    }
}
