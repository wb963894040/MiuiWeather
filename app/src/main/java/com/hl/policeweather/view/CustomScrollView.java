package com.hl.policeweather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by 汪彬 on 2018/2/6.
 */

public class CustomScrollView extends ScrollView
{
    private GestureDetector mGestureDetector;
    
    public CustomScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(0);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return super.onInterceptTouchEvent(ev)
                && mGestureDetector.onTouchEvent(ev);
    }
    
    // Return false if we're scrolling in the x direction
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                float distanceY)
        {
            if (Math.abs(distanceY) > Math.abs(distanceX)
                    && (Math.abs(distanceY) > 150 && Math.abs(distanceX) < 100))
            {
                return true;
            }
            return false;
        }
    }
}