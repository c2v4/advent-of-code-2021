package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day11Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            dumboOctopus(
                "5483143223\n" +
                        "2745854711\n" +
                        "5264556173\n" +
                        "6141336146\n" +
                        "6357385478\n" +
                        "4167524645\n" +
                        "2176841721\n" +
                        "6882881134\n" +
                        "4846848554\n" +
                        "5283751526"
            )
        ).isEqualTo(1656)
    }
}
