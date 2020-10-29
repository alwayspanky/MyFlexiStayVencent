package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.example.myflexistay.Adapter.PropertyListingAdapter;
import com.example.myflexistay.R;

public class PropertyListingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_listing);

        toolbar = findViewById(R.id.listing_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        recyclerView = findViewById(R.id.recycler_listing);
        recyclerView.setLayoutManager(new LinearLayoutManager(PropertyListingActivity.this));
        recyclerView.setAdapter(new PropertyListingAdapter());

    }
}