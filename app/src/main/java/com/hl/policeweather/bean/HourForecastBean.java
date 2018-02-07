package com.hl.policeweather.bean;

import com.hl.policeweather.util.WeatherUtil;

import static com.hl.policeweather.util.WeatherUtil.CLOUDY;
import static com.hl.policeweather.util.WeatherUtil.CLOUDY_NIGHT;
import static com.hl.policeweather.util.WeatherUtil.FOGGY;
import static com.hl.policeweather.util.WeatherUtil.ICE_RAIN;
import static com.hl.policeweather.util.WeatherUtil.OVERCAST;
import static com.hl.policeweather.util.WeatherUtil.PM_DIRT;
import static com.hl.policeweather.util.WeatherUtil.RAIN;
import static com.hl.policeweather.util.WeatherUtil.RAIN_SNOW;
import static com.hl.policeweather.util.WeatherUtil.SANDY;
import static com.hl.policeweather.util.WeatherUtil.SNOW;
import static com.hl.policeweather.util.WeatherUtil.SUN;
import static com.hl.policeweather.util.WeatherUtil.SUN_NIGHT;
import static com.hl.policeweather.util.WeatherUtil.THUNDER;

/**
 * Created by 汪彬 on 2018/2/6.
 */

public class HourForecastBean
{
    
    /**
     * 天气描述
     */
    public String weather;
    
    /**
     * 气温
     */
    public int temperature;
    
    /**
     * 温度的描述值
     */
    public String temperatureStr;
    
    /**
     * 时间点
     */
    public String time;
    
    public HourForecastBean(String weather, int temperature, String time)
    {
        this.weather = weather;
        this.temperature = temperature;
        this.time = time;
        this.temperatureStr = temperature + "℃";
    }
    
    public HourForecastBean(String weather, String weatherCode, int temperature,
            String time, int hour)
    {
        this.weather = WeatherUtil.getWeather(weatherCode, hour);
        this.temperature = temperature;
        this.temperatureStr = temperature + "℃";
        this.time = time;
    }
    
    public static String[] getAllWeathers()
    {
        String[] str = { SUN, SUN_NIGHT, CLOUDY_NIGHT, RAIN, CLOUDY, OVERCAST,
                SNOW, FOGGY, THUNDER, PM_DIRT, ICE_RAIN, SANDY, RAIN_SNOW };
        return str;
    }
    
}
