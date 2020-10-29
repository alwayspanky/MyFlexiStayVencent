package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Activity.LoginActivity;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity1 extends AppCompatActivity {

    private ImageView image;
    Button btn1;
    private EditText phone;

    ApiClient apiClient = new ApiClient();
    RadioButton otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        image = findViewById(R.id.img6);

        Glide.with(RegisterActivity1.this)
                .load("https://myflexistay-dev-images.s3.ap-south-1.amazonaws.com/Images-13.jpg")
                .into(image);


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateOtp();
            }
        });

        phone = findViewById(R.id.edt_mobile);
        otp = findViewById(R.id.genarate_otp);
        sendOtp();

    }



    private void sendOtp() {

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject data = new JsonObject();

//                int sCountry = 1;
//                String sMobile = phone.getText().toString().trim();

                try {
                    data.addProperty("country_id",1);
                    data.addProperty("mobile", "9606349900");

                } catch (JsonIOException e) {
                    e.printStackTrace();
                }

                apiClient.apiInterface.sendOtpMethodPost(data).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(RegisterActivity1.this,response.message(),Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegisterActivity1.this, "Something went wrong !", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(RegisterActivity1.this, "Network Problem !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void validateOtp() {
        JsonObject data = new JsonObject();

        int vCountry = 1;
        String vMobile = phone.getText().toString().trim();
        String vOtp = "174730";

        try {
            data.addProperty("country_id", 1);
            data.addProperty("mobile",vMobile );
            data.addProperty("otp", vOtp);


        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.validateMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity1.this,response.toString(),Toast.LENGTH_SHORT).show();
                    Register();
                } else {
                    Toast.makeText(RegisterActivity1.this, "Something went wrong !", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(RegisterActivity1.this, "Network Problem !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Register() {

        JsonObject data = new JsonObject();


        String rFname = getIntent().getStringExtra("firstName");
        String rLname = getIntent().getStringExtra("lastName");
        String rEmail = getIntent().getStringExtra("email");
        String rPassword = getIntent().getStringExtra("password");
        String rReff = getIntent().getStringExtra("reference");



        try {
            data.addProperty("user_type_id", 4);
            data.addProperty("first_name", "Shankar");
            data.addProperty("last_name", "Andanappa");
            data.addProperty("country_id", 1);
            data.addProperty("mobile", "9844675900");
            data.addProperty("email", "shankar.andanappa@gmail.com");
            data.addProperty("password", "100000:711c845245d5563ba577d574993bc7be:7458b5e51b09a9d76fa3776999e010fe38e633fc732bd5c0e83b6ea1fb082a99f351d44162861bcd77cca40072f40d3c5421498ade9068ea0fe88b44e60d6e96");

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.RegisterMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(RegisterActivity1.this,response.toString(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                } else {
                    Toast.makeText(RegisterActivity1.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(RegisterActivity1.this, "Network Problem !", Toast.LENGTH_SHORT).show();
            }
        });
    }


}