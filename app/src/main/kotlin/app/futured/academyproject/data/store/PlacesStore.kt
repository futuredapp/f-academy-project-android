package app.futured.academyproject.data.store

import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.tools.preview.PlacesProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesStore @Inject constructor() {

    //TODO: Mock data for lectures before: "API and data"
    private val places = MutableStateFlow<List<Place>?>(PlacesProvider().values.first())

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
