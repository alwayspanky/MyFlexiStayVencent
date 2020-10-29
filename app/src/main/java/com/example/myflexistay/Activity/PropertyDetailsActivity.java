package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.myflexistay.Fragment.PropertyDetailsFragment1;
import com.example.myflexistay.R;

public class PropertyDetailsActivity extends AppCompatActivity {
    private EditText apartment;


    LinearLayout view;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        if(savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().replace(R.id.fragment_content,new PropertyDetailsFragment1()).commit();
        }



        view = findViewById(R.id.dropdown_layout);
//        selectApartment.isFocusable();



    }

}