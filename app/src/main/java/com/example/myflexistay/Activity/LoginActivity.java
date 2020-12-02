package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.CountryModel;
import com.example.myflexistay.Model.LoginModel;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends AppCompatActivity {


    TextView txt_Register;
    EditText mobile, password;
    Button btn1;
    ApiClient apiClient = new ApiClient();
    CountryModel countryModel;
    ImageView flexi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        flexi = findViewById(R.id.img_flexi);
        Glide.with(this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Other+Icons-21.png")
                .into(flexi);

        password = findViewById(R.id.edt_password);
        password.addTextChangedListener(new EditTextListener());




        apiClient.apiInterface.getAllContries().enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                if (response.isSuccessful()){
                    Log.d("Message", "onResponse: " + response);
                    countryModel = response.body();
                }
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }

        });

        txt_Register = findViewById(R.id.txt_register);
        mobile = findViewById(R.id.edt_mobile);
        password = findViewById(R.id.edt_password);
        btn1 = findViewById(R.id.btn1);

        txt_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        Login();

    }


    private void Login() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mob = mobile.getText().toString();
                String pass = password.getText().toString();

                int valid = 1;


                if (mob.isEmpty() || mob.length() < 10) {
                    mobile.setError("Enter Mobile number");
                    mobile.requestFocus();
                    valid = 0;
                }

                if (pass.isEmpty()) {
                    password.setError("Enter Password ");
                    password.requestFocus();
                    valid = 0;
                }

                if (valid == 1){

                    getSaltDetails();
                }
            }
        });
    }

    private void getSaltDetails() {
        JsonObject data = new JsonObject();

        int Country = countryModel.getCountry().getId();
        String Mobile = "9844675900";

        try {
            data.addProperty("country_id", Country);
            data.addProperty("mobile",Mobile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.SaltMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("TAG", "onResponse: " + response);

                getLoginDetails();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }

    private void getLoginDetails() {

        JsonObject data = new JsonObject();

        int lCountry = 1;
        String lUsername = "9606349900";   //edt1.getText().toString();
        String lPassword = "100000:711c845245d5563ba577d574993bc7be:7458b5e51b09a9d76fa3776999e0" +
                "10fe38e633fc732bd5c0e83b6ea1fb082a99f351d44162861bcd77cca40072f40d3c5421498ade9068ea0fe88b44e60d6e96";   //edt2.getText().toString();


        try {
            data.addProperty("country_id", lCountry);
            data.addProperty("mobile", lUsername);
            data.addProperty("password", lPassword);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.LoginMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Network Problem !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class EditTextListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {



            if (password.getText().length() < 3 ) {
                ColorStateList colorStateList = ColorStateList.valueOf(Color.RED);
                password.setBackgroundTintList(colorStateList);
            } else if(password.getText().length() < 6 ) {
                ColorStateList colorStateList = ColorStateList.valueOf(Color.YELLOW);
                password.setBackgroundTintList(colorStateList);
            }else if (password.getText().length() < 9){
                ColorStateList colorStateList = ColorStateList.valueOf(Color.GREEN);
                password.setBackgroundTintList(colorStateList);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

//            if (!TextUtils.isEmpty(s)) {
//                String text = s.toString();
//                if(text.contains("(") || text.contains(")")) {
//                    password.setTextColor(Color.RED);
//                } else {
//                    password.setTextColor(Color.BLACK);
//                }
//            }
        }
    }

}