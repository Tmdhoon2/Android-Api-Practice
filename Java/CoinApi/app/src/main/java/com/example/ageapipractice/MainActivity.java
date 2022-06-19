package com.example.ageapipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.example.ageapipractice.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Editable coinid;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        coinid = binding.editText.getText();

        GetAPI getAPI = ApiProvider.getRetrofit().create(GetAPI.class);

        binding.Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAPI.getGET(coinid).enqueue(new Callback<GetResponse>() {
                    @Override
                    public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                        if(response.isSuccessful()){
                            binding.Id.setText(response.body().getId());
                            binding.Name.setText(response.body().getName());
                            binding.Symbol.setText(response.body().getSymbol());
                            binding.Rank.setText(response.body().getRank());
                        }else{
                            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "통신 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}