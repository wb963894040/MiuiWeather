package com.hl.policeweather.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 汪彬 on 2018/2/5.
 */

// "showapi_res_code": 0,
// "showapi_res_error": "",
// "showapi_res_body": {
// "ret_code": 0,
// "time": "20180205073000",
// "cityInfo": {
// "c6": "beijing",
// "c5": "北京",
// "c4": "beijing",
// "c3": "昌平",
// "c9": "中国",
// "c8": "china",
// "c7": "北京",
// "c17": "+8",
// "c16": "AZ9010",
// "c1": "101010700",
// "c2": "changping",
// "c11": "010",
// "longitude": 116.165,
// "latitude": 40.206,
// "c10": "3",
// "c12": "102200",
// "c15": "80"
// },
// "now": {
// "weather_code": "00",
// "aqiDetail": {
// "num": "12",
// "co": "0.383",
// "area": "北京",
// "so2": "3",
// "o3": "65",
// "no2": "14",
// "aqi": "30",
// "quality": "优质",
// "pm10": "16",
// "pm2_5": "8",
// "o3_8h": "59",
// "primary_pollutant": ""
// },
// "wind_direction": "西北风",
// "temperature_time": "11:30",
// "wind_power": "3级",
// "aqi": "30",
// "sd": "17%",
// "weather_pic": "http://app1.showapi.com/weather/icon/day/00.png",
// "weather": "晴",
// "temperature": "-3"
// },
// "f1": {
// "day_weather": "晴",
// "night_weather": "晴",
// "night_weather_code": "00",
// "index": {
// "yh": {
// "title": "较适宜",
// "desc": "天气较好，适宜约会"
// },
// "ls": {
// "title": "较适宜",
// "desc": "请在室外通风的地方晾晒。"
// },
// "clothes": {
// "title": "冷",
// "desc": "建议着棉衣加羊毛衫等冬季服装"
// },
// "dy": {
// "title": "较适宜",
// "desc": "气象条件对钓鱼影响不大。"
// },
// "sports": {
// "title": "较适宜",
// "desc": "推荐您进行室内运动。"
// },
// "travel": {
// "title": "较适宜",
// "desc": "较弱降水和微风将伴您共赴旅程。"
// },
// "beauty": {
// "title": "保湿",
// "desc": "请选用中性保湿型霜类化妆品。"
// },
// "xq": {
// "title": "较好",
// "desc": "暖阳万丈，温度舒适，会觉得精神振奋。"
// },
// "hc": {
// "title": "适宜",
// "desc": "天气较好，适宜划船及嬉玩水上运动。"
// },
// "zs": {
// "title": "不容易中暑",
// "desc": "气温不高，中暑几率极低。"
// },
// "cold": {
// "title": "较易发",
// "desc": "天较凉，增加衣服，注意防护"
// },
// "gj": {
// "title": "适宜",
// "desc": "这种好天气去逛街可使身心畅快放松。"
// },
// "uv": {
// "title": "弱",
// "desc": "辐射较弱，涂擦SPF12-15、PA+护肤品"
// },
// "comfort": {
// "title": "较好",
// "desc": "普遍感觉舒适"
// },
// "cl": {
// "title": "较适宜",
// "desc": "推荐您进行室内运动。"
// },
// "wash_car": {
// "title": "较适宜",
// "desc": "无雨且风力较小，易保持清洁度"
// },
// "ac": {
// "title": "开启制暖空调",
// "desc": "您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"
// },
// "aqi": {
// "title": "优质",
// "desc": "空气很好，可以外出活动，呼吸新鲜空气"
// },
// "glass": {
// "title": "不需要",
// "desc": "不需要佩戴"
// },
// "mf": {
// "title": "一般",
// "desc": "空气干燥，天气较冷，头发水份和油份减少，这种天气洗发不宜太勤，洗发后要使用保湿型护发品。因头发已蓬松干燥，所以最好暂停烫发。"
// },
// "ag": {
// "title": "极不易发",
// "desc": "天气条件极不易诱发过敏，可放心外出，享受生活。"
// },
// "nl": {
// "title": "较不适宜",
// "desc": "天气较好，但室外寒风刺骨，建议夜生活最好在室内进行。"
// },
// "pj": {
// "title": "适宜",
// "desc": "天气炎热，可适量饮用啤酒，不要过量。"
// },
// "pk": {
// "title": "较适宜",
// "desc": "气温略高，放风筝时戴上太阳帽。"
// }
// },
// "air_press": "1035 hPa",
// "jiangshui": "0%",
// "night_wind_power": "0-3级 <5.4m/s",
// "day_wind_power": "0-3级 <5.4m/s",
// "day_weather_code": "00",
// "sun_begin_end": "07:21|17:38",
// "ziwaixian": "弱",
// "day_weather_pic": "http://app1.showapi.com/weather/icon/day/00.png",
// "night_air_temperature": "-11",
// "weekday": 1,
// "day_wind_direction": "西北风",
// "day_air_temperature": "0",
// "night_wind_direction": "北风",
// "night_weather_pic": "http://app1.showapi.com/weather/icon/night/00.png",
// "day": "20180205"
// }
public class WeatherBean implements Serializable
{
    private String nowAqi;
    
