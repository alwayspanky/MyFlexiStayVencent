package com.example.myflexistay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Furnishing_Status;
import com.example.myflexistay.Model.Property_Age;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Furnishing_Status_Adapter extends RecyclerView.Adapter<Furnishing_Status_Adapter.furnishingholder> {

    Context context;
    ArrayList<Furnishing_Status.furnishing_status> furnishing_statusArrayList;

    public Furnishing_Status_Adapter(Context context, ArrayList<Furnishing_Status.furnishing_status> furnishing_statusArrayList) {
        this.context = context;
        this.furnishing_statusArrayList = furnishing_statusArrayList;
    }


    public interface onOrderClickedListener {
        public void onOrderClickedListener(Furnishing_Status.furnishing_status furnishingStatus);
    }
    public Furnishing_Status_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Furnishing_Status_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }


    @NonNull
    @Override
    public furnishingholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);


        return new furnishingholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull furnishingholder holder, int position) {

        Furnishing_Status.furnishing_status furnishing_status = furnishing_statusArrayList.get(position);
        holder.textView.setText(furnishing_status.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onOrderClickedListener != null)){
                    onOrderClickedListener.onOrderClickedListener(furnishing_statusArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return furnishing_statusArrayList.size();
    }

    public class furnishingholder extends RecyclerView.ViewHolder {

        TextView textView;


        public furnishingholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((onOrderClickedListener !=null)){
                        //Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(furnishing_statusArrayList.get(getAdapterPosition()));
                    }
                }
            });

        }
    }
}
