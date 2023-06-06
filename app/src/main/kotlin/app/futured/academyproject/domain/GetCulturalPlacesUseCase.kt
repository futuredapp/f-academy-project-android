package app.futured.academyproject.domain

import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.data.remote.ApiManager
import app.futured.academyproject.data.store.PlacesStore
import app.futured.arkitekt.crusecases.UseCase
import javax.inject.Inject

class GetCulturalPlacesUseCase @Inject constructor(
    private val placesStore: PlacesStore,
    private val apiManager: ApiManager,
) : UseCase<Unit, List<Place>>() {

    override suspend fun build(args: Unit): List<Place> =
        apiManager.getCulturalPlaces().features.map {
            Place(
                id = it.properties.ogcFid,
                name = it.properties.name,
                type = it.properties.type,
                note = it.properties.note,
                longitude = it.geometry?.coordinates?.getOrNull(0),
                latitude = it.geometry?.coordinates?.getOrNull(1),
                webUrl = it.properties.webUrl,
                program = it.properties.program,
                street = it.properties.street,
                streetNumber = it.properties.streetNumber,
                email = it.properties.email,
                phone = it.properties.phone,
                nameEN = it.properties.nameEN,
                noteEN = it.properties.noteEN,
                accessibilityId = it.properties.accessibilityId,
                openFrom = it.properties.openFrom,
                openTo = it.properties.openTo,
                image1Url = it.properties.image1Url,
            )
        }.also {
            placesStore.setPlaces(it)
        }
}
