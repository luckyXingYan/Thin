package com.example.thin.base.http.netcore.core;

import android.content.Context;

import com.example.thin.BuildConfig;
import com.example.thin.base.http.netcore.LogInterpector;
import com.example.thin.util.LocalUser;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：网络请求配置
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 17:51
 */
public class NetConfig {

    // httpheaders
    public Map<String, String> headers = new HashMap<>();

    private void setupHeaders() {

        headers.put("equipmentType", "0");//设备类型 0：安卓 1：ios
        headers.put("token", LocalUser.getInstance().getToken());//token
//        headers.put("requestTimestamp", LocalUser.getInstance().getToken());//时间戳

        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept-Charset", "UTF-8,*");

    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    // 超时时间
    public final long timeout = 20L * 1000L;

    // 时间单位
    public final TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;

    // 服务器地址
    public final String BASE_URL = BuildConfig.SERVER_ADD;

    // 智能客服服务器地址
//    public final String KEFU_BASE_URL = BuildConfig.KEFU_SERVER_ADD;


    // 解析器
    public Converter.Factory gsonFactory = GsonConverterFactory.create(new GsonBuilder()
            .setLenient()
            .create());

    // 日志
    public LogInterpector logger;

    private void setupLogger() {
        logger = new LogInterpector();
    }


    public static NetConfig create(Context context) {

        NetConfig config = new NetConfig();
        config.setupHeaders();
        config.setupLogger();

        return config;
    }
}
