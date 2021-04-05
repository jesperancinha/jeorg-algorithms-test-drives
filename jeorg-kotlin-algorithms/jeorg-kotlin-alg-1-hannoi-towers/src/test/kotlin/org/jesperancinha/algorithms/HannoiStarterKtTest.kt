package org.jesperancinha.algorithms

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.jesperancinha.algorithms.data.PiramidElement

class HannoiStarterKtTest : DescribeSpec({
    describe("Left Node Calculation") {
        val starNode = intArrayOf(1, 1, 1)
        val firstNode = PiramidElement(starNode)
        val leftNode = calculateLeftNode(firstNode)
        leftNode!!.positions shouldBe intArrayOf(2, 1, 1)
    }
    describe("Right Node Calculation") {
        val starNode = intArrayOf(1, 1, 1)
        val firstNode = PiramidElement(starNode)
        val leftNode = calculateRightNode(firstNode)
        leftNode!!.positions shouldBe intArrayOf(3, 1, 1)
    }
})