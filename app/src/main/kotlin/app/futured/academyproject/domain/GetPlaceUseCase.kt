package app.futured.academyproject.domain

import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.data.store.PlacesStore
import app.futured.arkitekt.crusecases.UseCase
import javax.inject.Inject

class GetPlaceUseCase @Inject constructor(
    private val placesStore: PlacesStore,
) : UseCase<GetPlaceUseCase.Args, Place>() {

    override suspend fun build(args: Args): Place =
        placesStore.getPlace(args.placeId) ?: throw IllegalArgumentException("Place with id ${args.placeId} not found")

    data class Args(val placeId: Int)
}
