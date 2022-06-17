package com.tmdhoon.postexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tmdhoon.postexample.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Editable postId;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        postId = binding.EditText.getText();

        PostAPI postAPI = ApiProvider.getRetrofit().create(PostAPI.class);

        binding.btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postAPI.getPost(postId).enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                        if(response.isSuccessful()){
                            binding.textView.setText(response.body().getContent());
                        }else{
                            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}