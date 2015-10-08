package com.example.sagivo.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home ,container,false);
        return v;
    }

    public static HomeFragment newInstance(int page) {
        //Bundle args = new Bundle();
        //args.putInt(ARG_PAGE, page);
        HomeFragment fragment = new HomeFragment();
        //fragment.setArguments(args);
        return fragment;
    }

}

