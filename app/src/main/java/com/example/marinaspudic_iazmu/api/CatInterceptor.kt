package com.example.marinaspudic_iazmu.api

import okhttp3.Interceptor
import okhttp3.Response

class CatInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Api-Key", "K3c/s1rH/CCumJjv6aVwJw==P4bpHsN91Lii3WX1")
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }

}