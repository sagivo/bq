package com.example.sagivo.myapplication;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

public class StoreListFragment extends ListFragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stores_list ,container,false);
        StoreAdapter sa = new StoreAdapter(getActivity(), Store.getStores());


        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(menu.getContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
                openItem.setWidth(300);
                openItem.setTitle("Favorite");
                openItem.setIcon(android.R.drawable.star_on);
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);


                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(menu.getContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                deleteItem.setWidth(300);
                deleteItem.setTitle("Call");
                deleteItem.setIcon(android.R.drawable.stat_sys_phone_call);
                menu.addMenuItem(deleteItem);

            }
        };

        SwipeMenuListView listView = (SwipeMenuListView) v.findViewById(16908298);
        Log.w("aaa", listView.toString());
        listView.setMenuCreator(creator);

        setListAdapter(sa);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}