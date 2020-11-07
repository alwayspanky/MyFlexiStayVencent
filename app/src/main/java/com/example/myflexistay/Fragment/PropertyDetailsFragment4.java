package com.example.myflexistay.Fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myflexistay.Adapter.ImageAdapter;

import java.util.ArrayList;

import com.example.myflexistay.Api.ApiClient;
import com.example.myflexistay.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PropertyDetailsFragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropertyDetailsFragment4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PropertyDetailsFragment4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropertyDetailsFragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static PropertyDetailsFragment4 newInstance(String param1, String param2) {
        PropertyDetailsFragment4 fragment = new PropertyDetailsFragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private static final int CHOOSE_IMAGE = 101 ;
    Button uploadImage;
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    ArrayList<Uri> Images = new ArrayList<>();
    LinearLayout imagelayout;
    ApiClient apiClient;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_property_details4, container, false);
        // Inflate the layout for this fragment

        uploadImage = v.findViewById(R.id.upload_btn);
        Button pro4 = v.findViewById(R.id.fragment_button4);
        recyclerView = v.findViewById(R.id.image_recycler);
        imagelayout = v.findViewById(R.id.image_layout);
        apiClient = new ApiClient();


        pro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<Images.size();i++){

                    JsonObject data = new JsonObject();

                    String img = Images.toString();

                    data.addProperty("s_token","WbZXwXhw1E69a3pOQtyvN72WvNAOuOtXaAByIcGUwztTLa9GNFlMlPMt64aoIaVQ");
                    data.addProperty("listing_id","1");
                    data.addProperty("media_url","");
                    data.addProperty("s_desciption","Balcony 2");

                    apiClient.apiInterface.postAddMedia(data).enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if (response.isSuccessful()){

                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {

                        }
                    });
                }


                PropertyDetailsFragment5 fragment5 = new PropertyDetailsFragment5();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, fragment5);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        //Upload image view



        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageChooser();
            }
        });

        return v;
    }

    private void showImageChooser(){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Photo"), CHOOSE_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {

           // Uri img = data.getData();

            if (data.getClipData() != null) {
                ClipData mClipData = data.getClipData();
                for (int i = 0; i < mClipData.getItemCount(); i++) {
                    ClipData.Item item = mClipData.getItemAt(i);
                    Uri imageUri = item.getUri();
                    Images.add(imageUri);
                }
            } else if (data.getData() != null) {
                Uri imageUri = data.getData();
                Images.add(imageUri);
            }

            imageAdapter = new ImageAdapter(getActivity());
            imageAdapter.setData(Images);
            Log.d("photo", String.valueOf(Images));
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setFocusable(false);
            recyclerView.setAdapter(imageAdapter);
            imagelayout.setVisibility(View.VISIBLE);


        }
    }
}