package org.jesperancinha.algorithms.bfs.model

data class Station(
    val name: String,
    val linkedStations: MutableList<Station> = mutableListOf()
) {
    override fun toString(): String {
        return name + "(" + linkedStations.size + ")\n";
    }
}
