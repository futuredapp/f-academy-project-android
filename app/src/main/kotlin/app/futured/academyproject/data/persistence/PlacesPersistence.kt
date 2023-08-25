package app.futured.academyproject.data.persistence

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesPersistence @Inject constructor(
    private val persistence: Persistence,
) {
    companion object {
        private const val PLACE_IDS_KEY = "PLACE_IDS_KEY"
    }
    // TODO Step 3 - uncomment code
//    private val placeIdsFlow: MutableStateFlow<List<Int>> = MutableStateFlow(
//        persistence.getOrNull(PLACE_IDS_KEY) ?: emptyList()
//    )

    // TODO Step 4 - replace "flow { emit(emptyList()) }" with "placeIdsFlow.asStateFlow()"
    fun observePlaceIds(): Flow<List<Int>> = flow { emit(emptyList()) } //placeIdsFlow.asStateFlow()

//    fun getPlaceIds(): List<Int> = persistence.getOrNull(PLACE_IDS_KEY) ?: emptyList()

//    fun setPlaceIds(placeIds: List<Int>) {
//        persistence[PLACE_IDS_KEY] = placeIds
//        placeIdsFlow.value = placeIds
//    }

    // TODO Step 5 - create method/s to check if the place ID is already stored, if so, remove it, if not, add place id into list and save it
}
