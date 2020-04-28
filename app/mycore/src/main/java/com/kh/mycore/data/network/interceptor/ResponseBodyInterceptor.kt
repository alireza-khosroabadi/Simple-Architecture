package com.kh.mycore.data.network.interceptor

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Status
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener

internal class ResponseBodyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val wrappedResponseJson = JSONObject()
        //val orginal = chain.request()
        val response = chain.proceed(chain.request())
        val body = response.body;
        var bodyString:String? = body?.string()

        try {
            if (response.isSuccessful) {
                wrappedResponseJson.put(
                    BaseResponse.AttrStatus,
                    Status.SUCCESS
                )
                bodyString?.let {
                    generateWrappedResponseJson(
                        wrappedResponseJson,
                        it,
                        BaseResponse.AttrData
                    )
                }
            } else {
                wrappedResponseJson.put(
                    BaseResponse.AttrStatus,
                    Status.REST_ERROR
                )
                bodyString?.let {
                    generateWrappedResponseJson(
                        wrappedResponseJson,
                        it,
                        BaseResponse.AttrRestError
                    )
                }

            }
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }

       return response.newBuilder()
            .code(200)
            .body(wrappedResponseJson.toString().toResponseBody(JSON))
            .build()
    }


    private fun generateWrappedResponseJson(
        wrappedResponseJson: JSONObject,
        data: String,
        key: String
    ) {
        var json: Any = JSONTokener(data).nextValue()
        when (json) {
            is JSONObject -> wrappedResponseJson.put(key, JSONObject(data))
            is JSONArray -> wrappedResponseJson.put(key, JSONArray(data))
            else -> wrappedResponseJson.put(key, data)
        }
    }
}