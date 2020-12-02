package com.example.myflexistay.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link PropertyDetailsFragment2#newInstance} factory method to
// * create an instance of this fragment.
// */
public class PropertyDetailsFragment2 extends Fragment {



    public PropertyDetailsFragment2() {
        // Required empty public constructor
    }

    private EditText address,pincode;
    ApiClient apiClient;
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_property_details2, container, false);
        // Inflate the layout for this fragment


        searchView = v.findViewById(R.id.searchView);
        address = v.findViewById(R.id.edt_address);
        pincode = v.findViewById(R.id.edt_pincode);
        apiClient = new ApiClient();

        JsonObject data = new JsonObject();

        int state_id = 1;
        try {
            data.addProperty("state_id", state_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.postCities(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("TAG", "onResponse: " + response);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Network Problem !", Toast.LENGTH_SHORT).show();

            }
        });


        JsonObject data1 = new JsonObject();

        int city_id = 1;
        try {
            data1.addProperty("city_id", city_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        apiClient.apiInterface.postLocalities(data1).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("TAG", "onResponse: " + response);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Network Problem !", Toast.LENGTH_SHORT).show();

            }
        });




        Button pro2 = v.findViewById(R.id.fragment_button2);
        pro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String add = address.getText().toString();
                String pinCode = pincode.getText().toString();

                int valid = 1;



                if (add.isEmpty() || add.length() < 10) {
                    address.setError("Enter Address");
                    address.requestFocus();
                    valid = 0;
                }

                if (pinCode.isEmpty()) {
                    pincode.setError("Enter Pincode ");
                    pincode.requestFocus();
                    valid = 0;
                }

                if (valid == 1){

                    postLocalityDetails();
                }
            }
        });
        return v;

    }

    private void postLocalityDetails() {


        JsonObject data = new JsonObject();

        try {
            data.addProperty("listing_id", 1);
            data.addProperty("city_id", 1);
            data.addProperty("locality_id", 1);
            data.addProperty("pincode_id", 1);
            data.addProperty("address_1", "Magarpatta");
            data.addProperty("address_2", "Hadapsur");
            data.addProperty("longitude", 18.496668);
            data.addProperty("latitude", 73.941666);
            data.addProperty("landmark", "Pune");
            data.addProperty("s_token", "h72WYFvQwmhLzN2kFjWOmq2rR575ZKwrMY9UHtqvMlcAwxSzp7uynWgGzajTv4US");

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.postLocalityDetails(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_SHORT).show();
                    PropertyDetailsFragment3 fragment3 = new PropertyDetailsFragment3();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_content, fragment3);
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