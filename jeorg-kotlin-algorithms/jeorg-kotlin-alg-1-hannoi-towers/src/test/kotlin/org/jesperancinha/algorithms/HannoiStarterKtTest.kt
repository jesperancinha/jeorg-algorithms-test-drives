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
    describe("Left Node Calculation 2nd Level") {
        val starNode = intArrayOf(1, 1, 1)
        val firstNode = PiramidElement(starNode)
        val leftNode = calculateLeftNode(firstNode)
        leftNode!!.positions shouldBe intArrayOf(2, 1, 1)
        firstNode.left = leftNode;
        leftNode.up = firstNode
        val leftNode2 = calculateLeftNode(leftNode)
        leftNode2!!.positions shouldBe intArrayOf(2, 3, 1)
    }
    describe("Right Node Calculation 2nd Level") {
        val starNode = intArrayOf(1, 1, 1)
        val firstNode = PiramidElement(starNode)
        val rightNode = calculateRightNode(firstNode)
        rightNode!!.positions shouldBe intArrayOf(3, 1, 1)
        firstNode.right = rightNode;
        rightNode.up = firstNode
        val rightNode2 = calculateRightNode(rightNode)
        rightNode2 shouldBe null
    }
    describe("Left Node Calculation 3nd Level") {
        val starNode = intArrayOf(1, 1, 1)
        val firstNode = PiramidElement(starNode)
        val leftNode = calculateLeftNode(firstNode)
        leftNode!!.positions shouldBe intArrayOf(2, 1, 1)
        firstNode.left = leftNode;
        leftNode.up = firstNode
        val leftNode2 = calculateLeftNode(leftNode)
        leftNode2!!.positions shouldBe intArrayOf(2, 3, 1)
        leftNode2.up = leftNode
        val leftNode3 = calculateRightNode(leftNode2)
        leftNode3!!.positions shouldBe intArrayOf(3, 3, 1)
    }
})