package com.example.ageapipractice;

import android.text.Editable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GetAPI {
    @GET("/coins/{coin_id}")
    Call<GetResponse> getGET(
            @Path("coin_id") Editable coinid
    );

}
