package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Parking;
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

public class Parking_Adapter extends RecyclerView.Adapter<Parking_Adapter.parkingholder> {

    Context context;
    ArrayList<Parking.parking> parkingArrayList;
    public Parking_Adapter(Context context, ArrayList<Parking.parking> parkingList) {
        this.context = context;
        this.parkingArrayList = parkingList;
    }

    public interface onOrderClickedListener {
        public void onOrderClickedListener(Parking.parking parking);
    }
    public Parking_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Parking_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }


    @NonNull
    @Override
    public parkingholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new parkingholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull parkingholder holder, final int position) {

        Parking.parking parking1 = parkingArrayList.get(position);
        holder.textView.setText(parking1.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onOrderClickedListener !=null)){
                    // Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(position));
                    onOrderClickedListener.onOrderClickedListener(parkingArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return parkingArrayList.size();
    }

    public class parkingholder extends RecyclerView.ViewHolder {

        TextView textView;

        public parkingholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
                        Log.d("TAG", "onClick: "+parkingArrayList.get(getAdapterPosition()));
//                        onOrderClickedListener.onOrderClickedListener(parkingList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(parkingArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
