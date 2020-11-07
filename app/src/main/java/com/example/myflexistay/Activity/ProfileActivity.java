package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myflexistay.R;

public class ProfileActivity extends AppCompatActivity {

    Button btn1;
    ApiClient apiClient;
    TextView myListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        apiClient = new ApiClient();
        getProfile();

        myListing = findViewById(R.id.Pro1);

        myListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMylisting = new Intent(ProfileActivity.this, MyListing_Activity.class);
                startActivity(intentMylisting);
            }
        });
    }

    private void getProfile() {

        JsonObject data = new JsonObject();

        String token = "gmxguQrLozCrAZ45tSD0vAce2eK7OQc6Q11k1LG1QVnzeUo4syOflqU9ocr48Nix";

        try {
            data.addProperty("token", token);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.LoginMethodPost(data).enqueue(new Callback<JsonObject>() {
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