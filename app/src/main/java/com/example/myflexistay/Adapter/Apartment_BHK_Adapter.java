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
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

public class Apartment_BHK_Adapter extends RecyclerView.Adapter<Apartment_BHK_Adapter.bhkholder> {

    Context context;
    ArrayList<Apartment_BHK.Apartmentbhk> apartmentbhkArrayList;


    public Apartment_BHK_Adapter(Context context, ArrayList<Apartment_BHK.Apartmentbhk> apartment_bhkList) {
        this.context = context;
        this.apartmentbhkArrayList = apartment_bhkList;
    }
    public Apartment_BHK_Adapter.onOrderClickedListener onOrderClickedListener;

    public interface onOrderClickedListener{
        public void onOrderClickedListener(Apartment_BHK.Apartmentbhk apartment_bhk);
    }

    public void setOnOrderClickedListener(Apartment_BHK_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }



    @NonNull
    @Override
    public bhkholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new bhkholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bhkholder holder, final int position) {

        Apartment_BHK.Apartmentbhk apartment_bhk= apartmentbhkArrayList.get(position);
        holder.textView.setText(apartment_bhk.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onOrderClickedListener !=null)){
                    // Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(position));
                    onOrderClickedListener.onOrderClickedListener(apartmentbhkArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return apartmentbhkArrayList.size();
    }

    public class bhkholder extends RecyclerView.ViewHolder {
        TextView textView;

        public bhkholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
//                        Log.d("TAG", "onClick: "+apartment_bhkList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(apartmentbhkArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
