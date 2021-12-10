package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day10PlusTest : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            syntaxScoring2(
                "[({(<(())[]>[[{[]{<()<>>\n" +
                        "[(()[<>])]({[<{<<[]>>(\n" +
                        "{([(<{}[<>[]}>{[]{[(<()>\n" +
                        "(((({<>}<{<{<>}{[]{[]{}\n" +
                        "[[<[([]))<([[{}[[()]]]\n" +
                        "[{[{({}]{}}([{[{{{}}([]\n" +
                        "{<[[]]>}<{[{[{[]{()[[[]\n" +
                        "[<(<(<(<{}))><([]([]()\n" +
                        "<{([([[(<>()){}]>(<<{{\n" +
                        "<{([{{}}[<[[[<>{}]]]>[]]"
            )
        ).isEqualTo(288957)
    }
}
