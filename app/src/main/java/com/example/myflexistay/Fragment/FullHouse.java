package com.example.myflexistay.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myflexistay.R;


        public class FullHouse extends Fragment {

            // TODO: Rename parameter arguments, choose names that match
            // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
            private static final String ARG_PARAM1 = "param1";
            private static final String ARG_PARAM2 = "param2";

            // TODO: Rename and change types of parameters
            private String mParam1;
            private String mParam2;

            public FullHouse() {
                // Required empty public constructor
            }



            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                return inflater.inflate(R.layout.fragment_full_house, container, false);

            }
        }


