package com.example.myflexistay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Amenities;
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

public class Amenties_Adapter extends RecyclerView.Adapter<Amenties_Adapter.amentiesholder> {

    Context context;
    ArrayList<Amenities.Amenities_Types> amenitiesList;

    public Amenties_Adapter(Context context, ArrayList<Amenities.Amenities_Types> amenitiesList) {
        this.context = context;
        this.amenitiesList = amenitiesList;
    }

    @NonNull
    @Override
    public amentiesholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amenities_recyclerview, parent,false);

        return new amentiesholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull amentiesholder holder, int position) {

        Amenities.Amenities_Types amenities= amenitiesList.get(position);
        holder.radioButton.setText(amenities.getName());
    }

    @Override
    public int getItemCount() {
        return amenitiesList.size();
    }

    public class amentiesholder extends RecyclerView.ViewHolder {

        RadioButton radioButton;

        public amentiesholder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radio_button_lift);
        }
    }
}
