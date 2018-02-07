package com.hl.policeweather;

import android.app.Application;

import com.hl.policeweather.util.LogUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by 汪彬 on 2017/12/27.
 */

public class WeatherApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LogUtil.d("WeatherApplication onCreate...");
        LogUtil.setDebug(true);
        initNet();
        initFonts();
    }
    
    private void initFonts()
    {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/thinfont-thin.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
    
    private void initNet()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                "OkGo");
        // log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        // log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        // 全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        // 全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        // 全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS,
                TimeUnit.MILLISECONDS);
        OkGo.getInstance()
                // 必须调用初始化
                .init(this)
                // 建议设置OkHttpClient，不设置将使用默认的
                .setOkHttpClient(builder.build())
                // 全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheMode(CacheMode.NO_CACHE)
                // 全局统一缓存时间，默认永不过期，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                // 全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .setRetryCount(0);
    }
}
