package com.example.myflexistay.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myflexistay.Adapter.Amenties_Adapter;
import com.example.myflexistay.Adapter.ListingTypeAdapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.Amenities;
import com.example.myflexistay.Model.ListingTypeModel;
import com.example.myflexistay.Model.PropertyClassesModel;
import com.example.myflexistay.R;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPropertyActivity extends AppCompatActivity {

    Button addProperty;
    ApiClient apiClient;
    ArrayList<ListingTypeModel.ListingsBean> listingTypesArrayList;
    RecyclerView recyclerView;
    ArrayList<PropertyClassesModel.PropertyClassesBean> propertyClassesBeanArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_property);

        addProperty = findViewById(R.id.property_addbutton);
        recyclerView = findViewById(R.id.recycler_listingType);

        apiClient = new ApiClient();
        listingTypesArrayList = new ArrayList<>();
        propertyClassesBeanArrayList = new ArrayList<>();

        apiClient.apiInterface.getListingType().enqueue(new Callback<ListingTypeModel>() {
            @Override
            public void onResponse(Call<ListingTypeModel> call, Response<ListingTypeModel> response) {
                if (response.isSuccessful()) {
                    listingTypesArrayList = response.body().getListings();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(PostPropertyActivity.this, 2, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    ListingTypeAdapter listingTypeAdapter = new ListingTypeAdapter(PostPropertyActivity.this, listingTypesArrayList);
                    recyclerView.setAdapter(listingTypeAdapter);
                }
                else {
                    Toast.makeText(PostPropertyActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListingTypeModel> call, Throwable t) {
                Toast.makeText(PostPropertyActivity.this, "Network issue!", Toast.LENGTH_SHORT).show();
            }
        });

        //////Property classes

        apiClient.apiInterface.getPropertyClasses().enqueue(new Callback<PropertyClassesModel>() {
            @Override
            public void onResponse(Call<PropertyClassesModel> call, Response<PropertyClassesModel> response) {
                if (response.isSuccessful()) {
                    propertyClassesBeanArrayList = response.body().getPropertyClasses();
                }else{
                    Toast.makeText(PostPropertyActivity.this, "Failed to load property classes!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PropertyClassesModel> call, Throwable t) {
                Toast.makeText(PostPropertyActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });


        addProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObject data = new JsonObject();


                data.addProperty("s_token","RC4CWvgitxUSPrP1cSoqJoj4YEqiek6l98qPrglU1DtEc2n3GDdG6paEIeGXsbPs");
                data.addProperty("property_class_id",1);
                data.addProperty("listing_type_id",1);

                apiClient.apiInterface.createListing(data).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            Intent intent = new Intent(PostPropertyActivity.this,PropertyDetailsActivity.class);
                            intent.putExtra("listing_id",1);
                            startActivity(intent);
                        }else {
                            Toast.makeText(PostPropertyActivity.this, "Failed to post data!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(PostPropertyActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}