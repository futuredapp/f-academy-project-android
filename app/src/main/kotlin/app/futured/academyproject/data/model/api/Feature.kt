package app.futured.academyproject.data.model.api

import android.location.Location
import app.futured.academyproject.data.model.local.Place
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feature(
    @SerialName("id") val id: String? = null,
    @SerialName("type") val type: String,
    @SerialName("geometry") val geometry: Geometry? = null,
    @SerialName("properties") val properties: Properties,
)

fun Feature.mapToPlace(isFavourite: Boolean, location: Location? = null) = Place(
    id = properties.ogcFid,
    isFavourite = isFavourite,
    name = properties.name,
    type = properties.type,
    note = properties.note,
    longitude = geometry?.coordinates?.getOrNull(0),
    latitude = geometry?.coordinates?.getOrNull(1),
    // Bonus properties
    webUrl = properties.webUrl,
    program = properties.program,
    street = properties.street,
    streetNumber = properties.streetNumber,
    email = properties.email,
    phone = properties.phone,
    nameEN = properties.nameEN,
    noteEN = properties.noteEN,
    accessibilityId = properties.accessibilityId,
    openFrom = properties.openFrom,
    openTo = properties.openTo,
    image1Url = properties.image1Url,
    distance = location?.let {
        val results = FloatArray(1)
        Location.distanceBetween(
            it.latitude,
            it.longitude,
            geometry?.coordinates?.getOrNull(1) ?: 0.0,
            geometry?.coordinates?.getOrNull(0) ?: 0.0,
            results,
        )
        results[0]
    },
)
