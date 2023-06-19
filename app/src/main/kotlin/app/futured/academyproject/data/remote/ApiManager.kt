@file:Suppress("UnusedPrivateMember")

package app.futured.academyproject.data.remote

import android.content.Context
import app.futured.academyproject.data.model.api.CulturalPlaces
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManager @Inject constructor(
    @ApplicationContext context: Context,
    json: Json,
    private val apiService: ApiService,
) : ApiExecutor(context, json) {

    suspend fun getCulturalPlaces(): CulturalPlaces = executeApiCall { apiService.getCulturalPlaces() }
}
