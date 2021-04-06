package org.jesperancinha.algorithms.data

data class PyramidElement(
    val positions: IntArray,
    val connections: MutableList<PyramidElement> = mutableListOf()
) {
    override fun toString(): String {
        return positions.contentToString() + " => " + connections.map { it.positions.contentToString() }
    }
}
