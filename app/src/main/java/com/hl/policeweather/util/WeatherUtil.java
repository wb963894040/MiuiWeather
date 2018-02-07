package com.hl.policeweather.util;

import com.hl.policeweather.R;

/**
 * Created by 汪彬 on 2018/2/7.
 */

public class WeatherUtil
{
    private static final String[] RAIN_ARRAY = { "01", "07", "301", "08", "21",
            "09", "10", "11", "22", "23", "24", "25" };
    
    private static final String[] SNOW_ARRAY = { "13", "14", "302", "15", "26",
            "16", "17", "27", "28" };
    
    public static final String SUN = "晴";
    
    public static final String SUN_NIGHT = "晴夜";
    
    public static final String CLOUDY = "多云";
    
    public static final String CLOUDY_NIGHT = "多云夜";
    
    public static final String OVERCAST = "阴";
    
    public static final String SNOW = "雪";
    
    public static final String RAIN = "雨";
    
    public static final String FOGGY = "雾";
    
    public static final String THUNDER = "雷";
    
    public static final String PM_DIRT = "霾";
    
    public static final String ICE_RAIN = "冻雨";
    
    public static final String RAIN_SNOW = "雨夹雪";
    
    public static final String SANDY = "沙尘暴";
    
    // 多云 = 多云 01
    // 多云晚
    // 雾 = 雾 18
    // 小雨 = 小雨 雨 阵雨 03 07 301
    // 中雨 = 中雨 小到中雨 08 21
    // 大雨 = 大雨 特大暴雨 大暴雨 暴雨 中到大雨 大到暴雨 暴雨到大暴雨 大暴雨到特大暴雨 09 10 11 22 23 24 25
    // 冻雨 = 冻雨 19
    // 大雪 = 大雪 中到大雪 大到暴雪 暴雪 16 17 27 28
    // 中雪 = 中雪 小到中雪 15 26
    // 小雪 = 阵雪 小雪 雪 13 14 302
    // 阴天 = 阴 02
    // 霾 = 霾 浮尘 29 53
    // 雨夹雪 = 雨夹雪 06
    // 沙尘暴 = 扬沙 强沙尘暴 沙尘暴 20 30 31
    // 晴 = 晴 00
    // 晴晚
    // 雷阵雨 = 雷阵雨 雷阵雨伴有冰雹 04 05
    public static String getWeather(String weatherCode, int hour)
    {
        return weatherCode.equals("00")
                ? (hour >= 5 && hour < 20 ? SUN : SUN_NIGHT)
                : weatherCode.equals("01")
                        ? (hour >= 5 && hour < 20 ? CLOUDY : CLOUDY_NIGHT)
                        : weatherCode.equals("02") ? OVERCAST
                                : isSnow(weatherCode) ? SNOW
                                        : isRain(weatherCode) ? RAIN
                                                : weatherCode.equals("18")
                                                        ? FOGGY
                                                        : weatherCode
                                                                .equals("04")
                                                                || weatherCode
                                                                        .equals("05")
                                                                                ? THUNDER
                                                                                : weatherCode
                                                                                        .equals("53")
                                                                                        || weatherCode
                                                                                                .equals("29")
                                                                                                        ? PM_DIRT
                                                                                                        : weatherCode
                                                                                                                .equals("19")
                                                                                                                        ? ICE_RAIN
                                                                                                                        : weatherCode
                                                                                                                                .equals("06")
                                                                                                                                        ? RAIN_SNOW
                                                                                                                                        : weatherCode
                                                                                                                                                .equals("20")
                                                                                                                                                || weatherCode
                                                                                                                                                        .equals("30")
                                                                                                                                                || weatherCode
                                                                                                                                                        .equals("31")
                                                                                                                                                                ? SANDY
                                                                                                                                                                : CLOUDY;
    }
    
