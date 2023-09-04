package app.futured.academyproject.domain

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import app.futured.arkitekt.crusecases.UseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetLastLocationUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
) : UseCase<Unit, Location?>() {
    @SuppressLint("MissingPermission")
    override suspend fun build(args: Unit): Location? {
        // TODO 6. implement this use case
        // 1. get location manager from context
        // 2. get last known location from location manager
        // 3. return last known location
        return null
    }
}