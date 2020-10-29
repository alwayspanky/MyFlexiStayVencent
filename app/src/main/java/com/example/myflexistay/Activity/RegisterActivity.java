package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btn1;
    private EditText fname, lname, email, pass, reff;
    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        fname = findViewById(R.id.edt1);
        lname = findViewById(R.id.edt2);
        email = findViewById(R.id.edt3);
        pass = findViewById(R.id.edt4);
        reff = findViewById(R.id.edt5);

        apiClient = new ApiClient();

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rFname = fname.getText().toString();
                String rLname = lname.getText().toString();
                String rEmail = email.getText().toString();
                String rPassword = pass.getText().toString();
                String rReff = reff.getText().toString();

                Intent intent = new Intent(RegisterActivity.this, RegisterActivity1.class);

                intent.putExtra("firstName", rFname);
                intent.putExtra("lastName", rLname);
                intent.putExtra("email", rEmail);
                intent.putExtra("password", rPassword);
                intent.putExtra("reference", rReff);

                startActivity(intent);
            }
        });


    }

}