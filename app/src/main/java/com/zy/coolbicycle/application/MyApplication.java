package com.zy.coolbicycle.application;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.webkit.WebView;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.itheima.retrofitutils.ItheimaHttp;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class MyApplication extends Application {
    private WebView mWebView ;
    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);

        ItheimaHttp.init(this, "http://www.imxingzhe.com/");
        mWebView = new WebView(new MutableContextWrapper(this));
    }
}
