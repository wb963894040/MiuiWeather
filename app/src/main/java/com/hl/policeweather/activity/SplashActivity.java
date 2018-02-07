package com.hl.policeweather.activity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hl.policeweather.R;
import com.hl.policeweather.bean.HourForecastBean;
import com.hl.policeweather.bean.WeatherBean;
import com.hl.policeweather.listener.GyroscopeObserver;
import com.hl.policeweather.net.WeatherService;
import com.hl.policeweather.net.callback.ShowApiStringCallback;
import com.hl.policeweather.receiver.WeatherWidgetProvider;
import com.hl.policeweather.ui.base.BaseActivity;
import com.hl.policeweather.util.DateUtil;
import com.hl.policeweather.util.IntentUtil;
import com.hl.policeweather.util.LogUtil;
import com.hl.policeweather.util.StatusUtil;
import com.hl.policeweather.util.StringUtil;
import com.hl.policeweather.util.WeatherUtil;
import com.hl.policeweather.view.MiuiWeatherView;
import com.hl.policeweather.view.WeatherAnimView;
import com.hl.policeweather.view.WeatherPtrHeader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by 汪彬 on 2017/12/19.
 */
public class SplashActivity extends BaseActivity
{
    
    @BindView(R.id.layout_ptr_fresh)
    PtrFrameLayout mLayoutPtrFrame;
    
    @BindView(R.id.weather)
    WeatherAnimView mViewWeather;
    
    @BindView(R.id.txt_district)
    TextView mDxtDistrict;
    
    @BindView(R.id.txt_cur_temp)
    TextView mTxtCurTemp;
    
    @BindView(R.id.txt_weather)
    TextView mTxtWeather;
    
    @BindView(R.id.txt_quality)
    TextView mTxtQuality;
    
    @BindView(R.id.txt_wind_direct)
    TextView mTxtWindDirect;
    
    @BindView(R.id.txt_wind_level)
    TextView mTxtWindLevel;
    
    @BindView(R.id.txt_humidity)
    TextView mTxtHumidity;
    
    @BindView(R.id.txt_air_press)
    TextView mTxtAirPress;
    
    @BindView(R.id.img_today_weather)
    ImageView mImgTodayWeather;
    
    @BindView(R.id.txt_today_weather)
    TextView mTxtTodayWeather;
    
    @BindView(R.id.txt_today_air_press)
    TextView mTxtTodayAirPress;
    
    @BindView(R.id.txt_today_temp_range)
    TextView mTxtTodayTempRange;
    
    @BindView(R.id.img_tomorrow_weather)
    ImageView mImgTomorrowWeather;
    
    @BindView(R.id.txt_tomorrow_weather)
    TextView mTxtTomorrowWeather;
    
    @BindView(R.id.txt_tomorrow_air_press)
    TextView mTxtTomorrowAirPress;
    
    @BindView(R.id.txt_tomorrow_temp_range)
    TextView mTxtTomorrowTempRange;
    
    @BindView(R.id.txt_after_tomorrow)
    TextView mTxtAfterTomorrow;
    
    @BindView(R.id.img_after_tomorrow_weather)
    ImageView mImgAfterTomorrowWeather;
    
    @BindView(R.id.txt_after_tomorrow_weather)
    TextView mTxtAfterTomorrowWeather;
    
    @BindView(R.id.txt_after_tomorrow_air_press)
    TextView mTxtAfterTomorrowAirPress;
    
    @BindView(R.id.txt_after_tomorrow_temp_range)
    TextView mTxtAfterTomorrowTempRange;
    
    @BindView(R.id.layout_more_forecast)
    LinearLayout mLayoutMoreForecast;
    
    @BindView(R.id.chart_weather_24)
    MiuiWeatherView mChart24HourForecast;
    
    private GyroscopeObserver mGyroscopeObserver;
    
