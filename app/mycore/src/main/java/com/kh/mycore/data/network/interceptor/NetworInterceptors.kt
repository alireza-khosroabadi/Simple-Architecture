package com.kh.mycore.data.network.interceptor

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Status
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener

internal const val AUTHORIZATION_TOKEN_NAME = "X-AUTH-TOKEN"
internal const val HEADER_KEY_DISTRIBUTION = "distribute"
internal const val DISTRIBUTION_HAMRAH_SANDOUGH = "HamrahSandough"
internal val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()

internal val REQUEST_HEADER_INTERCEPTOR = Interceptor { chain ->


    val original = chain.request()
    val authToken =
        /*AccountManager.getInstance().getAuthToken() != null ? AccountManager.getInstance().getAuthToken() :*/
        "";

    val requestBuilder = original.newBuilder().method(original.method, original.body)
    requestBuilder.addHeader(AUTHORIZATION_TOKEN_NAME, authToken);
    requestBuilder.addHeader(
        HEADER_KEY_DISTRIBUTION,
        DISTRIBUTION_HAMRAH_SANDOUGH
    );

    chain.proceed(requestBuilder.build())
}

internal val RESPONSE_BODY_INTERCEPTOR = Interceptor { chain ->
    val wrappedResponseJson = JSONObject()
    val orginal = chain.request()
    val response = chain.proceed(orginal)
    val body = response.body;
    var bodyString:String? = body.toString()

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

    response.newBuilder()
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