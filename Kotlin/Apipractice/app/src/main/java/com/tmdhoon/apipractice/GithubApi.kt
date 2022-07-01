package com.tmdhoon.apipractice

import com.tmdhoon.apipractice.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {                           // github 인터페이스

    @GET("users/Tmdhoon2")
    fun getGithubInfo(): Call<UserResponse>

}