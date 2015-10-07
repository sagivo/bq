package com.example.sagivo.myapplication;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
                openItem.setBackground(new ColorDrawable(Color.parseColor("#8D93FD")));
                openItem.setWidth(300);
                openItem.setTitle("Chat");
                openItem.setIcon(android.R.drawable.stat_notify_chat);
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);


                // create "delete" item
                SwipeMenuItem mapItem = new SwipeMenuItem(menu.getContext());
                mapItem.setBackground(new ColorDrawable(Color.parseColor("#EF5929")));
                mapItem.setWidth(300);
                mapItem.setTitle("Map");
                mapItem.setTitleColor(Color.WHITE);
                mapItem.setTitleSize(18);
                mapItem.setIcon(android.R.drawable.ic_dialog_map);
                menu.addMenuItem(mapItem);

                SwipeMenuItem deleteItem = new SwipeMenuItem(menu.getContext());
                deleteItem.setBackground(new ColorDrawable(Color.parseColor("#EDD54B")));
                deleteItem.setWidth(300);
                deleteItem.setTitle("Call");
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setTitleSize(18);
                deleteItem.setIcon(android.R.drawable.stat_sys_phone_call);
                menu.addMenuItem(deleteItem);

            }
        };

        SwipeMenuListView listView = (SwipeMenuListView) v.findViewWithTag("foo_list");
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String uri = "tel:+14153514444" ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);

                return false;
            }
        });

        setListAdapter(sa);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}