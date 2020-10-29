package com.example.myflexistay.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.Tenant;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Tenant_Adapter extends RecyclerView.Adapter<Tenant_Adapter.preferredholder> {
    Context context;
    ArrayList<Tenant.Tenanttypes> tenanttypesArrayList;

    public Tenant_Adapter(Context context, ArrayList<Tenant.Tenanttypes> tenanttypes) {
        this.context = context;
        this.tenanttypesArrayList = tenanttypes;
    }

    public interface onOrderClickedListener {
        public void onOrderClickedListener(Tenant.Tenanttypes tenanttypes);
    }
    public Tenant_Adapter.onOrderClickedListener onOrderClickedListener;
    public void setOnOrderClickedListener(Tenant_Adapter.onOrderClickedListener onOrderClickedListener1){
        this.onOrderClickedListener = onOrderClickedListener1;
    }

    @NonNull
    @Override
    public preferredholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycler, parent,false);

        return new preferredholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull preferredholder holder, final int position) {

        Tenant.Tenanttypes preferredDetail = tenanttypesArrayList.get(position);
        holder.textView.setText(preferredDetail.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((onOrderClickedListener !=null)){
                    // Log.d("TAG", "onClick: "+apartmentTypesArrayList.get(position));
                    onOrderClickedListener.onOrderClickedListener(tenanttypesArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tenanttypesArrayList.size();
    }

    public class preferredholder extends RecyclerView.ViewHolder {
        TextView textView;

        public preferredholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.apartment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "onClick: ");
                    if ((onOrderClickedListener !=null)){
                        Log.d("TAG", "onClick: "+tenanttypesArrayList.get(getAdapterPosition()));
                        onOrderClickedListener.onOrderClickedListener(tenanttypesArrayList.get(getAdapterPosition()));
                    }
                }
            });

        }
    }
}
