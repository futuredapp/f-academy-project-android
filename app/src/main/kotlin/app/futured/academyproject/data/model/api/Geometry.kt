package app.futured.academyproject.data.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geometry(
    @SerialName("type") val type: String,
    @SerialName("coordinates") val coordinates: List<Double>,
)
