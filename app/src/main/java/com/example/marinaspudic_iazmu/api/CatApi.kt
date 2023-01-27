package com.example.marinaspudic_iazmu.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_URL = "https://api.api-ninjas.com/v1/cats?/name=abyssinian"

interface CatApi {
    //@GET("a")
    @Headers("api-key: " + "K3c/s1rH/CCumJjv6aVwJw==P4bpHsN91Lii3WX1")
    fun fetchItems() : Call<List<CatItem>>
}