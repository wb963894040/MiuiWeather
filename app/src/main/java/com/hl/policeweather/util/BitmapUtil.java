package com.hl.policeweather.util;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.hl.policeweather.R;

/**
 * Created by 汪彬 on 2017/2/5.
 */
public class BitmapUtil
{
    public static int getBirdsResource(int times)
    {
        switch (times % 16)
        {
            case 1:
                return R.mipmap.green01;
            case 2:
                return R.mipmap.green02;
            case 3:
                return R.mipmap.green03;
            case 4:
                return R.mipmap.green04;
            case 5:
                return R.mipmap.green05;
            case 6:
                return R.mipmap.green06;
            case 7:
                return R.mipmap.green07;
            case 8:
                return R.mipmap.green08;
            case 9:
                return R.mipmap.green09;
            case 10:
                return R.mipmap.green10;
            case 11:
                return R.mipmap.green11;
            case 12:
                return R.mipmap.green12;
            case 13:
                return R.mipmap.green13;
            case 14:
                return R.mipmap.green14;
            case 15:
                return R.mipmap.green15;
            case 16:
                return R.mipmap.green16;
            default:
                return R.mipmap.green01;
        }
    }
    
    public static float getBitmapScale(Resources res, int id)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, id, options);
        if (options.outHeight != 0)
            return options.outWidth / options.outHeight;
        return 0;
    }
}
