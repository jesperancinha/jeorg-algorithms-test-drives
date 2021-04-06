package org.jesperancinha.algorithms

import org.jesperancinha.algorithms.data.PiramidElement


fun main(args: Array<String>) {
    val starNode = intArrayOf(1, 1, 1)
    val firstNode = PiramidElement(starNode)
    calculateStartTriangle(firstNode)
}

fun calculateStartTriangle(firstNode: PiramidElement) {
    val nodeMap = mutableMapOf<String, PiramidElement>()
    calculateTriangle(firstNode, null, nodeMap)

    println(firstNode)
}

fun calculateTriangle(
    firstNode: PiramidElement,
    ignorePositions: IntArray?,
    nodeMap: MutableMap<String, PiramidElement>
) {
    for (i in 0..2) {
        val calculatePiramidMoves = calculatePiramidMoves(firstNode.positions, ignorePositions, i)
        firstNode.connections.addAll(calculatePiramidMoves)
    }
    nodeMap[firstNode.positions.contentToString()] = firstNode
    if (firstNode.connections.size > 0) {
        firstNode.connections.forEach {
            if(nodeMap[it.positions.contentToString()] ==null) {
                calculateTriangle(it, firstNode.positions, HashMap(nodeMap))
            }
        }
    }
}

fun calculatePiramidMoves(positions: IntArray, ignorePositions: IntArray?, i: Int): List<PiramidElement> {
    val calcList = mutableListOf<PiramidElement>()
    val canMove: Boolean = canMove(positions, i)
    if (canMove) {
        if (i == 0) {
            for (j in 0..positions.size - 1) {
                if (j + 1 != positions[0]) {
                    val newPositions = positions.clone()
                    newPositions[0] = j + 1
                    if (ignorePositions == null || !ignorePositions.contentEquals(newPositions)) {
                        calcList.add(PiramidElement(newPositions))
                    }
                }
            }
        }

        if (i == 1) {
            for (j in 0..positions.size - 1) {
                if (j + 1 != positions[0] && j + 1 != positions[1]) {
                    val newPositions = positions.clone()
                    newPositions[1] = j + 1
                    if (ignorePositions == null || !ignorePositions.contentEquals(newPositions)) {
                        calcList.add(PiramidElement(newPositions))
                    }
                }
            }
        }

        if (i == 2) {
            for (j in 0..positions.size - 1) {
                if (positions.indexOf(j + 1) == -1) {
                    val newPositions = positions.clone()
                    newPositions[2] = j + 1
                    if (ignorePositions == null || !ignorePositions.contentEquals(newPositions)) {
                        calcList.add(PiramidElement(newPositions))
                    }
                }
            }
        }
    }
    return calcList
}

fun canMove(positions: IntArray, i: Int): Boolean {
    if (i == 0) {
        return true;
    }
    for (j in 0 until i) {
        if (positions[j] == positions[i]) {
            return false
        }
    }
    return true
}
