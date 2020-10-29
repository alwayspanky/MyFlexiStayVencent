package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myflexistay.R;

public class PostPropertyActivity extends AppCompatActivity {

    Button addProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_property);

        addProperty = findViewById(R.id.property_addbutton);

        addProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostPropertyActivity.this,PropertyDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}