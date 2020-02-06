package com.example.pickeat

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ZomatoService {
    @Headers("user-key: 07b55827488dbb7db15464b3ca37588d")
    @GET("search?")
    fun getRestaurantsBySearch(@Query("q") type:String): Call<ZomatoResponse>

    //, @Query("lat") latitude:String, @Query("lon") longitude:String

}