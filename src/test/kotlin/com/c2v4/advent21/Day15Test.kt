package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day15Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            chiton(
                "1163751742\n" +
                        "1381373672\n" +
                        "2136511328\n" +
                        "3694931569\n" +
                        "7463417111\n" +
                        "1319128137\n" +
                        "1359912421\n" +
                        "3125421639\n" +
                        "1293138521\n" +
                        "2311944581"
            )
        ).isEqualTo(40)
    }

}
