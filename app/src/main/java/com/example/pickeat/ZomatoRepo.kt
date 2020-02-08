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

    //val latitude = "40.52484935"
    //val longitude = "-74.45883301204988"
    //,latitude, longitude

    fun getRestaurant(type: String, callback: (zomatoResponse: ZomatoResponse?) -> Unit){
        zomatoService.getRestaurantsBySearch(type,"rating").enqueue(object : Callback<ZomatoResponse> {
            override fun onFailure(call: Call<ZomatoResponse>, t: Throwable){

                callback(null)
            }
            override fun onResponse(call: Call<ZomatoResponse>, response: Response<ZomatoResponse>) {
                callback(response.body())
            }
        })
    }
}