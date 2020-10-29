package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.LoginModel;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.net.URLEncoder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends AppCompatActivity {


    TextView txt7;
    EditText edt1, edt2;
    Button btn1;
    ApiClient apiClient = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txt7 = findViewById(R.id.txt7);


        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        btn1 = findViewById(R.id.btn1);
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        Login();

    }

    private void Login(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject data = new JsonObject();

                int lCountry = 1;
                String lUsername ="9606349900";   //edt1.getText().toString();
                String lPassword = "100000:711c845245d5563ba577d574993bc7be:7458b5e51b09a9d76fa3776999e0" +
                        "10fe38e633fc732bd5c0e83b6ea1fb082a99f351d44162861bcd77cca40072f40d3c5421498ade9068ea0fe88b44e60d6e96";   //edt2.getText().toString();
//
//

                try {
                    data.addProperty("country_id", lCountry);
                    data.addProperty("mobile",lUsername);
                    data.addProperty("password", lPassword);

                } catch (JsonIOException e) {
                    e.printStackTrace();
                }


                // Call<ResponseBody> call = apiClient.apiInterface.loginUser(lCountry,lUsername,lPassword)

                apiClient.apiInterface.LoginMethodPost(data).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            Toast.makeText(LoginActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
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
        });

    }

}