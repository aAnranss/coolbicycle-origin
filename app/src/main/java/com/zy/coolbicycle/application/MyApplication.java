package com.zy.coolbicycle.application;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.webkit.WebView;

import com.baidu.mapapi.SDKInitializer;
import com.itheima.retrofitutils.ItheimaHttp;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class MyApplication extends Application {
    private WebView mWebView;

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        ItheimaHttp.init(this, "http://www.imxingzhe.com/");
        mWebView = new WebView(new MutableContextWrapper(this));
    }
}
