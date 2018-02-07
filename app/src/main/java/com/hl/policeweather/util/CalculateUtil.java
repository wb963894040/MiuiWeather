package com.hl.policeweather.util;

/**
 * Created by 汪彬 on 2017/2/5.
 */
public class CalculateUtil
{
    public static float getPythagorean(double first, double second)
    {
        return (float) Math.sqrt(first * first + second * second);
    }
    
    public static float getSquare(float x)
    {
        return x * x;
    }
}
