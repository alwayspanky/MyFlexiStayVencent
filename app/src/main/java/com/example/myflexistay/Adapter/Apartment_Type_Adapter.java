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
import com.example.myflexistay.Model.Apartment_Type;
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

public class Apartment_Type_Adapter extends RecyclerView.Adapter<Apartment_Type_Adapter.dropholder>{


    Context context;
    ArrayList<Apartment_Type.ApartmentTypes> apartmentTypesArrayList;


    public Apartment_Type_Adapter(Context context, ArrayList<Apartment_Type.ApartmentTypes> apartment_types) {
        this.context = context;
        this.apartmentTypesArrayList = apartment_types;
    }
    public interface onOrderClickedListener {
        public void onOrderClickedListener(Apartment_Type.ApartmentTypes PropertyModel);
    }
    public Apartment_Type_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Apartment_Type_Adapter.onOrderClickedListener onOrderClickedListener1){
       this.onOrderClickedListener = onOrderClickedListener1;
    }

    @NonNull
    @Override
    public dropholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

//
        return new dropholder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull dropholder holder, final int position) {
        Apartment_Type.ApartmentTypes apartment_type= apartmentTypesArrayList.get(position);
        holder.textView.setText(apartment_type.getName());
       // Log.d("TAG", "onBindViewHolder: "+apartment_type.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onOrderClickedListener !=null)){
                    Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(position));
                    onOrderClickedListener.onOrderClickedListener(apartmentTypesArrayList.get(position));
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return apartmentTypesArrayList.size();
    }

    public class dropholder extends RecyclerView.ViewHolder {

         TextView textView;

        public dropholder(@NonNull View itemView) {
            super(itemView);
           textView = itemView.findViewById(R.id.apartment);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  // Log.d("TAG", "onClick: outside");
                   if ((onOrderClickedListener !=null)){
                       //Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(getAdapterPosition()));
                       onOrderClickedListener.onOrderClickedListener(apartmentTypesArrayList.get(getAdapterPosition()));
                   }
               }
           });
        }
    }
}
