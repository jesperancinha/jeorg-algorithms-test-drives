package org.jesperancinha.algorithms

import org.jesperancinha.algorithms.data.PiramidElement

fun main(args: Array<String>) {
    val starNode = intArrayOf(1, 1, 1)
    val firstNode = PiramidElement(starNode)
    firstNode.lowLeft = calculateLeftNode(firstNode)
}

fun calculateLeftNode(firstNode: PiramidElement): PiramidElement? {
    for (i in 0..firstNode.positions.size) {
        val piramidElement = calculateLeftNodePerPos(firstNode, i)
        if (piramidElement != null) {
            return piramidElement;
        }
    }

    return null
}

private fun calculateLeftNodePerPos(firstNode: PiramidElement, pos: Int): PiramidElement? {
    val positions = firstNode.positions
    for (i in 0..positions[pos] - 1) {
        val delta = i + 1
        if (positions[pos] - delta > 0) {
            val allPositions = intArrayOf(positions[0], positions[1], positions[2])
            allPositions[pos] = allPositions[pos] - delta
            if (firstNode.up == null || !(firstNode.up!!.positions contentEquals allPositions)) {
                return PiramidElement(allPositions)
            }
        }

    }
    for (i in positions[pos] - 1..positions.size) {
        val delta = i + 1
        if (positions[pos] + delta <= positions.size) {
            val allPositions = intArrayOf(positions[0], positions[1], positions[2])
            allPositions[pos] = allPositions[pos] + delta
            if (firstNode.up == null ||
                !(firstNode.up!!.positions contentEquals allPositions)
                && (pos == 0 || allPositions[pos] != allPositions[pos - 1])
            ) {
                return PiramidElement(allPositions)
            }
        }
    }
    return null;
}

fun calculateRightNode(firstNode: PiramidElement): PiramidElement? {
    for (i in 0..firstNode.positions.size-1) {
        val piramidElement = calculateRightNodePerPos(firstNode, i)
        if (piramidElement != null) {
            return piramidElement;
        }
    }
    return null;
}

private fun calculateRightNodePerPos(firstNode: PiramidElement, pos: Int): PiramidElement? {
    var found = false;
    val positions = firstNode.positions
    for (i in 0..positions[pos] - 1) {
        val delta = i + 1
        if (positions[pos] - delta > 0) {
            if (found) {
                val allPositions = intArrayOf(positions[0], positions[1], positions[2])
                allPositions[pos] = allPositions[pos] - delta
                if (firstNode.up == null || !(firstNode.up!!.positions contentEquals allPositions)) {
                    return PiramidElement(allPositions)
                }
            } else {
                found = true;
            }
        }

    }
    for (i in 0..positions.size) {
        val delta = i + 1
        if (positions[pos] + delta <= positions.size) {
            if (found) {
                val allPositions = intArrayOf(positions[0], positions[1], positions[2])
                allPositions[pos] = allPositions[pos] + delta
                if (firstNode.up == null ||
                    !(firstNode.up!!.positions contentEquals allPositions)
                    && (pos == 0 || allPositions[pos] < allPositions[pos - 1])
                ) {
                    return PiramidElement(allPositions)
                }
            } else {
                found = true;
            }
        }
    }
    return null;
}




