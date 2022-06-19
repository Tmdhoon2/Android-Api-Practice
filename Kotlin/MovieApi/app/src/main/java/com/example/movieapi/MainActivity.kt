package com.example.movieapi

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import com.example.movieapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var title : Editable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = binding.etInput.getText()

        binding.btSearch.setOnClickListener {  RetrofitBuilder.MovieApi.getMovie(title).enqueue(object : Callback<Movie>{

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful){
                    val movieInfo = response.body()

                    binding.Title.text = movieInfo!!.Title
                    binding.Year.text = movieInfo!!.Year
                    binding.Runtime.text = movieInfo!!.Runtime
                    binding.Country.text = movieInfo!!.Country
                }else{
                    Toast.makeText(this@MainActivity, "Error!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(this@MainActivity, "통신실패", Toast.LENGTH_SHORT).show()
            }
        }) }


    }
}