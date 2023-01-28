package com.example.marinaspudic_iazmu.api

import android.content.Context
import android.util.Log
import com.example.marinaspudic_iazmu.CatAppReceiver
import com.example.marinaspudic_iazmu.framework.sendBroadcast
import com.example.marinaspudic_iazmu.handler.downloadAndStoreImage
import com.example.marinaspudic_iazmu.model.Item
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatFetcher(private val context: Context) {
    private var catApi : CatApi
    private var client = OkHttpClient.Builder().apply { addInterceptor(CatInterceptor()) }.build()
    init {
        val retrofit = Retrofit.Builder().baseUrl(API_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        catApi = retrofit.create(CatApi::class.java)
    }

    fun fetchItems() {
        println("I made it to here")
        val request = catApi.fetchItems()

        request.enqueue(object: Callback<List<CatItem>>{
            override fun onResponse(call: Call<List<CatItem>>, response: Response<List<CatItem>>) {
                response?.body()?.let { populateItems(it) }
            }
            override fun onFailure(call: Call<List<CatItem>>, t: Throwable) {
                Log.e(javaClass.name, t.toString(), t)
                println("something isnt right")
            }
        })
    }

    private fun populateItems(catItems: List<CatItem>) {
        println(catItems)
        val items = mutableListOf<Item>()
        GlobalScope.launch {
        catItems.forEach{
            var picturePath = downloadAndStoreImage(context, it.image_link)
            items.add(Item(null, it.name, it.origin, picturePath?: "",it.max_life_expectancy, it.max_weight))
        }
        context.sendBroadcast<CatAppReceiver>()
        }
    }

}