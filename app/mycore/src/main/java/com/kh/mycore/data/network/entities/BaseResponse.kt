package com.kh.mycore.data.network.entities

import com.google.gson.annotations.SerializedName
import com.kh.mycore.data.network.entities.error.RestError

class BaseResponse<T>(
    @SerializedName("status") val status: Status,
    @SerializedName("data") var data: T?=null,
    @SerializedName("message") var message: String?=null,
    @SerializedName("restError") var restError: RestError?=null,
    @SerializedName("throwable")  var throwable: Throwable?=null
) {
    companion object DataWrapperAttrs {
        const val AttrStatus = "status"
        const val AttrData = "data"
        const val AttrRestError = "restError"

        fun <T> success(data: T): BaseResponse<T>? {
            return BaseResponse<T>(
                Status.SUCCESS,
                data
            )
        }

        fun <T> networkError(error: Throwable?): BaseResponse<T>? {
            return BaseResponse<T>(
                status = Status.NETWORK_ERROR,
                throwable = error
            )
        }

        fun <T> networkError(
            data: T,
            error: Throwable?
        ): BaseResponse<T>? {
            return BaseResponse<T>(
               status =  Status.NETWORK_ERROR,
               data =  data,
               throwable =  error
            )
        }

        fun <T> restError(restError: RestError?): BaseResponse<T>? {
            return BaseResponse<T>(
                status = Status.REST_ERROR,
                restError = restError
            )
        }

    }



}




enum class Status {
    SUCCESS,
    NETWORK_ERROR,
    REST_ERROR;
}