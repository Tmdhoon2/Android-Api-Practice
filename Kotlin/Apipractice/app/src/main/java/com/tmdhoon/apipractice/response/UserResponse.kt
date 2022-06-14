package com.tmdhoon.apipractice.response

data class UserResponse(
    val avatar_url: String,
    val bio: String,
    val followers: Int,
    val following: Int,
    val login: String,
    val name: String
)