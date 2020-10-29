package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Apartment_Type;
import com.example.myflexistay.Model.Facing;
import com.example.myflexistay.R;

import java.util.ArrayList;
import java.util.List;

public class Facing_Adapter extends RecyclerView.Adapter<Facing_Adapter.facingholder> {


    Context context;
    ArrayList<Facing.facing> facingArrayList;
    public Facing_Adapter(Context context, ArrayList<Facing.facing> facingList) {
        this.context = context;
        this.facingArrayList = facingList;
    }

    public interface onOrderClickedListener {
        public void onOrderClickedListener(Facing.facing facing);
    }
    public Facing_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Facing_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }


    @NonNull
    @Override
    public facingholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new facingholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull facingholder holder, final int position) {

        Facing.facing facing = facingArrayList.get(position);
        holder.textView.setText(facing.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((onOrderClickedListener != null)){
                    onOrderClickedListener.onOrderClickedListener(facingArrayList.get(position));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return facingArrayList.size();
    }

    public class facingholder extends RecyclerView.ViewHolder {

        TextView textView;

        public facingholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
                        Log.d("TAG", "onClick: "+facingArrayList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(facingArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
