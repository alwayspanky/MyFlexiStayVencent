package com.example.myflexistay.Adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myflexistay.R;

import java.io.IOException;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewHolder> {

    private Context mContext ;
    private ArrayList<Uri> mListPhotos;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<Uri> list) {
        this.mListPhotos = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.upload_image,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.viewHolder holder, int position) {

        Uri uri = mListPhotos.get(position);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(),uri);
            holder.img.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if (mListPhotos == null){
            return 0;
        }else{
            return mListPhotos.size();
        }

    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.upload_img);
        }
    }
}
