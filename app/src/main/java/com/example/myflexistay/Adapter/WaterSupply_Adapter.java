package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Property_Age;
import com.example.myflexistay.Model.WaterSupply;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class WaterSupply_Adapter extends RecyclerView.Adapter<WaterSupply_Adapter.supplyholder> {

    Context context;
    ArrayList<WaterSupply.water_supply> waterSupplyArrayList;


    public WaterSupply_Adapter(Context context, ArrayList<WaterSupply.water_supply> waterSupplyArrayList) {
        this.context = context;
        this.waterSupplyArrayList = waterSupplyArrayList;
    }

    public interface onOrderClickedListener {
        public void onOrderClickedListener(WaterSupply.water_supply waterSupply);
    }
    public WaterSupply_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(WaterSupply_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }

    @NonNull
    @Override
    public supplyholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new supplyholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull supplyholder holder, int position) {
        WaterSupply.water_supply waterSupply = waterSupplyArrayList.get(position);
        holder.textView.setText(waterSupply.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((onOrderClickedListener != null))
                    onOrderClickedListener.onOrderClickedListener(waterSupplyArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return waterSupplyArrayList.size();
    }

    public class supplyholder extends RecyclerView.ViewHolder {

        TextView textView;

        public supplyholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
                        Log.d("TAG", "onClick: "+waterSupplyArrayList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(waterSupplyArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
