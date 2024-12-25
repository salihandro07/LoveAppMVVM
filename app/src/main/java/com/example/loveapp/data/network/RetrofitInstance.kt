package com.example.loveapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

     val api = retrofit.create(ApiService::class.java)
}