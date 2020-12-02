package com.example.myflexistay.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myflexistay.Activity.LoginActivity;
import com.example.myflexistay.Activity.RegisterActivity1;
import com.example.myflexistay.Adapter.Apartment_BHK_Adapter;
import com.example.myflexistay.Adapter.Apartment_Type_Adapter;
import com.example.myflexistay.Adapter.Facing_Adapter;
import com.example.myflexistay.Adapter.Property_Age_Adapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Api.ApiInterface;
import com.example.myflexistay.Model.Apartment_BHK;
import com.example.myflexistay.Model.Apartment_Type;
import com.example.myflexistay.Model.Facing;
import com.example.myflexistay.Model.Property_Age;
import com.example.myflexistay.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class PropertyDetailsFragment1 extends Fragment {


    public PropertyDetailsFragment1() {
        // Required empty public constructor
    }

    private EditText edtApartment, edt_facing, edt_bhk, edt_property_age, edt_floor1, edt_floor2, edt_apartment_name;
    LinearLayout view;
    boolean opened;
    RecyclerView recyclerView;
    String SelectedPropertyName;
    String SelectedBhkname;
    String SelectedPropertyAge;
    String SelectedFacing;
    ApiClient apiClient;
    ArrayList<Apartment_Type.ApartmentTypes> apartmentTypesArrayList;
    ArrayList<Apartment_BHK.Apartmentbhk> apartmentbhks;
    ArrayList<Property_Age.Propertyage> propertyAges;
    ArrayList<Facing.facing> facingArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_property_details1, container, false);
        // Inflate the layout for this fragment
        edtApartment = v.findViewById(R.id.edt_apartment);
        edt_floor1 = v.findViewById(R.id.edt_floor);
        edt_floor2 = v.findViewById(R.id.edt_floor_total);
        edt_apartment_name = v.findViewById(R.id.edt_name);
        edt_bhk = v.findViewById(R.id.edt_bhk);
        edt_property_age = v.findViewById(R.id.edt_property_age);
        edt_facing = v.findViewById(R.id.edt_facing);
        apiClient = new ApiClient();
        view = v.findViewById(R.id.dropdown_layout);
        recyclerView = v.findViewById(R.id.dropdown_recyclerview);

        apartmentTypesArrayList = new ArrayList<>();
        apartmentbhks = new ArrayList<>();
        propertyAges = new ArrayList<>();
        facingArrayList = new ArrayList<>();

        edtApartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
               hideKeyBoard(edtApartment);
                OkHttpClient client1 = new OkHttpClient().newBuilder()
                        .connectTimeout(80, TimeUnit.SECONDS)
                        .readTimeout(80, TimeUnit.SECONDS)
                        .writeTimeout(80, TimeUnit.SECONDS)
                        .build();
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://acabc9536i.execute-api.ap-south-1.amazonaws.com/development/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        //.addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client1)
                        .build();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                apiInterface.getAllApartment().enqueue(new Callback<Apartment_Type>() {
                    @Override
                    public void onResponse(Call<Apartment_Type> call, Response<Apartment_Type> response) {
                        if (response.isSuccessful()){
                            apartmentTypesArrayList.clear();
                            apartmentTypesArrayList.addAll(response.body().getTypes());
                            //Log.d("TAG", "onResponse: "+response.body().getTypes().get(0).getName());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Apartment_Type_Adapter apartment_type_adapter = new Apartment_Type_Adapter(getActivity(),apartmentTypesArrayList);
                            recyclerView.setAdapter(apartment_type_adapter);
                            apartment_type_adapter.notifyDataSetChanged();

//                            Functioncalling();
                            apartment_type_adapter.setOnOrderClickedListener(new AdapterClickListener());
                        }else {
                            Log.d("TAG", "onResponse: Null Data here");
                        }
                    }

                    @Override
                    public void onFailure(Call<Apartment_Type> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());
                    }
                });




                if (!opened) {
                    view.setVisibility(View.VISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            view.getHeight(),
                            0);
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                } else {
                    view.setVisibility(View.INVISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            0,
                            view.getHeight());
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                }
                opened = !opened;

            }
        });



        edt_bhk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard(edt_bhk);
                OkHttpClient client1 = new OkHttpClient().newBuilder()
                        .connectTimeout(80, TimeUnit.SECONDS)
                        .readTimeout(80, TimeUnit.SECONDS)
                        .writeTimeout(80, TimeUnit.SECONDS)
                        .build();
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://acabc9536i.execute-api.ap-south-1.amazonaws.com/development/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        //.addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client1)
                        .build();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                apiInterface.getAllBHK().enqueue(new Callback<Apartment_BHK>() {
                    @Override
                    public void onResponse(Call<Apartment_BHK> call, Response<Apartment_BHK> response) {
                        if (response.isSuccessful()){
                            apartmentbhks.clear();
                            apartmentbhks.addAll(response.body().getBhks());
                            //Log.d("TAG", "onResponse: "+response.body().getTypes().get(0).getName());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Apartment_BHK_Adapter apartment_bhk_adapter = new Apartment_BHK_Adapter(getActivity(),apartmentbhks);
                            recyclerView.setAdapter(apartment_bhk_adapter);
                            apartment_bhk_adapter.notifyDataSetChanged();
                            apartment_bhk_adapter.setOnOrderClickedListener(new AdapterListener1());
                        }else {
                            Log.d("TAG", "onResponse: Null Data here");
                        }
                    }

                    @Override
                    public void onFailure(Call<Apartment_BHK> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());
                    }
                });



                if (!opened) {
                    view.setVisibility(View.VISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            view.getHeight(),
                            0);
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                } else {
                    view.setVisibility(View.INVISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            0,
                            view.getHeight());
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                }
                opened = !opened;

            }
        });

        edt_property_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideKeyBoard(edt_property_age);
                apiClient.apiInterface.getAllPropertyAges().enqueue(new Callback<Property_Age>() {
                    @Override
                    public void onResponse(Call<Property_Age>call, Response<Property_Age> response) {
                        if (response.isSuccessful()){
                            propertyAges.clear();
                            propertyAges.addAll(response.body().getPropertyages());
                            //Log.d("TAG", "onResponse: "+response.body().getTypes().get(0).getName());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Property_Age_Adapter propertyAgeAdapter = new Property_Age_Adapter(getActivity(),propertyAges);
                            recyclerView.setAdapter(propertyAgeAdapter);
                            propertyAgeAdapter.notifyDataSetChanged();
                            propertyAgeAdapter.setOnOrderClickedListener(new AdapterListener2());
                        }

                    }

                    @Override
                    public void onFailure(Call<Property_Age> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());

                    }
                });


                if (!opened) {
                    view.setVisibility(View.VISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            view.getHeight(),
                            0);
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                } else {
                    view.setVisibility(View.INVISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            0,
                            view.getHeight());
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                }
                opened = !opened;

            }
        });

        edt_facing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard(edt_facing);
                apiClient.apiInterface.getAllFacing().enqueue(new Callback<Facing>() {
                    @Override
                    public void onResponse(Call<Facing> call, Response<Facing> response) {
                        if (response.isSuccessful()){
                            facingArrayList.clear();
                            facingArrayList.addAll(response.body().getFacings());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Facing_Adapter facing_adapter = new Facing_Adapter(getActivity(),facingArrayList);
                            recyclerView.setAdapter(facing_adapter);
                            facing_adapter.notifyDataSetChanged();
                            facing_adapter.setOnOrderClickedListener(new AdapterListener3());

                        }
                    }

                    @Override
                    public void onFailure(Call<Facing> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());

                    }
                });

                if (!opened) {
                    view.setVisibility(View.VISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            view.getHeight(),
                            0);
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                } else {
                    view.setVisibility(View.INVISIBLE);
                    TranslateAnimation animate = new TranslateAnimation(
                            0,
                            0,
                            0,
                            view.getHeight());
                    animate.setDuration(500);
                    animate.setFillAfter(true);
                    view.startAnimation(animate);
                }
                opened = !opened;

            }
        });


        Button fragBtn = v.findViewById(R.id.save_continue1);
        fragBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveContinue();


            }
        });
        return v;
    }

    private class AdapterClickListener implements Apartment_Type_Adapter.onOrderClickedListener {
        @Override
        public void onOrderClickedListener(Apartment_Type.ApartmentTypes PropertyModel) {
            SelectedPropertyName = PropertyModel.getName();
            Log.d("TAG", "onOrderClickedListener: " + SelectedPropertyName);
            edtApartment.setText(SelectedPropertyName);

        }
    }

    private class AdapterListener1 implements Apartment_BHK_Adapter.onOrderClickedListener {

        @Override
        public void onOrderClickedListener(Apartment_BHK.Apartmentbhk apartment_bhk) {
            SelectedBhkname = apartment_bhk.getName();

            //Log.d("TAG", "onOrderClickedListener: " + SelectedBhkname);
            edt_bhk.setText(SelectedBhkname);
        }
    }

    private class AdapterListener2 implements Property_Age_Adapter.onOrderClickedListener{

        @Override
        public void onOrderClickedListener(Property_Age.Propertyage property_age) {
            SelectedPropertyAge = property_age.getName();
            Log.d("TAG", "onOrderClickedListener: " + SelectedPropertyAge);
            edt_property_age.setText(SelectedPropertyAge);

        }
    }

    private class AdapterListener3 implements Facing_Adapter.onOrderClickedListener{

        @Override
        public void onOrderClickedListener(Facing.facing facing) {
            SelectedFacing = facing.getName();
            //Log.d("TAG", "onOrderClickedListener: " + SelectedFacing);
            edt_facing.setText(SelectedFacing);

        }
    }
    public void hideKeyBoard(View view){
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void Functioncalling(){


        if (!opened){
            view.setVisibility(view.VISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0,
                    view.getHeight(),
                    0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
        }else {
            view.setVisibility(View.INVISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0,
                    0,
                    view.getHeight());
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
        }
        opened = !opened;
    }

    public void SaveContinue() {
//
//
//
//        String apartment = edtApartment.getText().toString();
//        String apartment_name = edt_apartment_name.getText().toString();
//        String bhk = edt_bhk.getText().toString();
//        String floor = edt_floor1.getText().toString();
//        String floor_total = edt_floor2.getText().toString();
//        String property_age = edt_property_age.getText().toString();
//
//        int valid = 1;
//
//        if (apartment.isEmpty() || apartment.length() < 10) {
//            edtApartment.setError("Enter Apartment Type");
//            edtApartment.requestFocus();
//            valid = 0;
//        }
//
//        if (apartment_name.isEmpty() || apartment_name.length() < 10) {
//            edt_apartment_name.setError("Enter Apartment Name");
//            edt_apartment_name.requestFocus();
//            valid = 0;
//        }
//
//        if (bhk.isEmpty()) {
//            edt_bhk.setError("Enter BHK ");
//            edt_bhk.requestFocus();
//            valid = 0;
//        }
//        if (floor.isEmpty() ) {
//            edt_floor1.setError("Enter Floor Number");
//            edt_floor1.requestFocus();
//            valid = 0;
//        }
//        if (floor_total.isEmpty() ) {
//            edt_floor2.setError("Enter Total Floor");
//            edt_floor2.requestFocus();
//            valid = 0;
//        }
//        if (property_age.isEmpty() || property_age.length() < 10) {
//            edt_property_age.setError("Enter Property Age");
//            edt_property_age.requestFocus();
//            valid = 0;
//        }
//
//        if (valid == 1){

            postPropertyDetails();
        }



    private void postPropertyDetails() {


        JsonObject data = new JsonObject();
        try {
            data.addProperty("s_token", "K5lH8VEfM2NbabS8DQnMy7hz2qyRaRAYzgIlwtJKcZ0vflpDhULeYOo4HwEoqKoB");
            data.addProperty("apartment_name", "Laburnum");
            data.addProperty("bhk_type_id", 2);
            data.addProperty("sharing_type_id", 1);
            data.addProperty("built_up_area", 1700);
            data.addProperty("carpet_area", 1200);
            data.addProperty("facing_type_id", 1);
            data.addProperty("floor", 1);
            data.addProperty("listing_id", 1);
            data.addProperty("number_of_balconies", 2);
            data.addProperty("number_of_bathrooms", 2);
            data.addProperty("prefer_only_vegetarians", 1);
            data.addProperty("water_supply_type_id", 1);
            data.addProperty("property_age_type_id", 1);
            data.addProperty("property_type_id", 1);
            data.addProperty("total_floor", 2);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.postPropertyDetails(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_SHORT).show();
                    PropertyDetailsFragment2 fragment2 = new PropertyDetailsFragment2();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_content, fragment2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else {
                    Toast.makeText(getActivity(), "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Network Problem !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}