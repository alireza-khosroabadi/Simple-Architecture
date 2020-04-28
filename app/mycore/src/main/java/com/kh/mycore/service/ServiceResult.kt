package com.kh.mycore.service

import com.kh.mycore.data.network.entities.error.RestError

/**
 * A wrapper for database and network states.
 */
sealed class ServiceResult<T> {

    /**
     * A state of [data] which shows that we know there is still an update to come.
     */
    data class Loading<T>(val data: T?) : ServiceResult<T>()

    /**
     * A state that shows the [data] is the last known update.
     */
    data class Success<T>(val data: T) : ServiceResult<T>()

    /**
     * A state to show a [throwable] is thrown .
     */
    data class Error<T>(val throwable: Throwable) : ServiceResult<T>()


    data class ServerError<T>(val restError: RestError?): ServiceResult<T>()
}