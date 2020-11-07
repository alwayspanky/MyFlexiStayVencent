package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.CountryModel;
import com.example.myflexistay.Model.UserTypeModel;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btn1;
    private EditText fname, lname, mobile, pass, otp;
    private TextView sendOtp, otpTimer, validateOtp;
    ApiClient apiClient;
    CountryModel countryModel;
    List<UserTypeModel.TypesBean> userTypeModel;
    public int counter = 30;
    int vOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        fname = findViewById(R.id.edt1);
        lname = findViewById(R.id.edt2);
        mobile = findViewById(R.id.edt3);
        pass = findViewById(R.id.edt4);
        otp = findViewById(R.id.edt_otp);
        sendOtp = findViewById(R.id.txt_sendOtp);
        otpTimer = findViewById(R.id.otp_timer);
        validateOtp = findViewById(R.id.txt_validateOtp);
        btn1 = findViewById(R.id.btn1);


        apiClient = new ApiClient();


        ////Get All countries data
        getAllCountryDetails();

        /// Get UserType data
        userTypeModel = new ArrayList<>();
        getAllUserTypes();


        //// Send Otp button visibility
        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sendOtp.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOtpDetails();
            }
        });

        /////////////Send Otp button code

        /// ////validate otp details code

        validateOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateOtpDetails();
            }
        });

        otp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateOtp.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /// ////validate otp details code

        ///////////////Register button code
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName = fname.getText().toString();
                String lName = lname.getText().toString();
                String Mobile = mobile.getText().toString();
                String Otp = otp.getText().toString();
                String Pass = pass.getText().toString();


                int valid = 1;

                if (fName.isEmpty() || fName.length() < 5) {
                    fname.setError("Enter first name");
                    fname.requestFocus();
                    valid = 0;
                }

                if (lName.isEmpty() || lName.length() < 5) {
                    lname.setError("Enter last name");
                    lname.requestFocus();
                    valid = 0;
                }

                if (Mobile.isEmpty() || Mobile.length() < 10) {
                    mobile.setError("Enter mobile number ");
                    mobile.requestFocus();
                    valid = 0;
                }

                if (Otp.isEmpty() || Otp.length() < 6) {
                    otp.setError("Enter otp ");
                    otp.requestFocus();
                    valid = 0;
                }

                if (Pass.isEmpty() || Pass.length() < 6) {
                    pass.setError("Enter password ");
                    pass.requestFocus();
                    valid = 0;
                }

                if (valid==1){
                    registrationDetails();
                }

            }
        });

    }

    private void getAllUserTypes() {

        apiClient.apiInterface.getAllUserType().enqueue(new Callback<UserTypeModel>() {
            @Override
            public void onResponse(Call<UserTypeModel> call, Response<UserTypeModel> response) {
                if (response.isSuccessful()){

                    userTypeModel = (List<UserTypeModel.TypesBean>) response.body().getTypes();
                    Toast.makeText(RegisterActivity.this,response.body().toString(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this,"response error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserTypeModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Something went wrong!!",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getAllCountryDetails() {

        apiClient.apiInterface.getAllCountries().enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                if (response.isSuccessful()){

                    countryModel = response.body();
                    Toast.makeText(RegisterActivity.this,response.body().toString(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this,"response error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Something went wrong!!",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void sendOtpDetails() {

        JsonObject data = new JsonObject();

        int sCountry = countryModel.getCountry().getId();
        String sMobile = mobile.getText().toString().trim();

        try {
            data.addProperty("country_id",sCountry);
            data.addProperty("mobile", sMobile);

        }catch (JsonIOException e) {
            e.printStackTrace();
        }

            apiClient.apiInterface.sendOtpMethodPost(data).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.isSuccessful()){

                        Toast.makeText(RegisterActivity.this,response.body().toString(),Toast.LENGTH_LONG).show();
                        sendOtp.setVisibility(View.INVISIBLE);

                        new CountDownTimer(30000, 1000){
                            public void onTick(long millisUntilFinished){
                                otpTimer.setText(String.valueOf(counter));
                                otpTimer.setVisibility(View.VISIBLE);
                                counter--;
                            }
                            public  void onFinish(){
                                otpTimer.setVisibility(View.INVISIBLE);
                                sendOtp.setText("Resend Otp");
                                sendOtp.setVisibility(View.VISIBLE);
                                counter = 30;
                            }
                        }.start();

                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"response error",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });

    }

    private void validateOtpDetails() {

        JsonObject data = new JsonObject();

        int vCountry = countryModel.getCountry().getId();
        String vMobile = mobile.getText().toString().trim();
        String vOtp = validateOtp.getText().toString();



        try {
            data.addProperty("country_id",vCountry);
            data.addProperty("mobile", vMobile);
            data.addProperty("otp", 174730);

        }catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.validateMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,response.body().toString(),Toast.LENGTH_LONG).show();
                    validateOtp.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    private void registrationDetails() {

        JsonObject data = new JsonObject();



        String rFname = fname.getText().toString();
        String rLname = lname.getText().toString();
        String rMobile = mobile.getText().toString();
        int rOtp = 174730;
        String rPassword = "100000:711c845245d5563ba577d574993bc7be:7458b5e51b09a9d76fa3776999e010fe38e633fc732bd5c0e83b6ea1fb082a99f351d44162861bcd77cca40072f40d3c5421498ade9068ea0fe88b44e60d6e96";
        int rCountry = countryModel.getCountry().getId();



        try {
            data.addProperty("user_type_id", 4);
            data.addProperty("first_name", "Shankar");
            data.addProperty("last_name", "Andanappa");
            data.addProperty("country_id", 1);
            data.addProperty("mobile", "9844675900");
            data.addProperty("password", "100000:711c845245d5563ba577d574993bc7be:7458b5e51b09a9d76fa3776999e010fe38e633fc732bd5c0e83b6ea1fb082a99f351d44162861bcd77cca40072f40d3c5421498ade9068ea0fe88b44e60d6e96");

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.RegisterMethodPost(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}