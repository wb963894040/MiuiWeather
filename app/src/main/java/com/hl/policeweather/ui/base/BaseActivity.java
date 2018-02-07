package com.hl.policeweather.ui.base;

import com.hl.policeweather.util.LogUtil;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by 汪彬 on 2017/12/22.
 */
public abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        LogUtil.d(BaseActivity.class.getSimpleName() + " , onCreate...");
    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        LogUtil.d(BaseActivity.class.getSimpleName() + " , onDestroy...");
    }
    
    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    
    protected void showLoadingView(String tip, boolean cancellable)
    {
    }
    
    protected void dismissLoadingView()
    {
    }
    
    protected abstract int getLayoutId();
}
