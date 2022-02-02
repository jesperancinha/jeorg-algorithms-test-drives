package org.jesperancinha.algorithms.weigh.term.frequency

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WeighTermFrequencyKtTest : FunSpec({

    test("multiply") {
        val listA = listOf(1, 2, 3)
        val listB = listOf(1, 2, 3)
        multiply(listA, listB) shouldBe 14
    }
})
