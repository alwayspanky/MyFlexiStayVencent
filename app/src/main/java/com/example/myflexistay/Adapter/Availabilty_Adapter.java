package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Availability;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Availabilty_Adapter extends RecyclerView.Adapter<Availabilty_Adapter.availabiltyholder> {


    Context context;
    ArrayList<Availability.Available> availabilityArrayList;

    public Availabilty_Adapter(Context context, ArrayList<Availability.Available> availabilityArrayList) {
        this.context = context;
        this.availabilityArrayList = availabilityArrayList;
    }

    public interface onOrderClickListener{
        public void onOrderClickListener(Availability.Available availability);
    }

    public Availabilty_Adapter.onOrderClickListener onOrderClickListener;
    public void setOnOrderClickListener(Availabilty_Adapter.onOrderClickListener onOrderClickListener){
        this.onOrderClickListener = onOrderClickListener;
    }

    @NonNull
    @Override
    public availabiltyholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new availabiltyholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull availabiltyholder holder, final int position) {

        Availability.Available availability = availabilityArrayList.get(position);
        holder.textView.setText(availability.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((onOrderClickListener !=null)){
                    // Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(position));
                    onOrderClickListener.onOrderClickListener(availabilityArrayList.get(position));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return availabilityArrayList.size();
    }

    public class availabiltyholder extends RecyclerView.ViewHolder {

        TextView textView;

        public availabiltyholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((onOrderClickListener !=null)){
                        Log.d("TAG", "onClick: "+availabilityArrayList.get(getAdapterPosition()));
                        onOrderClickListener.onOrderClickListener(availabilityArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }


}
