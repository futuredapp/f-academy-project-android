package app.futured.academyproject.data.store

import app.futured.academyproject.data.model.local.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesStore @Inject constructor() {

    private val places = MutableStateFlow<List<Place>?>(null)

    suspend fun setPlaces(places: List<Place>) {
        this.places.emit(places)
    }

    fun getPlaces() = places.value

    fun getPlacesFlow() = places.asStateFlow()

    fun getPlace(placeId: Int) = places.value?.find { it.id == placeId }

    suspend fun clear() {
        places.emit(null)
    }
}
