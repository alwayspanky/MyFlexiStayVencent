package com.example.myflexistay.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Navigation.Categoryscreen;
import com.example.myflexistay.Navigation.Chatscreen;
import com.example.myflexistay.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private SearchView searchView;
    RadioButton Rent, buy;
    private ImageView img1, img2, img3, imgbanner;
    Button button;
    MaterialButton rentbtn , buybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setItemIconTintList(null);





        searchView = findViewById(R.id.searchView);
        button = findViewById(R.id.button);


        imgbanner = findViewById(R.id.img_home_banner);
        Glide.with(this)
                .load("https://myflexistay-dev-images.s3.ap-south-1.amazonaws.com/Images-10.jpg")
                .into(imgbanner);

        img1 = findViewById(R.id.image1);
        Glide.with(this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Other+Icons-01.png")
                .into(img1);

        img2 = findViewById(R.id.img2);
        Glide.with(this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Other+Icons-02.png")
                .into(img2);


        img3 = findViewById(R.id.img3);
        Glide.with(this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Other+Icons-03.png")
                .into(img3);


        Login();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_message:
                        startActivity(new Intent(getApplicationContext(), Chatscreen.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_home:
                        return true;

                    case R.id.nav_category:
                        startActivity(new Intent(getApplicationContext(), PostPropertyActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });

    }


    private void Login(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostPropertyActivity.class);
                startActivity(intent);
            }
        });
    }




}