    private boolean mIsDark = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initView();
        mGyroscopeObserver = new GyroscopeObserver();
        mViewWeather.setGyroscopeObserver(mGyroscopeObserver);
        initRefresh();
        getWeather();
    }
    
    private void initRefresh()
    {
        WeatherPtrHeader ptrHeader = new WeatherPtrHeader(this)
        {
            @Override
            public void onUIPositionChange(PtrFrameLayout frame,
                    boolean isUnderTouch, byte status,
                    PtrIndicator ptrIndicator)
            {
                super.onUIPositionChange(frame,
                        isUnderTouch,
                        status,
                        ptrIndicator);
                if (mIsDark != Math.min(ptrIndicator.getCurrentPercent(),
                        1.2f) > 0.2)
                // if ((!mIsDark && cur) || (mIsDark && !cur))
                {
                    mIsDark = !mIsDark;
                    // 测试MIUI
                    StatusUtil.MIUISetStatusBarLightMode(getWindow(), mIsDark);
                }
            }
        };
        mLayoutPtrFrame.setKeepHeaderWhenRefresh(true);
        mLayoutPtrFrame.setHeaderView(ptrHeader);
        mLayoutPtrFrame.addPtrUIHandler(ptrHeader);
        mLayoutPtrFrame.setPtrHandler(new PtrDefaultHandler()
        {
            
            @Override
            public void onRefreshBegin(PtrFrameLayout frame)
            {
                LogUtil.d("onRefreshBegin");
                getWeather();
            }
            
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content,
                    View header)
            {
                return super.checkCanDoRefresh(frame, content, header);
            }
        });
    }
    
    private void initView()
    {
    }
    
    @OnClick(R.id.layout_more_forecast)
    public void startMoreForecast()
    {
        startActivity(new Intent(this, MoreDayForecastActivity.class));
    }
    
    private void updateWidget(String curTemperature, String weather,
            int weatherIconId)
    {
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.weather_widget_layout);
        remoteViews.setTextViewText(R.id.txt_temperature, curTemperature + "°");
        remoteViews.setTextViewText(R.id.txt_desc, weather);
        remoteViews.setImageViewResource(R.id.img_weather, weatherIconId);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                R.id.layout_root,
                IntentUtil.getIntent(this, SplashActivity.class, null),
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.layout_root, pendingIntent);
        ComponentName componentName = new ComponentName(this,
                WeatherWidgetProvider.class);
        AppWidgetManager.getInstance(this).updateAppWidget(componentName,
                remoteViews);
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        mGyroscopeObserver.register(this);
    }
    
    @Override
    protected void onPause()
    {
        super.onPause();
        mGyroscopeObserver.unregister();
    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
    
    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_main;
    }
    
    private void get24HoursForecast(WeatherBean bean)
    {
        WeatherService.get24HoursForecast(
                DateUtil.getCurrentDate("yyyyMMddHHmmss"),
                bean.getAreaId(),
                new ShowApiStringCallback()
                {
                    @Override
                    public void onGetDataSuccess(String data)
                    {
                        super.onGetDataSuccess(data);
                        LogUtil.d(data);
                        mLayoutPtrFrame.refreshComplete();
                        try
                        {
                            List<HourForecastBean> hours = new ArrayList<>();
                            HourForecastBean hourForecastBean;
                            JSONObject hourForecastObj;
                            JSONObject obj = new JSONObject(data);
                            String time;
                            JSONArray hourList = obj.optJSONArray("hourList");
                            if (null != hourList && hourList.length() > 0)
                            {
                                for (int i = 0; i < hourList.length(); i++)
                                {
                                    hourForecastObj = (JSONObject) hourList
                                            .opt(i);
                                    time = hourForecastObj.optString("time");
                                    SimpleDateFormat sdf = new SimpleDateFormat(
                                            "yyyyMMddHHmm");
                                    SimpleDateFormat sdf2 = new SimpleDateFormat(
                                            "HH:mm");
                                    String formatTime = sdf2
                                            .format(sdf.parse(time));
                                    String hour = formatTime.split(":")[0];
                                    hourForecastBean = new HourForecastBean(
                                            hourForecastObj
                                                    .optString("weather"),
                                            hourForecastObj
                                                    .optString("weather_code"),
                                            hourForecastObj
                                                    .optInt("temperature"),
                                            formatTime, Integer.parseInt(hour));
                                    hours.add(hourForecastBean);
                                }
                                mChart24HourForecast.setData(hours);
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        catch (ParseException e)
                        {
                            e.printStackTrace();
                        }
                        catch (NumberFormatException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    
                    @Override
                    public void onGetDataError(String msg)
                    {
                        super.onGetDataError(msg);
                        mLayoutPtrFrame.refreshComplete();
                        Toast.makeText(SplashActivity.this,
                                msg,
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
    
    private void getWeather()
    {
        WeatherService.getWeatherByCoordinate(
                DateUtil.getCurrentDate("yyyyMMddHHmmss"),
                "5",
                "116.2278",
                "40.242266",
                "0",
                "1",
                "0",
                "0",
                "1",
                new ShowApiStringCallback()
                {
                    @Override
                    public void onGetDataSuccess(String data)
                    {
                        super.onGetDataSuccess(data);
                        LogUtil.d(data);
                        // mLayoutPtrFrame.refreshComplete();
                        try
                        {
                            JSONObject object = new JSONObject(data);
                            JSONObject nowData = object.optJSONObject("now");
                            JSONObject cityInfo = object
                                    .optJSONObject("cityInfo");
                            JSONObject f1 = object.optJSONObject("f1");
                            JSONObject f2 = object.optJSONObject("f2");
                            JSONObject f3 = object.optJSONObject("f3");
                            WeatherBean weatherBean = new WeatherBean();
                            weatherBean.setNowAqi(nowData.optString("aqi"));
                            weatherBean.setNowHumidity(nowData.optString("sd"));
                            JSONObject nowDeatil = nowData
                                    .optJSONObject("aqiDetail");
                            if (null != nowDeatil)
                            {
                                weatherBean.setNowQuality(
                                        nowDeatil.optString("quality"));
                            }
                            if (null != cityInfo)
                            {
                                weatherBean.setAreaId(cityInfo.optString("c1"));
                            }
                            weatherBean.setNowTemperature(
                                    nowData.optString("temperature"));
                            weatherBean.setNowWeather(
                                    nowData.optString("weather"));
                            weatherBean.setNowWeatherCode(
                                    nowData.optString("weather_code"));
                            weatherBean.setNowWeatherPic(
                                    nowData.optString("weather_pic"));
                            weatherBean.setNowWindDirection(
                                    nowData.optString("wind_direction"));
                            weatherBean.setNowWindPower(
                                    nowData.optString("wind_power"));
                            if (null != f1)
                            {
                                weatherBean.setDayWeather(
                                        f1.optString("day_weather"));
                                weatherBean.setNightWeather(
                                        f1.optString("night_weather"));
                                weatherBean.setDayWeatherCode(
                                        f1.optString("day_weather_code"));
                                weatherBean
                                        .setAirPress(f1.optString("air_press"));
                                weatherBean.setDayAirTemperature(
                                        f1.optString("day_air_temperature"));
                                weatherBean.setNightAirTemperature(
                                        f1.optString("night_air_temperature"));
                                weatherBean.setDayWeatherPic(
                                        f1.optString("day_weather_pic"));
                                JSONObject indexObj = f1.optJSONObject("index");
                                ArrayList<WeatherBean.LivingIndex> indexList = new ArrayList<WeatherBean.LivingIndex>();
                                if (null != indexObj)
                                {
                                    String[] indexs = { "clothes", "dy",
                                            "travel", "beauty", "xq", "cold",
                                            "mf", "glass" };
                                    WeatherBean.LivingIndex livingIndex;
                                    JSONObject index;
                                    for (int i = 0; i < indexs.length; i++)
                                    {
                                        livingIndex = new WeatherBean.LivingIndex();
                                        livingIndex.setType(indexs[i]);
                                        index = indexObj
                                                .optJSONObject(indexs[i]);
                                        if (null != index)
                                        {
                                            livingIndex.setTitle(
                                                    index.optString("title"));
                                            livingIndex.setDesc(
                                                    index.optString("desc"));
                                            indexList.add(livingIndex);
                                        }
                                    }
                                    weatherBean.setIndexList(indexList);
                                }
                            }
                            if (null != f2)
                            {
                                weatherBean.setTomorrowDayWeather(
                                        f2.optString("day_weather"));
                                weatherBean.setTomorrowNightWeather(
                                        f2.optString("night_weather"));
                                weatherBean.setTomorrowDayWeatherIcon(
                                        f2.optString("day_weather_pic"));
                                weatherBean.setTomorrowPress(
                                        f2.optString("air_press"));
                                weatherBean.setTomorrowDayWeatherCode(
                                        f1.optString("day_weather_code"));
                                weatherBean.setTomorrowDayAirTemp(
                                        f2.optString("day_air_temperature"));
                                weatherBean.setTomorrowNightAirTemp(
                                        f2.optString("night_air_temperature"));
                            }
                            if (null != f3)
                            {
                                weatherBean.setAfterTomorrowDayWeather(
                                        f3.optString("day_weather"));
                                weatherBean.setAfterTomorrowNightWeather(
                                        f3.optString("night_weather"));
                                weatherBean.setAfterTomorrowDayWeatherIcon(
                                        f3.optString("day_weather_pic"));
                                weatherBean.setAfterTomorrowPress(
                                        f3.optString("air_press"));
                                weatherBean.setAfterTomorrowWeatherCode(
                                        f1.optString("day_weather_code"));
                                weatherBean.setAfterTomorrowDayAirTemp(
                                        f3.optString("day_air_temperature"));
                                weatherBean.setAfterTomorrowNightAirTemp(
                                        f3.optString("night_air_temperature"));
                                weatherBean.setAfterTomorrowWeekday(
                                        f3.optString("weekday"));
                            }
                            refreshWeatherData(weatherBean);
                            get24HoursForecast(weatherBean);
                            LogUtil.d(weatherBean.toString());
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    
                    @Override
                    public void onGetDataError(String msg)
                    {
                        super.onGetDataError(msg);
                        mLayoutPtrFrame.refreshComplete();
                        Toast.makeText(SplashActivity.this,
                                msg,
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
    
    private void refreshWeatherData(WeatherBean bean)
    {
        mTxtCurTemp.setText(bean.getNowTemperature());
        mTxtHumidity.setText(bean.getNowHumidity());
        mTxtAirPress.setText(bean.getAirPress());
        mTxtQuality.setText(bean.getNowQuality());
        mTxtWindDirect.setText(bean.getNowWindDirection());
        mTxtWindLevel.setText(bean.getNowWindPower());
        mTxtWeather.setText(bean.getNowWeather());
        Glide.with(this)
                .load(WeatherUtil.getIconResIdGray(bean.getDayWeatherCode()))
                .into(mImgTodayWeather);
        Glide.with(this)
                .load(WeatherUtil
                        .getIconResIdGray(bean.getTomorrowDayWeatherCode()))
                .into(mImgTomorrowWeather);
        Glide.with(this)
                .load(WeatherUtil
                        .getIconResIdGray(bean.getAfterTomorrowWeatherCode()))
                .into(mImgAfterTomorrowWeather);
        String todayWeather = bean.getDayWeather();
        String tomorrowWeather = bean.getTomorrowDayWeather();
        String afterTomorrowWeather = bean.getAfterTomorrowDayWeather();
        mTxtTodayWeather.setText(
                todayWeather.equals(bean.getNightWeather()) ? todayWeather
                        : todayWeather + "转" + bean.getNightWeather());
        mTxtTomorrowWeather
                .setText(tomorrowWeather.equals(bean.getTomorrowNightWeather())
                        ? tomorrowWeather
                        : tomorrowWeather + "转"
                                + bean.getTomorrowNightWeather());
        mTxtAfterTomorrowWeather.setText(
                afterTomorrowWeather.equals(bean.getAfterTomorrowNightWeather())
                        ? afterTomorrowWeather
                        : afterTomorrowWeather + "转"
                                + bean.getAfterTomorrowNightWeather());
        mTxtTodayAirPress.setText(bean.getAirPress());
        mTxtTomorrowAirPress.setText(bean.getTomorrowPress());
        mTxtAfterTomorrowAirPress.setText(bean.getAfterTomorrowPress());
        mTxtAfterTomorrow.setText(
                String.format(getResources().getString(R.string.weekday),
                        StringUtil.getWeekday(bean.getAfterTomorrowWeekday())));
        mTxtTodayTempRange.setText(bean.getDayAirTemperature() + "/"
                + bean.getNightAirTemperature() + "℃");
        mTxtTomorrowTempRange.setText(bean.getTomorrowDayAirTemp() + "/"
                + bean.getTomorrowNightAirTemp() + "℃");
        mTxtAfterTomorrowTempRange.setText(bean.getAfterTomorrowDayAirTemp()
                + "/" + bean.getAfterTomorrowNightAirTemp() + "℃");
    }
}
