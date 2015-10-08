package com.example.sagivo.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sagivo on 10/8/15.
 */
public class OrderAdapter extends FragmentStatePagerAdapter {
    public OrderAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "MAIN";
            case 1:
                return "SIDE";
            case 2:
                return "DRINK";
            default:
                return "OTHERS";

        }
    }
}
