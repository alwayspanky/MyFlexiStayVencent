package com.example.myflexistay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Fragment.Flatmate;
import com.example.myflexistay.Fragment.FullHouse;
import com.example.myflexistay.Fragment.PGFragment;

public class Rentscreen extends AppCompatActivity {

    private ImageView img4, img5;
    Button button, button1;
    RadioButton pghouse, fullhouse, flatmates;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentscreen);


        button = findViewById(R.id.button);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PGFragment()).commit();
        }

        //Pg house on button click fragment
      pghouse = findViewById(R.id.btn_pg);
        pghouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PGFragment frgPg = new PGFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,frgPg);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


// Full house on button click fragment
        fullhouse = findViewById(R.id.btn_full_house);
        fullhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullHouse frgFullhouse = new FullHouse();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,frgFullhouse);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        // Full house on button click fragment
        flatmates = findViewById(R.id.btn_flatmate);
        flatmates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Flatmate frgFlatmate = new Flatmate();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,frgFlatmate);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        PGFragment pgFragment = new PGFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        manager.beginTransaction().add(R.id.main_activity, pgFragment);




//        img4 = findViewById(R.id.img4);
//        img5 = findViewById(R.id.img5);


        img4 = findViewById(R.id.img4);
        Glide.with(Rentscreen.this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Icons/Back+48+%C3%97+48+area+in+64+%C3%97+64+(xhdpi)-13.png")
                .into(img4);

        img5 = findViewById(R.id.img5);
        Glide.with(Rentscreen.this)
                .load("https://myflexistay-dev-icons.s3.ap-south-1.amazonaws.com/Icons/Back1+48+%C3%97+48+area+in+64+%C3%97+64+(xhdpi)-14.png")
                .into(img5);
    }

//    private void Change(){
//
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Rentscreen.this, PGFragment.class);
//                startActivity(intent);
//            }
//        });
//    }





//    private void ChangeColor(){
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                button.setBackground(getResources().getDrawable(R.drawable.button_background_green));
//            }
//        });
//
//    }
//

}