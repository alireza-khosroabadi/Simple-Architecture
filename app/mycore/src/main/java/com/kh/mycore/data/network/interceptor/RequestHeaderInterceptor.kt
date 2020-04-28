package com.kh.mycore.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class RequestHeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val authToken =
            /*AccountManager.getInstance().getAuthToken() != null ? AccountManager.getInstance().getAuthToken() :*/
            "";

        val requestBuilder = original.newBuilder().method(original.method, original.body)
        requestBuilder.addHeader(AUTHORIZATION_TOKEN_NAME, authToken);
        requestBuilder.addHeader("device-type", "2");
        requestBuilder.addHeader(
            HEADER_KEY_DISTRIBUTION,
            DISTRIBUTION_HAMRAH_SANDOUGH
        );

      return  chain.proceed(requestBuilder.build())
    }
}