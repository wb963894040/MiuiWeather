package com.hl.policeweather.ui;

import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.hl.policeweather.R;
import com.hl.policeweather.activity.SplashActivity;
import com.hl.policeweather.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 汪彬 on 2017/12/21.
 */

public class WidgetActivity extends BaseActivity
{
    @BindView(R.id.img_wallpaper)
    ImageView mImgWallpaper;
    
    private int mWidgetId;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initData();
    }
    
    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_widget_config_layout;
    }
    
    @Override
    protected void onStart()
    {
        super.onStart();
        Drawable drawable = WallpaperManager.getInstance(this).getDrawable();
        if (null != drawable)
        {
            mImgWallpaper.setImageDrawable(drawable);
        }
        else
        {
            // mImgWallpaper.setBackground(new ColorDrawable(getResources()
            // .getColor(R.color.blank_30_percent, getTheme())));
        }
    }
    
    private void initData()
    {
        Bundle extras = getIntent().getExtras();
        if (null != extras)
        {
            mWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
    }
    
    @OnClick(R.id.btn_apply)
    public void Apply()
    {
        updateWidget();
        close();
    }
    
    @Override
    public void onBackPressed()
    {
        updateWidget();
        close();
    }
    
    private void close()
    {
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();
    }
    
    private void updateWidget()
    {
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.weather_widget_layout);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                R.id.layout_root,
                new Intent(this, SplashActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.layout_root, pendingIntent);
        AppWidgetManager.getInstance(this).updateAppWidget(mWidgetId,
                remoteViews);
    }
}
