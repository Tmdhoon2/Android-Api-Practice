package com.example.movieapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com/?apikey=72262f39&")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val MovieApi = retrofit.create(MovieApi::class.java)
}