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
import android.widget.RadioButton;

import com.example.myflexistay.Adapter.Amenties_Adapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.Amenities;
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDetailsFragment5 extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<Amenities.Amenities_Types> amenitiesArrayList;
    ApiClient apiClient;
    RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_property_details5, container, false);
        // Inflate the layout for this fragment

        apiClient = new ApiClient();
        amenitiesArrayList = new ArrayList<>();
        Button pro5 = v.findViewById(R.id.fragment_button5);
        radioButton = v.findViewById(R.id.radio_button_lift);
        recyclerView = v.findViewById(R.id.amenties_recycler);

        pro5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyDetailsFragment6 fragment6 = new PropertyDetailsFragment6();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, fragment6);
                fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();
            }
        });

//        recyclerView.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        Amenties_Adapter amenties_adapter = new Amenties_Adapter(getActivity(), amenitiesArrayList);
//        recyclerView.setAdapter(amenties_adapter);


                apiClient.apiInterface.getAmenities().enqueue(new Callback<Amenities>() {
                    @Override
                    public void onResponse(Call<Amenities> call, Response<Amenities> response) {
                        if (response.isSuccessful()) {
                            amenitiesArrayList = response.body().getAmenitiesTypes();
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            Amenties_Adapter amenties_adapter = new Amenties_Adapter(getActivity(), amenitiesArrayList);
                            recyclerView.setAdapter(amenties_adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Amenities> call, Throwable t) {
                        Log.d("TAG", "onFailure: "+t.toString());

                    }
                });




        return v;
    }
}