package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day12PlusTest : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            passagePathing2(
                "start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end"
            )
        ).isEqualTo(36)
    }
}