    public static String getWeather(String weatherCode)
    {
        return weatherCode.equals("00") ? SUN
                : weatherCode.equals("01") ? CLOUDY
                        : weatherCode.equals("02") ? OVERCAST
                                : isSnow(weatherCode) ? SNOW
                                        : isRain(weatherCode) ? RAIN
                                                : weatherCode.equals("18")
                                                        ? FOGGY
                                                        : weatherCode
                                                                .equals("04")
                                                                || weatherCode
                                                                        .equals("05")
                                                                                ? THUNDER
                                                                                : weatherCode
                                                                                        .equals("53")
                                                                                        || weatherCode
                                                                                                .equals("29")
                                                                                                        ? PM_DIRT
                                                                                                        : weatherCode
                                                                                                                .equals("19")
                                                                                                                        ? ICE_RAIN
                                                                                                                        : weatherCode
                                                                                                                                .equals("06")
                                                                                                                                        ? RAIN_SNOW
                                                                                                                                        : weatherCode
                                                                                                                                                .equals("20")
                                                                                                                                                || weatherCode
                                                                                                                                                        .equals("30")
                                                                                                                                                || weatherCode
                                                                                                                                                        .equals("31")
                                                                                                                                                                ? SANDY
                                                                                                                                                                : CLOUDY;
    }
    
    public static int getIconResIdColorful(String weather)
    {
        int resId;
        switch (weather)
        {
            case RAIN_SNOW:
                resId = R.mipmap.icon_rain_snow;
                break;
            case RAIN:
                resId = R.mipmap.icon_moderate_rain;
                break;
            case CLOUDY:
                resId = R.mipmap.icon_cloudy;
                break;
            case OVERCAST:
                resId = R.mipmap.icon_overcast;
                break;
            case SNOW:
                resId = R.mipmap.icon_moderate_snow;
                break;
            case FOGGY:
                resId = R.mipmap.icon_fog;
                break;
            case THUNDER:
                resId = R.mipmap.icon_t_storm;
                break;
            case PM_DIRT:
                resId = R.mipmap.icon_pm_dirt;
                break;
            case ICE_RAIN:
                resId = R.mipmap.icon_ice_rain;
                break;
            case SANDY:
                resId = R.mipmap.icon_sand;
                break;
            case SUN_NIGHT:
                resId = R.mipmap.icon_sunny_night;
                break;
            case CLOUDY_NIGHT:
                resId = R.mipmap.icon_cloudy_night;
                break;
            case SUN:
            default:
                resId = R.mipmap.icon_sunny;
                break;
        }
        return resId;
    }
    
    private static boolean isRain(String weatherCode)
    {
        int length = RAIN_ARRAY.length;
        for (int i = 0; i < length; i++)
        {
            if (RAIN_ARRAY[i].equals(weatherCode))
            {
                return true;
            }
        }
        return false;
    }
    
    public static int getIconResIdGray(String weatherCode)
    {
        String weather = getWeather(weatherCode);
        int resId;
        switch (weather)
        {
            case RAIN_SNOW:
                resId = R.mipmap.daily_forecast_rain_snow;
                break;
            case RAIN:
                resId = R.mipmap.daily_forecast_moderate_rain;
                break;
            case CLOUDY:
                resId = R.mipmap.daily_forecast_cloudy;
                break;
            case OVERCAST:
                resId = R.mipmap.daily_forecast_overcast;
                break;
            case SNOW:
                resId = R.mipmap.daily_forecast_moderate_snow;
                break;
            case FOGGY:
                resId = R.mipmap.daily_forecast_foggy;
                break;
            case THUNDER:
                resId = R.mipmap.daily_forecast_t_storm;
                break;
            case PM_DIRT:
                resId = R.mipmap.daily_forecast_pm_dirt;
                break;
            case ICE_RAIN:
                resId = R.mipmap.daily_forecast_ice_rain;
                break;
            case SANDY:
                resId = R.mipmap.daily_forecast_sandy;
                break;
            case SUN:
            default:
                resId = R.mipmap.icon_sunny;
                break;
        }
        return resId;
    }
    
    private static boolean isSnow(String weatherCode)
    {
        int length = SNOW_ARRAY.length;
        for (int i = 0; i < length; i++)
        {
            if (SNOW_ARRAY[i].equals(weatherCode))
            {
                return true;
            }
        }
        return false;
    }
}
