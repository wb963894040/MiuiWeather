package com.hl.policeweather.net;

import com.hl.policeweather.constant.GlobeConstant;
import com.hl.policeweather.net.url.RequestUrl;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import static com.hl.policeweather.constant.GlobeConstant.TAG_GET_WEATHER;

/**
 * Created by 汪彬 on 2017/12/22.
 */
public class WeatherService extends HttpService
{
    
    public static void getWeatherByCoordinate(String timeStamp, String from,
            String lng, String lat, String needMoreDay, String needIndex,
            String needHourData, String need3HourForcast, String needAlarm,
            StringCallback callback)
    {
        OkGo.<String> post(RequestUrl.GET_WEATHER_INFO_BY_COORDINATE)
                .params("showapi_appid", GlobeConstant.APP_ID)
                .params("showapi_sign", GlobeConstant.APP_SIGN)
                .params("showapi_timestamp", timeStamp)
                .params("from", from)
                .params("lng", lng)
                .params("lat", lat)
                .params("needMoreDay", needMoreDay)
                .params("needIndex", needIndex)
                .params("needHourData", needHourData)
                .params("need3HourForcast", need3HourForcast)
                .params("needAlarm", needAlarm)
                .tag(TAG_GET_WEATHER)
                .execute(callback);
    }
    
    public static void get24HoursForecast(String timeStamp, String areaId,
            StringCallback callback)
    {
        OkGo.<String> post(RequestUrl.GET_24_HOUR_FORECAST)
                .params("showapi_appid", GlobeConstant.APP_ID)
                .params("showapi_sign", GlobeConstant.APP_SIGN)
                .params("showapi_timestamp", timeStamp)
                .params("areaid", areaId)
                .tag(TAG_GET_WEATHER)
                .execute(callback);
    }
}
