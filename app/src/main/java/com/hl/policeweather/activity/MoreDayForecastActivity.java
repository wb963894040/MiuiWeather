package com.hl.policeweather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.hl.policeweather.R;
import com.hl.policeweather.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 汪彬 on 2018/2/7.
 */

public class MoreDayForecastActivity extends BaseActivity
{
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
    @OnClick(R.id.img_close)
    public void close()
    {
        finish();
    }
    
    @Override
    protected int getLayoutId()
    {
        return R.layout.more_day_forecast_layout;
    }
}
