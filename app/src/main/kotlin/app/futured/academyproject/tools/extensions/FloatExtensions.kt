package app.futured.academyproject.tools.extensions


fun Float.formatMetersToDistanceString(): String = if (this < 1000) {
    String.format("%.0f m", this)
} else {
    String.format("%.1f km", this / 1000)
}