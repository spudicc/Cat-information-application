package com.example.marinaspudic_iazmu.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_URL = "https://api.api-ninjas.com/v1/"

interface CatApi {
    @GET("cats?name=abyssinian")
    //fun fetchItems(@Query("name") name : String) : Call<List<CatItem>>
    fun fetchItems() : Call<List<CatItem>>
}