package com.example.myflexistay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myflexistay.R;
import com.example.myflexistay.SplashScreen;

public class Splash_Screen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 3000;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




        Log.d("TAg", "Error");

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, LoginActivity.class);
                startActivity(intent);

            }
        }, SPLASH_SCREEN_TIME_OUT);


    }

}
