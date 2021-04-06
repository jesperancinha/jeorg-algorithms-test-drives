package org.jesperancinha.algorithms.data

data class PiramidElement(
    val positions: IntArray,
    val connections: MutableList<PiramidElement> = mutableListOf()
) {
    override fun toString(): String {
        return positions.contentToString() + " => " + connections.map { it.positions.contentToString() }
    }
}
