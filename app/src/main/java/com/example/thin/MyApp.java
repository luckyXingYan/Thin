package com.example.thin;

import android.app.Application;
import android.content.Context;

import com.example.thin.base.http.netcore.core.NetConfig;
import com.example.thin.base.http.netcore.core.NetEngine;
import com.example.thin.util.PreferenceUtil;
import com.example.thin.util.SwitchFrontBackgroundCallbacks;
import com.squareup.leakcanary.LeakCanary;


/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        // 初始化 SharedPreferences
        PreferenceUtil.getInstance().init(this);
        // 初始化网络框架
        NetEngine.init(NetConfig.create(this));
        //初始化内存泄露检测器
        initLeakCanary();
        //此处作用是监听前后台切换的变化
        registerActivityLifecycleCallbacks(new SwitchFrontBackgroundCallbacks());
    }

    private void initLeakCanary() {
        //release 版本不检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static Context getContextObject() {
        return context;
    }
}
