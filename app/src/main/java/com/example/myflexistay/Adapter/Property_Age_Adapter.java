package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Apartment_BHK;
import com.example.myflexistay.Model.Property_Age;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Property_Age_Adapter extends RecyclerView.Adapter<Property_Age_Adapter.ageholer> {

    Context context;
    ArrayList<Property_Age.Propertyage> property_ageArrayList;

    public Property_Age_Adapter(Context context, ArrayList<Property_Age.Propertyage> property_ageArrayList) {
        this.context = context;
        this.property_ageArrayList = property_ageArrayList;
    }

    public interface onOrderClickedListener {
        public void onOrderClickedListener(Property_Age.Propertyage property_age);
    }
    public Property_Age_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Property_Age_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }

    @NonNull
    @Override
    public ageholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new ageholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ageholer holder, final int position) {

        Property_Age.Propertyage property_age = property_ageArrayList.get(position);
        holder.textView.setText(property_age.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((onOrderClickedListener != null)){
                    onOrderClickedListener.onOrderClickedListener(property_ageArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return property_ageArrayList.size();
    }

    public class ageholer extends RecyclerView.ViewHolder {

        TextView textView;

        public ageholer(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
                        Log.d("TAG", "onClick: "+property_ageArrayList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(property_ageArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
