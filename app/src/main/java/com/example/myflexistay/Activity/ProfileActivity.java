package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myflexistay.R;

public class ProfileActivity extends AppCompatActivity {


    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        apiClient = new ApiClient();
        getProfile();
    }

    private void getProfile() {

        JsonObject data = new JsonObject();

        String token = "SLQdyA4ELQY0ddrDv4y7EKAOnlNUmUPXbGzgGN8AxF3EcA5OSZaoO26bc6lHMXVO";

        try {
            data.addProperty("token", token);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.profileMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(ProfileActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ProfileActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Network Problem !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}