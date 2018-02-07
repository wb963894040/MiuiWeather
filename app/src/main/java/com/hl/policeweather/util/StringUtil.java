package com.hl.policeweather.util;

import com.hl.policeweather.R;

/**
 * Created by 汪彬 on 2018/1/8.
 */

public class StringUtil
{
    
    public static String getWeather(int type)
    {
        return type == 1 ? "晴"
                : type == 2 ? "阴" : type == 3 ? "雨" : type == 4 ? "多云" : "雪";
    }
    
    public static int getWeatherIcon(int type)
    {
        return type == 1 ? R.mipmap.icon_sunny
                : type == 2 ? R.mipmap.icon_cloudy
                        : type == 3 ? R.mipmap.icon_moderate_rain
                                : type == 4 ? R.mipmap.icon_cloudy
                                        : R.mipmap.icon_moderate_snow;
    }
    
    public static String getWeekday(String week)
    {
        return week.equals("1") ? "一"
                : week.equals("2") ? "二"
                        : week.equals("3") ? "三"
                                : week.equals("4") ? "四"
                                        : week.equals("5") ? "五"
                                                : week.equals("6") ? "六"
                                                        : week.equals("7") ? "日"
                                                                : week;
    }
}
