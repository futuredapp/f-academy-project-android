package app.futured.academyproject.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("/")
    suspend fun culturalPlaces(): List<String>
}
