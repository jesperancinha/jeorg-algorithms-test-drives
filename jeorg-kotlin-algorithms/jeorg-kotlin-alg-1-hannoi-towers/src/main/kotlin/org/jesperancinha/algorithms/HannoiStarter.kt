package org.jesperancinha.algorithms

import org.jesperancinha.algorithms.data.PiramidElement

fun main(args: Array<String>) {
    val starNode = intArrayOf(1, 1, 1)
    val firstNode = PiramidElement(starNode)
    firstNode.lowLeft = calculateLeftNode(firstNode)
}

fun calculateLeftNode(firstNode: PiramidElement): PiramidElement? {

    val positions = firstNode.positions
    for (i in 0..positions[0] - 1) {
        val delta = i + 1
        if (positions[0] - delta > 0) {
            return PiramidElement(intArrayOf(positions[0] - delta, positions[1], positions[2]))
        }

    }
    for (i in positions[0] - 1..positions.size) {
        val delta = i + 1
        if (positions[0] + delta <= positions.size) {
            return PiramidElement(intArrayOf(positions[0] + delta, positions[1], positions[2]))
        }
    }
    return null;
}

fun calculateRightNode(firstNode: PiramidElement): PiramidElement? {
    var found = false;
    val positions = firstNode.positions
    for (i in 0..positions[0] - 1) {
        val delta = i + 1
        if (positions[0] - delta > 0) {
            if (found) {
                return PiramidElement(intArrayOf(positions[0] - delta, positions[1], positions[2]))
            } else {
                found = true;
            }
        }

    }
    for (i in positions[0] - 1..positions.size) {
        val delta = i + 1
        if (positions[0] + delta <= positions.size) {
            if (found) {
                return PiramidElement(intArrayOf(positions[0] + delta, positions[1], positions[2]))
            } else {
                found = true;
            }
        }
    }
    return null;
}


