package app.futured.academyproject.data.persistence

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesPersistence @Inject constructor(
    private val persistence: Persistence,
) {
    companion object {
        private const val PLACE_IDS_KEY = "PLACE_IDS_KEY"
    }

    private val placeIdsFlow: MutableStateFlow<List<Int>> = MutableStateFlow(
        persistence.getOrNull(PLACE_IDS_KEY) ?: emptyList()
    )

    fun observePlaceIds(): Flow<List<Int>> = placeIdsFlow.asStateFlow()

    fun getPlaceIds(): List<Int> = persistence.getOrNull(PLACE_IDS_KEY) ?: emptyList()

    fun setPlaceIds(placeIds: List<Int>) {
        persistence[PLACE_IDS_KEY] = placeIds
        placeIdsFlow.value = placeIds
    }

    fun addPlaceId(placeId: Int): Boolean {
        val savedTileIds = getPlaceIds().toMutableList()

        return if (placeId in savedTileIds) {
            false
        } else {
            setPlaceIds(savedTileIds.apply { add(placeId) })
            true
        }
    }

    fun removePlaceId(placeId: Int): Boolean {
        val savedTileIds = getPlaceIds().toMutableList()

        return if (placeId !in savedTileIds) {
            false
        } else {
            setPlaceIds(savedTileIds.apply { remove(placeId) })
            true
        }
    }
}
