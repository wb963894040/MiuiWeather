package com.hl.policeweather.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * copy from xUtils
 * 
 * Log工具，类似android.util.Log。 tag自动产生，格式:
 * customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。 Author: wyouflf
 * Date: 13-7-24 Time: 下午12:23
 */
public class LogUtil
{
    private static boolean debug = false;
    
    public static String customTagPrefix = "policeHelper_log";
    
    private LogUtil()
    {
    }
    
    public static void setDebug(boolean debug)
    {
        LogUtil.debug = debug;
    }
    
    private static String generateTag()
    {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName
                .substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag,
                callerClazzName,
                caller.getMethodName(),
                caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag
                : customTagPrefix + ":" + tag;
        return tag;
    }
    
    public static void d(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        Log.d(tag, content);
    }
    
    public static void d(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.d(tag, content, tr);
    }
    
    public static void e(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.e(tag, content);
    }
    
    public static void e(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.e(tag, content, tr);
    }
    
    public static void i(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.i(tag, content);
    }
    
    public static void i(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.i(tag, content, tr);
    }
    
    public static void v(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.v(tag, content);
    }
    
    public static void v(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.v(tag, content, tr);
    }
    
    public static void w(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.w(tag, content);
    }
    
    public static void w(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.w(tag, content, tr);
    }
    
    public static void w(Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.w(tag, tr);
    }
    
    public static void wtf(String content)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.wtf(tag, content);
    }
    
    public static void wtf(String content, Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.wtf(tag, content, tr);
    }
    
    public static void wtf(Throwable tr)
    {
        if (!debug)
            return;
        String tag = generateTag();
        
        Log.wtf(tag, tr);
    }
    
}
