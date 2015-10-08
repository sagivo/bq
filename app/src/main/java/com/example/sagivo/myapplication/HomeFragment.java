package com.example.sagivo.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home ,container,false);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this.getActivity());
        // repeat many times:
        ImageView itemIcon = new ImageView(this.getActivity());
        itemIcon.setImageDrawable(getResources().getDrawable(R.drawable.cam));
        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();

        ImageView itemIcon2 = new ImageView(this.getActivity());
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.voice));
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("aaa", "clicked!");
            }
        });
        ImageView itemIcon3 = new ImageView(this.getActivity());
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.email));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this.getActivity())
                .addSubActionView(button1)
                .addSubActionView(button3)
                .addSubActionView(button2)
                .attachTo(v.findViewById(R.id.action_fab)).build();

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

