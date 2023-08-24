package app.futured.academyproject.domain

import app.futured.academyproject.data.model.api.mapToPlace
import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.data.persistence.PlacesPersistence
import app.futured.academyproject.data.store.PlacesStore
import app.futured.arkitekt.crusecases.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetPlacesFlowUseCase @Inject constructor(
    private val placesPersistence: PlacesPersistence,
    private val placesStore: PlacesStore,
) : FlowUseCase<Unit, List<Place>>() {

    override fun build(args: Unit): Flow<List<Place>> = combine(
        placesPersistence.observePlaceIds(),
        placesStore.getPlacesFlow()
    ) { favouritePlaceIds, culturePlaces ->
        culturePlaces.features.map {
            val isFavoritePlace = it.properties.ogcFid in favouritePlaceIds
            it.mapToPlace(isFavoritePlace)
        }
    }
}
