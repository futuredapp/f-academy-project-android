package app.futured.academyproject.tools.extensions

/**
 * Map value from one range to another. Source range is specified by [oldMin] and [oldMax] parameters.
 * Target range is 0f..1f which is used for alpha value.
 */
fun Float.alphaFromRange(oldMin: Float, oldMax: Float): Float {
    val oldRange = oldMax - oldMin
    return ((this - oldMin) / oldRange).coerceIn(0f, 1f)
}
