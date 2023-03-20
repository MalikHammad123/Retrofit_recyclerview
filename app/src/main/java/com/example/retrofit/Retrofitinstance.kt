package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {
    private val retrofit by lazy{
    Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val apiInterface by lazy {
        retrofit.create(Apiinterface::class.java)
    }

}