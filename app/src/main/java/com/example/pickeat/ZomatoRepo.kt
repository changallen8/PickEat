package com.example.pickeat

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ZomatoRepo{
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://developers.zomato.com/api/v2.1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val zomatoService = retrofit.create(ZomatoService::class.java)

    val latitude = "40.5478049261"
    val longitude = "-74.4408550205"

    fun getRestaurant(cuisine: String, callback: (zomatoResponse: ZomatoResponse?) -> Unit){
        zomatoService.getRestaurantsBySearch(latitude, longitude,cuisine).enqueue(object : Callback<ZomatoResponse> {
            override fun onFailure(call: Call<ZomatoResponse>, t: Throwable){

                callback(null)
            }
            override fun onResponse(call: Call<ZomatoResponse>, response: Response<ZomatoResponse>) {
                callback(response.body())
            }
        })
    }
}