package app.futured.academyproject.domain

import app.futured.academyproject.data.persistence.PlacesPersistence
import app.futured.arkitekt.crusecases.UseCase
import javax.inject.Inject

class SetFavoritePlaceUseCase @Inject constructor(
    private val persistence: PlacesPersistence,
): UseCase<SetFavoritePlaceUseCase.Args, Unit>() {

    override suspend fun build(args: Args) {
        if (!persistence.addPlaceId(args.placeId)) {
            persistence.removePlaceId(args.placeId)
        }
    }

    data class Args(val placeId: Int)
}
