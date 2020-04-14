package com.zy.coolbicycle.application;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.webkit.WebView;

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
        ItheimaHttp.init(this, "http://www.imxingzhe.com/");
        mWebView = new WebView(new MutableContextWrapper(this));
    }
}
