package com.example.myflexistay.Fragment;

import android.app.DatePickerDialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myflexistay.Adapter.Furnishing_Status_Adapter;
import com.example.myflexistay.Adapter.Parking_Adapter;
import com.example.myflexistay.Adapter.Property_Age_Adapter;
import com.example.myflexistay.Adapter.Tenant_Adapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.Furnishing_Status;
import com.example.myflexistay.Model.Parking;
import com.example.myflexistay.Model.Tenant;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link PropertyDetailsFragment3#newInstance} factory method to
// * create an instance of this fragment.
// */
public class PropertyDetailsFragment3 extends Fragment {


    //    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//    private Context Context;

    public PropertyDetailsFragment3() {
        // Required empty public constructor
    }

    EditText datepicker;


    EditText tenant, parking, expectedRent, expectedDeposite, availableFrom, furnishing;
    RadioGroup maintenance;
    RecyclerView recyclerView;
    String SelectedPreferredName;
    String SelectedParking;
    String SelectedFurnishing;
    LinearLayout view;
    boolean opened;
    ApiClient apiClient;
    ArrayList<Tenant.Tenanttypes> tenanttypes;
    ArrayList<Furnishing_Status.furnishing_status> furnishing_statuses;
    ArrayList<Parking.parking> parkings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_property_details3, container, false);
        // Inflate the layout for this fragment


        apiClient = new ApiClient();
        tenanttypes = new ArrayList<>();
        furnishing_statuses = new ArrayList<>();
        parkings = new ArrayList<>();
        tenant = v.findViewById(R.id.edt_preferred);
        furnishing = v.findViewById(R.id.edt_furnishing_status);
        parking = v.findViewById(R.id.edt_parking);
        recyclerView = v.findViewById(R.id.dropdown_recyclerview);
        expectedRent = v.findViewById(R.id.edt_expectedRent);
        expectedDeposite = v.findViewById(R.id.edt_expectedDeposite);
        maintenance = v.findViewById(R.id.radio_maintenance);
        view = v.findViewById(R.id.dropdown_layout);
        availableFrom = v.findViewById(R.id.edt_date);



        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        availableFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        availableFrom.setText(date);
                    }
                }, year, month, day
                );
                datePickerDialog.show();
            }
        });

        tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apiClient.apiInterface.getTenantTypes().enqueue(new Callback<Tenant>() {
                    @Override
                    public void onResponse(Call<Tenant> call, Response<Tenant> response) {
                        if (response.isSuccessful()){
                            tenanttypes.clear();
                            tenanttypes.addAll(response.body().getTypes());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Tenant_Adapter tenant_adapter = new Tenant_Adapter(getActivity(), tenanttypes);
                            recyclerView.setAdapter(tenant_adapter);
                            tenant_adapter.notifyDataSetChanged();
                            tenant_adapter.setOnOrderClickedListener(new ClickListener());

                        }
                    }

                    @Override
                    public void onFailure(Call<Tenant> call, Throwable t) {
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


        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiClient.apiInterface.getParking().enqueue(new Callback<Parking>() {
                    @Override
                    public void onResponse(Call<Parking> call, Response<Parking> response) {
                        if (response.isSuccessful()) {
                            parkings.clear();
                            parkings.addAll(response.body().getParkingstypes());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Parking_Adapter parking_adapter = new Parking_Adapter(getActivity(), parkings);
                            recyclerView.setAdapter(parking_adapter);
                            parking_adapter.notifyDataSetChanged();
                            parking_adapter.setOnOrderClickedListener(new ClickListener1());
                        }
                    }

                    @Override
                    public void onFailure(Call<Parking> call, Throwable t) {
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


        furnishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiClient.apiInterface.getFurnishingStatus().enqueue(new Callback<Furnishing_Status>() {
                    @Override
                    public void onResponse(Call<Furnishing_Status> call, Response<Furnishing_Status> response) {

                        if (response.isSuccessful()){
                            furnishing_statuses.clear();
                            furnishing_statuses.addAll(response.body().getFurnishingStatuses());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            Furnishing_Status_Adapter furnishing_status_adapter = new Furnishing_Status_Adapter(getActivity(), furnishing_statuses);
                            recyclerView.setAdapter(furnishing_status_adapter);
                            furnishing_status_adapter.notifyDataSetChanged();
                            furnishing_status_adapter.setOnOrderClickedListener(new ClickListener2());
                        }
                    }

                    @Override
                    public void onFailure(Call<Furnishing_Status> call, Throwable t) {
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



        Button pro3 = v.findViewById(R.id.fragment_button3);
        pro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                String expRent = expectedRent.getText().toString();
//                String expDeposite = expectedDeposite.getText().toString();
//                String date = availableFrom.getText().toString();
//                String prefTenent = tenant.getText().toString();
//                String expParking = parking.getText().toString();
//                int isMaintenance = maintenance.getCheckedRadioButtonId();
//
//
//                int valid = 1;
//
//
//
//                if (expRent.isEmpty() || expRent.length() < 10) {
//                    expectedRent.setError("Enter Rent");
//                    expectedRent.requestFocus();
//                    valid = 0;
//                }
//
//                if (expDeposite.isEmpty()) {
//                    expectedDeposite.setError("Enter Deposit ");
//                    expectedDeposite.requestFocus();
//                    valid = 0;
//                }
//
//                if (valid == 1){
//
//                    postLocalityDetails();
//                }
                    postLocalityDetails();

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
                    PropertyDetailsFragment4 fragment4 = new PropertyDetailsFragment4();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_content, fragment4);
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

    private class ClickListener implements Tenant_Adapter.onOrderClickedListener {


        @Override
        public void onOrderClickedListener(Tenant.Tenanttypes tenanttypes) {
            SelectedPreferredName = tenanttypes.getName();
            Log.d("TAG", "onOrderClickListener: " + SelectedPreferredName );
            tenant.setText(SelectedPreferredName);
        }
    }

    private class ClickListener1 implements Parking_Adapter.onOrderClickedListener{

        @Override
        public void onOrderClickedListener(Parking.parking parking2) {
            SelectedParking = parking2.getName();
            Log.d("TAG", "onOrderClickListener: " + SelectedParking );
            parking.setText(SelectedParking);
        }
    }

    private class ClickListener2 implements Furnishing_Status_Adapter.onOrderClickedListener{

        @Override
        public void onOrderClickedListener(Furnishing_Status.furnishing_status furnishingStatus) {
            SelectedFurnishing = furnishingStatus.getName();
            Log.d("TAG", "onOrderClickListener: " + SelectedFurnishing );
            furnishing.setText(SelectedFurnishing);
        }
    }
}
