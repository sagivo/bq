package com.example.sagivo.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class OrderPager extends ViewPager {
    public static boolean AllowSwipe = true;

    public OrderPager(Context context) {
        super(context);
    }

    public OrderPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (AllowSwipe) return super.onInterceptTouchEvent(event);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (AllowSwipe) return super.onTouchEvent(event);
        return false;
    }
}
