package com.hamitest.shop.data.mapper

import com.hamitest.shop.data.model.Error
import java.lang.NullPointerException
import javax.inject.Inject

class ErrorMapper @Inject constructor(private val httpErrorMapper: HttpErrorMapper) {

    fun getError(t: Throwable): Error {
        if (t is NullPointerException) {
            return Error.Null
        }

        val httpError = httpErrorMapper.mapToErrorModel(t)
        if (httpError != null) {
            return httpError
        }

        return Error.NotDefined(t)
    }

}