package app.futured.academyproject.domain

import app.futured.academyproject.data.model.api.mapToPlace
import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.data.persistence.PlacesPersistence
import app.futured.academyproject.data.store.PlacesStore
import app.futured.arkitekt.crusecases.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPlaceFlowUseCase @Inject constructor(
    private val placesStore: PlacesStore,
    private val persistence: PlacesPersistence,
) : FlowUseCase<GetPlaceFlowUseCase.Args, Place>() {

    override fun build(args: Args): Flow<Place> = persistence.observePlaceIds().map { favouritePlaces ->
        val feature = placesStore.getPlace(args.placeId) ?: throw IllegalArgumentException("Place with id ${args.placeId} not found")
        feature.mapToPlace( feature.properties.ogcFid in favouritePlaces)
    }

    data class Args(val placeId: Int)
}
