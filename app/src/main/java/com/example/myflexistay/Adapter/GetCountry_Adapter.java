package com.example.myflexistay.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GetCountry_Adapter extends RecyclerView.Adapter<GetCountry_Adapter.countryholder> {



    @NonNull
    @Override
    public countryholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull countryholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class countryholder extends RecyclerView.ViewHolder {


        public countryholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
