package com.hamitest.shop.data.repository

import arrow.core.Either
import com.hamitest.shop.data.mapper.ErrorMapper
import com.hamitest.shop.data.model.Error
import kotlinx.coroutines.*

abstract class BaseRepository constructor(private val errorMapper: ErrorMapper) {

    protected suspend fun <T : Any> safeApiCall(call: suspend () -> T): Either<Error, T> {

        return withContext(Dispatchers.IO) {
            getResult(call)
        }
    }

    private suspend fun <T : Any> getResult(call: suspend () -> T): Either<Error, T> {
        return try {
            Either.right(call.invoke())
        } catch (t: Throwable) {
            Either.left(errorMapper.getError(t))
        }
    }

}