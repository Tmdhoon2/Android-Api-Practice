package com.example.movieapi

import android.text.Editable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("?t={title}")
    fun getMovie(
        @Path("title")
        title : Editable) : Call<Movie>

}