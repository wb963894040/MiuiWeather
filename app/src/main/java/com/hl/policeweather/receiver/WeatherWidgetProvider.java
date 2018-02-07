package com.hl.policeweather.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.hl.policeweather.R;
import com.hl.policeweather.activity.SplashActivity;
import com.hl.policeweather.net.WeatherService;
import com.hl.policeweather.net.callback.ShowApiStringCallback;
import com.hl.policeweather.util.DateUtil;
import com.hl.policeweather.util.LogUtil;
import com.hl.policeweather.util.StringUtil;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 汪彬 on 2017/12/19.
 */
public class WeatherWidgetProvider extends AppWidgetProvider
{
    @Override
    public void onUpdate(final Context context,
            final AppWidgetManager appWidgetManager, final int[] appWidgetIds)
    {
        LogUtil.d("onUpdate");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        getWeather(context, appWidgetManager, appWidgetIds);
    }
    
    @Override
    public void onEnabled(Context context)
    {
        super.onEnabled(context);
        LogUtil.d("onEnabled");
    }
    
    @Override
    public void onDisabled(Context context)
    {
        super.onDisabled(context);
        LogUtil.d("onDisabled");
    }
    
    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
        LogUtil.d("onDeleted");
    }
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        LogUtil.d("onReceive ,action = " + intent.getAction());
    }
    
    @Override
    public void onAppWidgetOptionsChanged(Context context,
            AppWidgetManager appWidgetManager, int appWidgetId,
            Bundle newOptions)
    {
        super.onAppWidgetOptionsChanged(context,
                appWidgetManager,
                appWidgetId,
                newOptions);
        LogUtil.d("onAppWidgetOptionsChanged, appWidgetId = " + appWidgetId);
        getWeather(context, appWidgetManager, new int[] { appWidgetId });
    }
    
    private void getWeather(final Context context,
            final AppWidgetManager appWidgetManager, final int[] appWidgetIds)
    {
        WeatherService.getWeatherByCoordinate(
                DateUtil.getCurrentDate("yyyyMMddHHmmss"),
                "5",
                "116.2278",
                "40.242266",
                "0",
                "0",
                "0",
                "0",
                "1",
                new ShowApiStringCallback()
                {
                    @Override
                    public void onGetDataSuccess(String data)
                    {
                        super.onGetDataSuccess(data);
                    }
                    
                    @Override
                    public void onSuccess(Response<String> response)
                    {
                        LogUtil.d("getWeather  onSuccess resp = "
                                + response.body());
                        try
                        {
                            JSONObject object = new JSONObject(response.body());
                            if (object.optInt("status") == 0)
                            {
                                String temp = object.optString("temp");
                                int tempId = object.optInt("picid", -1);
                                updateWidget(context,
                                        appWidgetManager,
                                        appWidgetIds,
                                        temp,
                                        StringUtil.getWeather(tempId),
                                        StringUtil.getWeatherIcon(tempId));
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    
                    @Override
                    public void onError(Response<String> response)
                    {
                        super.onError(response);
                        LogUtil.e("onError , resp = " + response.body());
                    }
                });
    }
    
    private void updateWidget(Context context,
            AppWidgetManager appWidgetManager, int[] appWidgetIds,
            String curTemperature, String weather, int weatherIconId)
    {
        LogUtil.d("updateWidget , curTemperature = " + curTemperature
                + " , weather = " + weather + " , id = " + appWidgetIds[0]);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.weather_widget_layout);
        remoteViews.setTextViewText(R.id.txt_temperature, curTemperature + "°");
        remoteViews.setTextViewText(R.id.txt_desc, weather);
        remoteViews.setImageViewResource(R.id.img_weather, weatherIconId);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                R.id.layout_root,
                new Intent(context, SplashActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.layout_root, pendingIntent);
        for (int appWidgetId : appWidgetIds)
        {
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }
}
