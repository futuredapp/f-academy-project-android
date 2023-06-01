package app.futured.academyproject.domain

import app.futured.academyproject.data.model.CulturalPlaces
import app.futured.academyproject.data.remote.ApiManager
import app.futured.arkitekt.crusecases.UseCase
import javax.inject.Inject

class GetCulturalPlacesUseCase @Inject constructor(
    private val apiManager: ApiManager
) : UseCase<Unit, CulturalPlaces>() {
    override suspend fun build(args: Unit): CulturalPlaces {
        return apiManager.getCulturalPlaces()
    }
}
