package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day6Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            latternfish(
                "3,4,3,1,2", 80
            )
        ).isEqualTo(5934)
    }

    @Test
    fun test2() {
        Assertions.assertThat(
            latternfish(
                "3,4,3,1,2", 18
            )
        ).isEqualTo(26)
    }
}
