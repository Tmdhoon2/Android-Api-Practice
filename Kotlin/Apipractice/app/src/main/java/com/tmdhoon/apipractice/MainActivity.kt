package com.tmdhoon.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.tmdhoon.apipractice.databinding.ActivityMainBinding
import com.tmdhoon.apipractice.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        RetrofitBuilder.githubApi.getGithubInfo().enqueue(object : Callback<UserResponse> {

            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if(response.isSuccessful) {
                    val userInfo = response.body()

                    binding.tvFollowerCount.text = userInfo!!.followers.toString()
                    binding.tvFollowingCount.text = userInfo!!.following.toString()
                    binding.tvName.text = userInfo!!.login
                    binding.tvDescription.text = userInfo!!.bio

                    getImageURL(userInfo.avatar_url)
                }

            }

            fun getImageURL(imageURL: String){
                Glide.with(applicationContext)
                    .load(imageURL)
                    .into(binding.ivProfileImage)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }

        })


    }
}