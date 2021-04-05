package org.jesperancinha.algorithms.data

data class PiramidElement(
    val positions:Char,
    val left: PiramidElement?,
    val right: PiramidElement?
)
