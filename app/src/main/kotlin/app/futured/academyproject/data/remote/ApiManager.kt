@file:Suppress("UnusedPrivateMember")

package app.futured.academyproject.data.remote

import app.futured.academyproject.data.model.api.CulturalPlaces
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManager @Inject constructor(
    private val apiService: ApiService,
) {

    // TODO Krok 2:
    //  Zavolaj implementovanú metódu z ApiService a správne spracuj response. Mysli na spracovanie erroru a v prípade chyby vráť
    //  ApiExceptionUnknown. Ako bonus môžeš skúsiť spracova5 rôzne typy errorov. Pre inšpiráciu sa pozri na triedu ApiException
    suspend fun getCulturalPlaces(): CulturalPlaces = TODO("I'll be back... to check your code.")

}
