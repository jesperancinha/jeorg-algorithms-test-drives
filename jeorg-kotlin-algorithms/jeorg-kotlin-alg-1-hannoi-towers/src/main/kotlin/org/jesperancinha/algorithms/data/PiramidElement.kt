package org.jesperancinha.algorithms.data

data class PiramidElement(
    val positions: IntArray,
    var up: PiramidElement?,
    var left: PiramidElement?,
    var right: PiramidElement?,
    var lowLeft: PiramidElement?,
    var lowRight: PiramidElement?
) {
    constructor(positions: IntArray) : this(positions, null, null, null, null, null)
}
