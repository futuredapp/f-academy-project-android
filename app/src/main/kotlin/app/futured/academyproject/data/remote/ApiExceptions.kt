package app.futured.academyproject.data.remote

sealed class ApiException(message: String, cause: Throwable?) : Exception(message, cause) {
    companion object {
        const val BAD_REQUEST = 400
        const val UNAUTHORIZED = 401
        const val FORBIDDEN = 403
        const val SERVER_ERROR = 500
    }
}

class ApiExceptionParseError(message: String, cause: Throwable?) :
    ApiException(message, cause)

class ApiExceptionConnectionError(message: String, cause: Throwable?) :
    ApiException(message, cause)

class ApiExceptionUnAuthorized(message: String, cause: Throwable?) :
    ApiException(message, cause)

class ApiExceptionForbidden(message: String, cause: Throwable?) :
    ApiException(message, cause)

class ApiExceptionUnknown(message: String, cause: Throwable?) : ApiException(message, cause)
class ApiExceptionBadRequest(message: String, cause: Throwable?) :
    ApiException(message, cause)
