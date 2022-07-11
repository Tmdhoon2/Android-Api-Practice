package com.tmdhoon.postexample;

import android.text.Editable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface PostAPI {
    @GET("post/{post-id}")
    Call<PostResponse> getPost(
            @Path("post-id") Editable postId

    );
}
