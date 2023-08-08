package app.futured.academyproject.data.store

import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.tools.preview.PlacesProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesStore @Inject constructor() {

    // Mock data for lectures before: "API and data"
    private val places = MutableStateFlow<List<Place>>(PlacesProvider().values.first())

    suspend fun setPlaces(places: List<Place>) {
        this.places.emit(places)
    }

    fun getPlaces(): List<Place> = places.value

    fun getPlacesFlow(): Flow<List<Place>> = places.asStateFlow()

    fun getPlace(placeId: Int): Place? = places.value.find { it.id == placeId }

    suspend fun clear() {
        places.emit(emptyList())
    }
}
