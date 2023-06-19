package app.futured.academyproject.data.remote

import android.content.Context
import androidx.annotation.StringRes
import app.futured.academyproject.R
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

@Suppress("ThrowsCount")
abstract class ApiExecutor(private val context: Context, private val json: Json) {

    suspend fun <T> executeApiCall(apiCall: suspend () -> Response<T>): T {
        try {
            return apiCall().processResponse()
        } catch (e: ApiException) {
            throw e
        } catch (e: SerializationException) {
            Timber.w(e)
            throw ApiExceptionParseError(
                getString(R.string.error_parse), e,
            )
        } catch (e: NullPointerException) {
            throw e
        } catch (e: UnknownHostException) {
            Timber.w(e)
            throw ApiExceptionConnectionError(
                getString(R.string.error_connection), e,
            )
        } catch (e: CancellationException) {
            throw e // This is normal way of cancelling coroutines, throw as-is, so CoroutineScopeOwner can properly handle it
        } catch (e: Exception) {
            Timber.w(e)
            throw ApiExceptionUnknown(
                getString(R.string.error_general_server_error), e,
            )
        }
    }

    @Suppress("SwallowedException")
    suspend fun <T> executeNullableApiCall(
        apiCall: suspend () -> Response<T>,
    ): T? =
        try {
            executeApiCall(apiCall)
        } catch (e: NullPointerException) {
            null
        }

    @Suppress("UnsafeCallOnNullableType")
    private fun <T> Response<T>.processResponse(): T {
        if (isSuccessful) {
            return this.body()!!
        } else {
            parseError(this)
        }
    }

    private fun <T> parseError(response: Response<T>): Nothing {
        when (response.code()) {
            // This could by used when API requires authorization, it's not our case
            ApiException.UNAUTHORIZED -> throw ApiExceptionUnAuthorized(
                getString(R.string.error_unauthorized),
                null,
            )
            ApiException.SERVER_ERROR -> throw ApiExceptionUnknown(
                getString(R.string.error_general_server_error),
                null,
            )
            else -> throw ApiExceptionUnknown(
                getString(R.string.error_general_server_error),
                null,
            )
        }
    }

    private fun getString(@StringRes id: Int): String = context.getString(id)
}
