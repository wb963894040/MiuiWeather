package com.hl.policeweather.constant;

import android.app.PendingIntent;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 汪彬 on 2017/12/19.
 */
public class GlobeConstant
{
    public static final String OPEN_KEY = "OPEN_KEY";
    
    public static final int TYPE_DEFAULT = -1;
    
    public static final int TYPE_WEATHER = 0x0001;
    
    public static final int TYPE_SCHEDULE = 0x0002;
    
    @IntDef(flag = true, value = { TYPE_DEFAULT, TYPE_WEATHER, TYPE_SCHEDULE })
    @Retention(RetentionPolicy.SOURCE)
    public @interface OPEN_TYPE
    {
    }
    
    /************************ showApi for test ****************************/
    public static final String TAG_GET_WEATHER = "GET_WEATHER";
    
    public static final String APP_ID = "52730";
    
    public static final String APP_SIGN = "06df57f07727432183be30d3add6ac37";
}
