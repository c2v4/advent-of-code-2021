package com.c2v4.advent21

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day8PlusTest : AnnotationSpec() {

    @Test
    fun test() {
        Assertions.assertThat(
            sevenSegment2(
                "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"
            )
        ).isEqualTo(5353)
    }


    @Test
    fun test2() {
        Assertions.assertThat(
            sevenSegment2(
                "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe\\n\" +\n" +
                        "                        \"edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc\\n\" +\n" +
                        "                        \"fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg\\n\" +\n" +
                        "                        \"fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb\\n\" +\n" +
                        "                        \"aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea\\n\" +\n" +
                        "                        \"fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb\\n\" +\n" +
                        "                        \"dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe\\n\" +\n" +
                        "                        \"bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef\\n\" +\n" +
                        "                        \"egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb\\n\" +\n" +
                        "                        \"gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"
            )
        ).isEqualTo(61229)
    }
}
