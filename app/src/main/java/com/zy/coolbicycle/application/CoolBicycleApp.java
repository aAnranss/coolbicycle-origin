package com.zy.coolbicycle.application;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class CoolBicycleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this, "http://www.imxingzhe.com/");
    }
}
