package com.example.sagivo.myapplication;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;


public class OrderFragmentTabs extends FragmentActivity{
    OrderAdapter adapter;
    OrderPager pager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tabs_order);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        adapter = new OrderAdapter(getSupportFragmentManager());
        pager = (OrderPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.pager_title_strip);
        tabsStrip.setViewPager(pager);
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(OrderFragmentTabs.this, "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }

    public class OrderAdapter extends FragmentStatePagerAdapter {
        public OrderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            pager.AllowSwipe = pager.getCurrentItem() != 2;

            switch (position) {
                case 0: return new HomeFragment();
                case 1: return new HomeFragment();
                case 2: return new OrderFragment();
                default: return new OrderFragment();
            }
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

}
