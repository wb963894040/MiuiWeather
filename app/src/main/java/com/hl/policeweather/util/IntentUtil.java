package com.hl.policeweather.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by 汪彬 on 2017/12/25.
 */

public class IntentUtil
{
    
    /**
     * 获取intent
     */
    public static Intent getIntent(Context context, Class<?> c, Bundle bundle)
    {
        Intent intent = new Intent(context, c);
        if (null != bundle)
        {
            intent.putExtras(bundle);
        }
        return intent;
    }
    
    /**
     * 意图到其他界面
     *
     * @param context 当前上下文
     * @param c 意图的类
     * @param bundle 参数绑定
     */
    public static void intent(Context context, Class<?> c, Bundle bundle)
    {
        Intent intent = new Intent(context, c);
        if (null != bundle)
        {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
    
    /**
     * 意图到拨号界面
     *
     * @param context 当前上下文
     * @param phoneNumber 手机号码
     */
    public static void intentCall(Context context, String phoneNumber)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