    private String nowQuality;
    
    private String nowWindDirection;
    
    private String nowWeather;
    
    private String nowTemperature;
    
    private String nowWeatherPic;
    
    private String nowWeatherCode;
    
    private String nowWindPower;
    
    private String nowHumidity;
    
    private String dayWeather;
    
    private String nightWeather;
    
    private String dayWeatherCode;
    
    private String airPress;
    
    private String dayAirTemperature;
    
    private String nightAirTemperature;
    
    private String dayWeatherPic;
    
    private String areaId;
    
    private ArrayList<LivingIndex> indexList;
    
    private String tomorrowDayAirTemp;
    
    private String tomorrowNightAirTemp;
    
    private String tomorrowDayWeather;
    
    private String tomorrowNightWeather;
    
    private String tomorrowDayWeatherIcon;
    
    private String tomorrowPress;
    
    private String tomorrowDayWeatherCode;
    
    private String afterTomorrowDayAirTemp;
    
    private String afterTomorrowNightAirTemp;
    
    private String afterTomorrowDayWeather;
    
    private String afterTomorrowNightWeather;
    
    private String afterTomorrowDayWeatherIcon;
    
    private String afterTomorrowPress;
    
    private String afterTomorrowWeatherCode;
    
    private String afterTomorrowWeekday;
    
    public String getNowAqi()
    {
        return nowAqi;
    }
    
    public void setNowAqi(String nowAqi)
    {
        this.nowAqi = nowAqi;
    }
    
    public String getNowQuality()
    {
        return nowQuality;
    }
    
    public void setNowQuality(String nowQuality)
    {
        this.nowQuality = nowQuality;
    }
    
    public String getNowWindDirection()
    {
        return nowWindDirection;
    }
    
