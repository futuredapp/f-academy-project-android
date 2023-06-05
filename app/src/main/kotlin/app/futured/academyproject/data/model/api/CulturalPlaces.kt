package app.futured.academyproject.data.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CulturalPlaces(
    @SerialName("type") val type: String,
    @SerialName("features") val features: List<Feature>,
)
