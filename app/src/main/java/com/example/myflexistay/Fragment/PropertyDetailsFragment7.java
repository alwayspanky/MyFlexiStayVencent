package com.example.myflexistay.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myflexistay.Adapter.Apartment_Type_Adapter;
import com.example.myflexistay.Adapter.Availabilty_Adapter;
import com.example.myflexistay.Adapter.Property_Age_Adapter;
import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.Model.Apartment_Type;
import com.example.myflexistay.Model.Availability;
import com.example.myflexistay.R;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDetailsFragment7 extends Fragment {



    public PropertyDetailsFragment7() {
        // Required empty public constructor
    }

    private EditText availability;
    LinearLayout view;
    boolean opened;
    ApiClient apiClient;
    RecyclerView recyclerView;
    ArrayList<Availability.Available> availables;
    String SelectedAvailabilty;
    EditText picker1, picker2;
    Button finishProperty;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_property_details6, container, false);


         availability = v.findViewById(R.id.edt_availability);
         apiClient = new ApiClient();
         view = v.findViewById(R.id.dropdown_layout);
         recyclerView = v.findViewById(R.id.dropdown_recyclerview);
         availables = new ArrayList<>();
         picker1 = v.findViewById(R.id.date_picker1);
         picker2 = v.findViewById(R.id.date_picker2);
         finishProperty = v.findViewById(R.id.fragment_button6);


        PostUnListing();


        postProperty();
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        picker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        picker1.setText(date);
                    }
                }, year, month, day
                );
                datePickerDialog.show();
            }

        });

        picker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        picker2.setText(date);
                    }
                }, year, month, day
                );
                datePickerDialog.show();
            }
        });


         availability.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 hideKeyBoard(availability);

                 apiClient.apiInterface.getAvailability().enqueue(new Callback<Availability>() {
                     @Override
                     public void onResponse(Call<Availability> call, Response<Availability> response) {
                         if (response.isSuccessful()){
                             availables.clear();
                             availables.addAll(response.body().getAvailables());
                             recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                             Availabilty_Adapter availabilty_adapter = new Availabilty_Adapter(getActivity(),availables);
                             recyclerView.setAdapter(availabilty_adapter);
                             availabilty_adapter.notifyDataSetChanged();
                             availabilty_adapter.setOnOrderClickListener(new ClickListener());
                         }
                     }

                     @Override
                     public void onFailure(Call<Availability> call, Throwable t) {
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

         return v;
    }

    private void postProperty() {

        finishProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String avail = availability.getText().toString();
                String startTime = picker1.getText().toString();
                String endTime = picker2.getText().toString();

                int valid = 1;

                if (avail.isEmpty() || avail.length() < 10) {
                    availability.setError("Enter Availability");
                    availability.requestFocus();
                    valid = 0;
                }

                if (startTime.isEmpty() ) {
                    picker1.setError("Enter Date");
                    picker1.requestFocus();
                    valid = 0;
                }

                if (endTime.isEmpty()) {
                    picker2.setError("Enter Date ");
                    picker2.requestFocus();
                    valid = 0;
                }

                if (valid == 1){

                    Listing();
                }

            }
        });
    }

    private void PostUnListing() {

        JsonObject data = new JsonObject();

        try {
            data.addProperty("listing_id", 1);
            data.addProperty("s_token", "eaSGJZKWOYLpg4Q4213jND3rOneB6a6lh0gZv4Y7sG3DeowEAKUoJW6pSfjBkwQR");

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        apiClient.apiInterface.postunlistting(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", "onResponse: " + response);

//                    Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_SHORT).show();
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

    private void Listing(){
        JsonObject data = new JsonObject();

//        int Listing_id = 1;
//        String s_token = "eaSGJZKWOYLpg4Q4213jND3rOneB6a6lh0gZv4Y7sG3DeowEAKUoJW6pSfjBkwQR";

        try {
            data.addProperty("listing_id", 2);
            data.addProperty("s_token", "SLQdyA4ELQY0ddrDv4y7EKAOnlNUmUPXbGzgGN8AxF3EcA5OSZaoO26bc6lHMXVO");
            data.addProperty("availability_type_id", "1");
            data.addProperty("from_interval_id", "1");
            data.addProperty("to_interval_id", "94");
        }catch (JsonIOException e){
            e.printStackTrace();
        }

        apiClient.apiInterface.postScheduleDetails(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){

                    PublishListing();
                    Toast.makeText(getActivity(), "Success List !", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Network Problem !", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void PublishListing(){

        JsonObject data = new JsonObject();
        try {
            data.addProperty("listing_id", "1");
            data.addProperty("s_token","SLQdyA4ELQY0ddrDv4y7EKAOnlNUmUPXbGzgGN8AxF3EcA5OSZaoO26bc6lHMXVO");
        }catch (JsonIOException e){
            e.printStackTrace();
        }

        apiClient.apiInterface.postPublishListing(data).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Toast.makeText(getActivity(), "Success List !", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Network Problem !", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private class ClickListener implements Availabilty_Adapter.onOrderClickListener {

        @Override
        public void onOrderClickListener(Availability.Available availability1) {

            SelectedAvailabilty = availability1.getName();
             Log.d("TAG", "onOrderClickedListener: " + SelectedAvailabilty);
//            availability.setName(SelectedAvailabilty);
            availability.setText(SelectedAvailabilty);

        }
    }




    public void hideKeyBoard(View view){
    final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
}
}