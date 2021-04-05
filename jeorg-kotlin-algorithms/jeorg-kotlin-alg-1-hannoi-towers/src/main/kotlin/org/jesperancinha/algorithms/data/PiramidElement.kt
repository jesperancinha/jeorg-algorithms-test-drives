package org.jesperancinha.algorithms.data

data class PiramidElement(
    val positions: IntArray,
    val up: PiramidElement?,
    val left: PiramidElement?,
    val right: PiramidElement?,
    var lowLeft: PiramidElement?,
    val lowRight: PiramidElement?
) {
    constructor(positions: IntArray) : this(positions, null, null, null, null, null)
}
