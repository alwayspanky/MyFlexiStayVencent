package com.example.myflexistay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Model.Amenities;
import com.example.myflexistay.Model.Furnishing;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Furnishing_Adapter extends RecyclerView.Adapter<Furnishing_Adapter.furnishingholder> {



    Context context;
    ArrayList<Furnishing.Furnishing_Types> furnishingTypesArrayList;


    public Furnishing_Adapter(Context context, ArrayList<Furnishing.Furnishing_Types> furnishingTypesArrayList) {
        this.context = context;
        this.furnishingTypesArrayList = furnishingTypesArrayList;
    }

    @NonNull
    @Override
    public furnishingholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.furnishing_recyclerview, parent,false);

        return new furnishingholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull furnishingholder holder, int position) {

        Furnishing.Furnishing_Types furnishingTypes= furnishingTypesArrayList.get(position);
        holder.textView.setText(furnishingTypes.getName());
        Glide.with(context).load(furnishingTypes.getIcon_url())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return furnishingTypesArrayList.size();
    }

    public class furnishingholder extends RecyclerView.ViewHolder {

        RadioButton radioButton;
        TextView textView;
        ImageView imageView;

        public furnishingholder(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radio_button_furnish);
            textView = itemView.findViewById(R.id.txt_furnishing);
            imageView = itemView.findViewById(R.id.img_furnishing);
        }
    }
}
