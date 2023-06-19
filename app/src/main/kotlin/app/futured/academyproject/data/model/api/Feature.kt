package app.futured.academyproject.data.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feature(
    @SerialName("id") val id: String? = null,
    @SerialName("type") val type: String,
    @SerialName("geometry") val geometry: Geometry? = null,
    @SerialName("properties") val properties: Properties,
)

