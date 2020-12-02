package com.example.myflexistay.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myflexistay.Adapter.Amenties_Adapter;
import com.example.myflexistay.Adapter.Furnishing_Adapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.Furnishing;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDetailsFragment6 extends Fragment {

    Button Furnishing;
    ArrayList<Furnishing.Furnishing_Types> furnishing_types;
    ApiClient apiClient;
    RadioButton radioButton;
    LinearLayout view;
    boolean opened;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view =  inflater.inflate(R.layout.fragment_property_details7, container, false);

        apiClient = new ApiClient();
        furnishing_types = new ArrayList<>();
        radioButton = view.findViewById(R.id.radio_button_furnish);
        Furnishing = view.findViewById(R.id.furnishing_save_continue);
        recyclerView = view.findViewById(R.id.furnishing_recycler);

        apiClient.apiInterface.getFurnishing().enqueue(new Callback<com.example.myflexistay.Model.Furnishing>() {
            @Override
            public void onResponse(Call<Furnishing> call, Response<com.example.myflexistay.Model.Furnishing> response) {
                if (response.isSuccessful()){
                    furnishing_types = response.body().getFurnishing_types();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    Furnishing_Adapter furnishing_adapter = new Furnishing_Adapter(getActivity(), furnishing_types);
                    recyclerView.setAdapter(furnishing_adapter);
                }

            }

            @Override
            public void onFailure(Call<Furnishing> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.toString());

            }
        });


        Furnishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JsonObject data = new JsonObject();

                try {
                    data.addProperty("s_token", "SLQdyA4ELQY0ddrDv4y7EKAOnlNUmUPXbGzgGN8AxF3EcA5OSZaoO26bc6lHMXVO");
                    data.addProperty("listing_id", "1");
                    data.addProperty("furnishing_id", "2");
                    data.addProperty("quantity", "1");
                }catch (JsonIOException e){
                    e.printStackTrace();
                }

                apiClient.apiInterface.postUpdateFurnishing(data).enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){

                            PropertyDetailsFragment7 fragment7 = new PropertyDetailsFragment7();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_content, fragment7);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());


                    }
                });

            }
        });



        return view;
    }
}