package com.example.bottomnavigationapi.data.remote.interseptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey", "5e4381e1018849f284c8038bff3a232a").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}