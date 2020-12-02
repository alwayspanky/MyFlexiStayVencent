package com.example.myflexistay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myflexistay.Model.Profile;
import com.example.myflexistay.R;

import java.util.ArrayList;

public class Profile_Adapter extends RecyclerView.Adapter<Profile_Adapter.profileholder> {

    Context context;
    ArrayList<Profile.Profile_screen> profileScreenArrayList;

    public Profile_Adapter(Context context, ArrayList<Profile.Profile_screen> profileScreenArrayList) {
        this.context = context;
        this.profileScreenArrayList = profileScreenArrayList;
    }

    @NonNull
    @Override
    public profileholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_profile, parent,false);
        return new profileholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull profileholder holder, int position) {


        Profile.Profile_screen profile = profileScreenArrayList.get(position);
        holder.textView.setText((CharSequence) profile.getFirst_name());

        Glide.with(context).load(profile.getProfile_image())
                .into(holder.profile_image);
    }

    @Override
    public int getItemCount() {
        return profileScreenArrayList.size();
    }

    public class profileholder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView profile_image;
        public profileholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_name);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }
}
