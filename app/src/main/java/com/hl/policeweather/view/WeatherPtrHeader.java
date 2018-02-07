package com.hl.policeweather.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hl.policeweather.R;
import com.hl.policeweather.util.LogUtil;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by 汪彬 on 2018/2/5.
 */

public class WeatherPtrHeader extends FrameLayout implements PtrUIHandler
{
    private static final float RATIO_SCALE = 2.5f;
    
    private ImageView mImgRefresh;
    
    private TextView mTxtRefreshTip;
    
    private AnimationDrawable mAnimDrawable;
    
    private Context mContext;
    
    public WeatherPtrHeader(@NonNull Context context)
    {
        super(context);
        init();
        this.mContext = context;
    }
    
    public WeatherPtrHeader(@NonNull Context context,
            @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
        this.mContext = context;
    }
    
    public WeatherPtrHeader(@NonNull Context context,
            @Nullable AttributeSet attrs, @AttrRes int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
        this.mContext = context;
    }
    
    private void init()
    {
        View header = LayoutInflater.from(getContext())
                .inflate(R.layout.refresh_header_layout, this);
        mImgRefresh = (ImageView) header.findViewById(R.id.img_refresh_icon);
        mTxtRefreshTip = (TextView) header.findViewById(R.id.txt_refresh_tip);
        mAnimDrawable = (AnimationDrawable) mImgRefresh.getDrawable();
        mImgRefresh.setScaleX(1 / RATIO_SCALE / 1.2f);
        mImgRefresh.setScaleY(1 / RATIO_SCALE / 1.2f);
    }
    
    @Override
    public void onUIReset(PtrFrameLayout frame)
    {
        LogUtil.d("onUIReset");
    }
    
    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame)
    {
        
    }
    
    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame)
    {
        LogUtil.d("onUIRefreshBegin");
        mAnimDrawable.start();
    }
    
    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame)
    {
        LogUtil.d("onUIRefreshComplete");
        mAnimDrawable.stop();
        mTxtRefreshTip.setText("刷新完成");
    }
    
    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch,
            byte status, PtrIndicator ptrIndicator)
    {
        if (isUnderTouch)
        {
            // LogUtil.d("frame getOffsetToRefresh = " +
            // frame.getOffsetToRefresh()
            // + " , frame getHeaderHeight = " + frame.getHeaderHeight()
            // + " , ptrIndicator getCurrentPercent = "
            // + ptrIndicator.getCurrentPercent()
            // + " , ptrIndicator.getOffsetToRefresh = "
            // + ptrIndicator.getOffsetToRefresh()
            // + " , ptrIndicator getOffsetY = "
            // + ptrIndicator.getOffsetY()
            // + " , ptrIndicator.getCurrentPosY() = "
            // + ptrIndicator.getCurrentPosY());
            float factor = Math.min(ptrIndicator.getCurrentPercent(), 1.2f);
            ViewCompat.setScaleX(mImgRefresh, RATIO_SCALE * factor);
            ViewCompat.setScaleY(mImgRefresh, RATIO_SCALE * factor);
            mTxtRefreshTip.setText(factor < 1.2f ? "下拉刷新" : "释放刷新");
        }
    }
}
