package app.futured.academyproject.data.store

import app.futured.academyproject.data.model.api.CulturalPlaces
import app.futured.academyproject.data.remote.ApiManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesStore @Inject constructor(
    private val apiManager: ApiManager,
) {
    private val places = MutableStateFlow<CulturalPlaces?>(null)

    fun getPlacesFlow(): Flow<CulturalPlaces> = places.asStateFlow().onStart {
        places.value = apiManager.getCulturalPlaces()
    }.filterNotNull()

    fun getPlace(placeId: Int) = places.value?.features?.find { it.properties.ogcFid == placeId }
}
