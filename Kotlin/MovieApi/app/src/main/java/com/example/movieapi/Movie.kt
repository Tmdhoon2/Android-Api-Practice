package com.example.movieapi

import android.text.Editable

data class Movie(
    val Country: String,
    val Runtime: String,
    val Title: Editable,
    val Year: String
)