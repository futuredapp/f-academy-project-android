package app.futured.academyproject.data.persistence

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class Persistence @Inject constructor(
    val json: Json,
    val sharedPreferences: SharedPreferences,
) {

    inline operator fun <reified T : Any> set(key: String, value: T) =
        sharedPreferences.edit { putString(key, json.encodeToString(serializer(), value)) }

    inline operator fun <reified T : Any> get(key: String): T =
        get(T::class, key, null)!!

    inline operator fun <reified T : Any> get(key: String, defaultValue: T): T =
        get(T::class, key, defaultValue)!!

    inline fun <reified T : Any> getOrNull(key: String): T? =
        get(T::class, key, null)

    fun delete(key: String) = sharedPreferences.edit {
        this.remove(key)
    }

    operator fun contains(key: String): Boolean = sharedPreferences.contains(key)

    fun clear() = sharedPreferences.edit { clear() }

    @Suppress("UNUSED_PARAMETER")
    inline fun <reified T : Any> get(clazz: KClass<T>, key: String, defaultValue: T? = null): T? {
        val persistedValue = sharedPreferences.getString(key, null)
        return if (persistedValue == null) {
            defaultValue
        } else {
            json.decodeFromString(serializer<T>(), persistedValue)
        }
    }
}
