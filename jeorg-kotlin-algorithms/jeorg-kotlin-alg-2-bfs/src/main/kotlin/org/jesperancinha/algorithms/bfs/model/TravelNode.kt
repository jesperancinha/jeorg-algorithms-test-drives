package org.jesperancinha.algorithms.bfs.model

data class TravelNode(
    val name: String,
    val key: String,
    var back: TravelNode? = null,
    val linkedStations: MutableList<TravelNode> = mutableListOf()
) {
    override fun toString(): String {
        return name;
    }
}
