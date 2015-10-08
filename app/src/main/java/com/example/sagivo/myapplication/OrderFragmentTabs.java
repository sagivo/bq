package com.example.sagivo.myapplication;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.astuetz.PagerSlidingTabStrip;


public class OrderFragmentTabs extends FragmentActivity implements ActionBar.TabListener {
    OrderAdapter adapter;
    ViewPager pager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tabs_order);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        adapter = new OrderAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.pager_title_strip);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(pager);

        //final ActionBar actionBar = getActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //for (int i = 0; i < 3; i++) { actionBar.addTab(actionBar.newTab().setText("Tab " + (i + 1)));}
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.w("aaa", "tba selected!!!!");
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
