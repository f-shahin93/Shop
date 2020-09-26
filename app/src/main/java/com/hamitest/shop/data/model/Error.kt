package com.hamitest.shop.data.model

sealed class Error {

    object Null : Error()
    data class NotDefined(val throwable: Throwable) : Error()

}

sealed class HttpError : Error() {

    object ConnectionFailed : HttpError()

    data class InvalidResponse(val code: Int, val message: String?) : HttpError()

    object TimeOut : HttpError()

    object UnAuthorized : HttpError()
}