    public String getAreaId()
    {
        return areaId;
    }
    
    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }
    
    public void setNowWindDirection(String nowWindDirection)
    {
        this.nowWindDirection = nowWindDirection;
    }
    
    public String getNowWeather()
    {
        return nowWeather;
    }
    
    public void setNowWeather(String nowWeather)
    {
        this.nowWeather = nowWeather;
    }
    
    public String getNowTemperature()
    {
        return nowTemperature;
    }
    
    public void setNowTemperature(String nowTemperature)
    {
        this.nowTemperature = nowTemperature;
    }
    
    public String getNowWeatherPic()
    {
        return nowWeatherPic;
    }
    
    public void setNowWeatherPic(String nowWeatherPic)
    {
        this.nowWeatherPic = nowWeatherPic;
    }
    
    public String getNowWeatherCode()
    {
        return nowWeatherCode;
    }
    
    public void setNowWeatherCode(String nowWeatherCode)
    {
        this.nowWeatherCode = nowWeatherCode;
    }
    
    public String getNowWindPower()
    {
        return nowWindPower;
    }
    
    public void setNowWindPower(String nowWindPower)
    {
        this.nowWindPower = nowWindPower;
    }
    
    public String getNowHumidity()
    {
        return nowHumidity;
    }
    
    public void setNowHumidity(String nowHumidity)
    {
        this.nowHumidity = nowHumidity;
    }
    
    public String getDayWeather()
    {
        return dayWeather;
    }
    
    public void setDayWeather(String dayWeather)
    {
        this.dayWeather = dayWeather;
    }
    
    public String getNightWeather()
    {
        return nightWeather;
    }
    
    public void setNightWeather(String nightWeather)
    {
        this.nightWeather = nightWeather;
    }
    
    public String getDayWeatherCode()
    {
        return dayWeatherCode;
    }
    
    public void setDayWeatherCode(String dayWeatherCode)
    {
        this.dayWeatherCode = dayWeatherCode;
    }
    
    public String getAirPress()
    {
        return airPress;
    }
    
    public void setAirPress(String airPress)
    {
        this.airPress = airPress;
    }
    
    public String getDayAirTemperature()
    {
        return dayAirTemperature;
    }
    
    public void setDayAirTemperature(String dayAirTemperature)
    {
        this.dayAirTemperature = dayAirTemperature;
    }
    
    public String getNightAirTemperature()
    {
        return nightAirTemperature;
    }
    
    public void setNightAirTemperature(String nightAirTemperature)
    {
        this.nightAirTemperature = nightAirTemperature;
    }
    
    public String getDayWeatherPic()
    {
        return dayWeatherPic;
    }
    
    public void setDayWeatherPic(String dayWeatherPic)
    {
        this.dayWeatherPic = dayWeatherPic;
    }
    
    public ArrayList<LivingIndex> getIndexList()
    {
        return indexList;
    }
    
    public void setIndexList(ArrayList<LivingIndex> indexList)
    {
        this.indexList = indexList;
    }
    
    public String getTomorrowDayAirTemp()
    {
        return tomorrowDayAirTemp;
    }
    
    public void setTomorrowDayAirTemp(String tomorrowDayAirTemp)
    {
        this.tomorrowDayAirTemp = tomorrowDayAirTemp;
    }
    
    public String getTomorrowNightAirTemp()
    {
        return tomorrowNightAirTemp;
    }
    
    public void setTomorrowNightAirTemp(String tomorrowNightAirTemp)
    {
        this.tomorrowNightAirTemp = tomorrowNightAirTemp;
    }
    
    public String getTomorrowDayWeather()
    {
        return tomorrowDayWeather;
    }
    
    public void setTomorrowDayWeather(String tomorrowDayWeather)
    {
        this.tomorrowDayWeather = tomorrowDayWeather;
    }
    
    public String getTomorrowDayWeatherIcon()
    {
        return tomorrowDayWeatherIcon;
    }
    
    public void setTomorrowDayWeatherIcon(String tomorrowDayWeatherIcon)
    {
        this.tomorrowDayWeatherIcon = tomorrowDayWeatherIcon;
    }
    
    public String getTomorrowPress()
    {
        return tomorrowPress;
    }
    
    public void setTomorrowPress(String tomorrowPress)
    {
        this.tomorrowPress = tomorrowPress;
    }
    
    public String getAfterTomorrowDayAirTemp()
    {
        return afterTomorrowDayAirTemp;
    }
    
    public void setAfterTomorrowDayAirTemp(String afterTomorrowDayAirTemp)
    {
        this.afterTomorrowDayAirTemp = afterTomorrowDayAirTemp;
    }
    
    public String getAfterTomorrowNightAirTemp()
    {
        return afterTomorrowNightAirTemp;
    }
    
    public void setAfterTomorrowNightAirTemp(String afterTomorrowNightAirTemp)
    {
        this.afterTomorrowNightAirTemp = afterTomorrowNightAirTemp;
    }
    
    public String getAfterTomorrowDayWeather()
    {
        return afterTomorrowDayWeather;
    }
    
    public void setAfterTomorrowDayWeather(String afterTomorrowDayWeather)
    {
        this.afterTomorrowDayWeather = afterTomorrowDayWeather;
    }
    
    public String getAfterTomorrowDayWeatherIcon()
    {
        return afterTomorrowDayWeatherIcon;
    }
    
    public void setAfterTomorrowDayWeatherIcon(
            String afterTomorrowDayWeatherIcon)
    {
        this.afterTomorrowDayWeatherIcon = afterTomorrowDayWeatherIcon;
    }
    
    public String getAfterTomorrowPress()
    {
        return afterTomorrowPress;
    }
    
    public void setAfterTomorrowPress(String afterTomorrowPress)
    {
        this.afterTomorrowPress = afterTomorrowPress;
    }
    
    public String getAfterTomorrowWeekday()
    {
        return afterTomorrowWeekday;
    }
    
    public void setAfterTomorrowWeekday(String afterTomorrowWeekday)
    {
        this.afterTomorrowWeekday = afterTomorrowWeekday;
    }
    
    public String getTomorrowNightWeather()
    {
        return tomorrowNightWeather;
    }
    
    public void setTomorrowNightWeather(String tomorrowNightWeather)
    {
        this.tomorrowNightWeather = tomorrowNightWeather;
    }
    
    public String getAfterTomorrowNightWeather()
    {
        return afterTomorrowNightWeather;
    }
    
    public void setAfterTomorrowNightWeather(String afterTomorrowNightWeather)
    {
        this.afterTomorrowNightWeather = afterTomorrowNightWeather;
    }
    
    public String getTomorrowDayWeatherCode()
    {
        return tomorrowDayWeatherCode;
    }
    
    public void setTomorrowDayWeatherCode(String tomorrowDayWeatherCode)
    {
        this.tomorrowDayWeatherCode = tomorrowDayWeatherCode;
    }
    
    public String getAfterTomorrowWeatherCode()
    {
        return afterTomorrowWeatherCode;
    }
    
    public void setAfterTomorrowWeatherCode(String afterTomorrowWeatherCode)
    {
        this.afterTomorrowWeatherCode = afterTomorrowWeatherCode;
    }
    
    @Override
    public String toString()
    {
        return "WeatherBean{" + "nowAqi='" + nowAqi + '\'' + ", nowQuality='"
                + nowQuality + '\'' + ", nowWindDirection='" + nowWindDirection
                + '\'' + ", nowWeather='" + nowWeather + '\''
                + ", nowTemperature='" + nowTemperature + '\''
                + ", nowWeatherPic='" + nowWeatherPic + '\''
                + ", nowWeatherCode='" + nowWeatherCode + '\''
                + ", nowWindPower='" + nowWindPower + '\'' + ", nowHumidity='"
                + nowHumidity + '\'' + ", dayWeather='" + dayWeather + '\''
                + ", nightWeather='" + nightWeather + '\''
                + ", dayWeatherCode='" + dayWeatherCode + '\'' + ", airPress='"
                + airPress + '\'' + ", dayAirTemperature='" + dayAirTemperature
                + '\'' + ", nightAirTemperature='" + nightAirTemperature + '\''
                + ", dayWeatherPic='" + dayWeatherPic + '\'' + ", areaId='"
                + areaId + '\'' + ", indexList=" + indexList
                + ", tomorrowDayAirTemp='" + tomorrowDayAirTemp + '\''
                + ", tomorrowNightAirTemp='" + tomorrowNightAirTemp + '\''
                + ", tomorrowDayWeather='" + tomorrowDayWeather + '\''
                + ", tomorrowNightWeather='" + tomorrowNightWeather + '\''
                + ", tomorrowDayWeatherIcon='" + tomorrowDayWeatherIcon + '\''
                + ", tomorrowPress='" + tomorrowPress + '\''
                + ", tomorrowDayWeatherCode='" + tomorrowDayWeatherCode + '\''
                + ", afterTomorrowDayAirTemp='" + afterTomorrowDayAirTemp + '\''
                + ", afterTomorrowNightAirTemp='" + afterTomorrowNightAirTemp
                + '\'' + ", afterTomorrowDayWeather='" + afterTomorrowDayWeather
                + '\'' + ", afterTomorrowNightWeather='"
                + afterTomorrowNightWeather + '\''
                + ", afterTomorrowDayWeatherIcon='"
                + afterTomorrowDayWeatherIcon + '\'' + ", afterTomorrowPress='"
                + afterTomorrowPress + '\'' + ", afterTomorrowWeatherCode='"
                + afterTomorrowWeatherCode + '\'' + ", afterTomorrowWeekday='"
                + afterTomorrowWeekday + '\'' + '}';
    }
    
    public static class LivingIndex
    {
        private String type;
        
        private String title;
        
        private String desc;
        
        public String getType()
        {
            return type;
        }
        
        public void setType(String type)
        {
            this.type = type;
        }
        
        public String getTitle()
        {
            return title;
        }
        
        public void setTitle(String title)
        {
            this.title = title;
        }
        
        public String getDesc()
        {
            return desc;
        }
        
        public void setDesc(String desc)
        {
            this.desc = desc;
        }
        
        @Override
        public String toString()
        {
            return "LivingIndex{" + "type='" + type + '\'' + ", title='" + title
                    + '\'' + ", desc='" + desc + '\'' + '}';
        }
    }
}
