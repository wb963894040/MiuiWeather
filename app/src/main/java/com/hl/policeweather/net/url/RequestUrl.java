package com.hl.policeweather.net.url;

/**
 * Created by 汪彬 on 2017/12/22.
 */

public class RequestUrl
{
    /**
     * 正式地址
     */
    public static final String SERVER_URL = "http://route.showapi.com/";
    
    /**
     * 根据经纬度获取天气
     */
    public static final String METHOD_GET_WEATHER_BY_COORDINATE = "9-5";
    
    /**
     * 未来24小时预报
     */
    public static final String METHOD_GET_24_HOUR_FORECAST = "9-8";
    
    /**
     * 根据地区或地区ID获取天气
     */
    public static final String METHOD_GET_BY_DISTRICT = "9-9";
    
    /**
     * 根据地区或地区ID获取天气
     */
    public static final String METHOD_GET_ID_BY_DISTRICT = "9-3";
    
    /**
     * 经纬度获取天气接口
     */
    public static final String GET_WEATHER_INFO_BY_COORDINATE = SERVER_URL
            + METHOD_GET_WEATHER_BY_COORDINATE;
    
    /**
     * 未来24小时预报
     */
    public static final String GET_24_HOUR_FORECAST = SERVER_URL
            + METHOD_GET_24_HOUR_FORECAST;
    
    /**
     * 根据地区或地区ID获取天气
     */
    public static final String GET_WEATHER_BY_DISTRICT = SERVER_URL
            + METHOD_GET_BY_DISTRICT;
    
    /**
     * 根据地区获取地区ID
     */
    public static final String GET_ID_BY_DISTRICT = SERVER_URL
            + METHOD_GET_ID_BY_DISTRICT;
}
