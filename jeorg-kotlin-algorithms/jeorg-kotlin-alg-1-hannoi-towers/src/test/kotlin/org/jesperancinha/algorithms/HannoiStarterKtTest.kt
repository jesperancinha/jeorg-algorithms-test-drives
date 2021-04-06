package org.jesperancinha.algorithms

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class HannoiStarterKtTest : DescribeSpec({
    describe("Can Move") {
        val positions = intArrayOf(1, 1, 1)
        canMove(positions,0) shouldBe  true
        canMove(positions,1) shouldBe  false
        canMove(positions,2) shouldBe  false

        val positions2 = intArrayOf(2, 2, 1)
        canMove(positions2,0) shouldBe  true
        canMove(positions2,1) shouldBe  false
        canMove(positions2,2) shouldBe  true
    }
    describe("Calculate Moves") {
        val positions = intArrayOf(1, 1, 1)
        val calculatePiramidMoves = calculatePiramidMoves(positions, null, 0)
        calculatePiramidMoves shouldHaveSize 2
        calculatePiramidMoves[0].positions shouldBe intArrayOf(2,1,1)
        calculatePiramidMoves[1].positions shouldBe intArrayOf(3,1,1)

        val positions2 = intArrayOf(2, 2, 1)
        val calculatePiramidMoves2 = calculatePiramidMoves(positions2, null, 0)
        calculatePiramidMoves shouldHaveSize 2
        calculatePiramidMoves2[0].positions shouldBe intArrayOf(1,2,1)
        calculatePiramidMoves2[1].positions shouldBe intArrayOf(3,2,1)
        val calculatePiramidMoves21 = calculatePiramidMoves(positions2, null, 1)
        calculatePiramidMoves21 shouldHaveSize 0
        val calculatePiramidMoves22 = calculatePiramidMoves(positions2, null, 2)
        calculatePiramidMoves22 shouldHaveSize 1
        calculatePiramidMoves22[0].positions shouldBe intArrayOf(2,2,3)

        val positions3 = intArrayOf(3,1,1)
        val calculatePiramidMoves3 = calculatePiramidMoves(positions3, null, 1)
        calculatePiramidMoves3 shouldHaveSize 1
        calculatePiramidMoves3[0].positions shouldBe intArrayOf(3,2,1)



    }

})