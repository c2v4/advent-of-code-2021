package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day12Test : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            passagePathing(
                "dc-end\n" +
                        "HN-start\n" +
                        "start-kj\n" +
                        "dc-start\n" +
                        "dc-HN\n" +
                        "LN-dc\n" +
                        "HN-end\n" +
                        "kj-sa\n" +
                        "kj-HN\n" +
                        "kj-dc"
            )
        ).isEqualTo(13)
    }

    @Test
    fun test2() {
        Assertions.assertThat(
            passagePathing(
                "fs-end\n" +
                        "he-DX\n" +
                        "fs-he\n" +
                        "start-DX\n" +
                        "pj-DX\n" +
                        "end-zg\n" +
                        "zg-sl\n" +
                        "zg-pj\n" +
                        "pj-he\n" +
                        "RW-he\n" +
                        "fs-DX\n" +
                        "pj-RW\n" +
                        "zg-RW\n" +
                        "start-pj\n" +
                        "he-WI\n" +
                        "zg-he\n" +
                        "pj-fs\n" +
                        "start-RW"
            )
        ).isEqualTo(226)
    }

    @Test
    fun test3() {
        Assertions.assertThat(
            passagePathing(
                "start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end"
            )
        ).isEqualTo(10)
    }
}
