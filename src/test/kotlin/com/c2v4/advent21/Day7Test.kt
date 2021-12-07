package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day7Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            theTreacheryOfWhales(
                "16,1,2,0,4,2,7,1,2,14"
            )
        ).isEqualTo(37)
    }
}
