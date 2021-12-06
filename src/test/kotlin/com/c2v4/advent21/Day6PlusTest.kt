package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day6PlusTest : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            latternfish(
                "3,4,3,1,2", 256
            )
        ).isEqualTo(26984457539)
    }

}
