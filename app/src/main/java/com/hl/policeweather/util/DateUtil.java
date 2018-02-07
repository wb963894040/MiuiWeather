package com.hl.policeweather.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 汪彬 on 2018/2/5.
 */

public class DateUtil
{
    
    public static String getCurrentDate(String format)
    {
        return new SimpleDateFormat(format).format(new Date());
    }
}
