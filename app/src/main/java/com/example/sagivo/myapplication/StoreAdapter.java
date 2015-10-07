package com.example.sagivo.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

class StoreAdapter extends ArrayAdapter<Store>{
    Store[] stores;

    public StoreAdapter(Context context, Store[] stores) {
        super(context, R.layout.store_item, stores);
        this.stores = stores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(getContext());
        View v = i.inflate(R.layout.store_item, parent, false);

        Store s = stores[position];
        ImageView pic = (ImageView) v.findViewById(R.id.store_picture);
        pic.setImageResource(v.getResources().getIdentifier(s.image, "drawable", "com.example.sagivo.myapplication"));
        TextView store_name = (TextView) v.findViewById(R.id.store_name);
        store_name.setText(s.name);
        Random rnd = new Random();
        store_name.setBackground(new ColorDrawable(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))));

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), R.anim.image_alpha);
        pic.startAnimation(myFadeInAnimation);

        return v;
    }

    @Override
    public int getViewTypeCount() {
        // menu type count
        return stores.length;
    }

    @Override
    public int getItemViewType(int position) {
        // current menu type
        return position;
    }
}
