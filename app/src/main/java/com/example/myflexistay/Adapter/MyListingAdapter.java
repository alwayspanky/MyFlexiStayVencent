package com.example.myflexistay.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myflexistay.Model.MyListingModel;

import java.util.ArrayList;

public class MyListingAdapter extends RecyclerView.Adapter<MyListingAdapter.viewHolder> {

    Context context;
    ArrayList<MyListingModel.MyListings> myListingModels;

    public MyListingAdapter(Context context, ArrayList<MyListingModel.MyListings> myListingModels) {
        this.context = context;
        this.myListingModels = myListingModels;
    }

    @NonNull
    @Override
    public MyListingAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListingAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
