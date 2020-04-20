package com.zy.coolbicycle.application;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.webkit.WebView;

import com.baidu.mapapi.SDKInitializer;
import com.itheima.retrofitutils.ItheimaHttp;
import com.yang.easyhttp.EasyHttpClient;
import com.zy.coolbicycle.bean.UserInfoBean;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class MyApplication extends Application {
    private WebView mWebView;

    private UserInfoBean loginUser = new UserInfoBean();

    public Boolean isLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化HttpClient.
        EasyHttpClient.init(this);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        ItheimaHttp.init(this, "http://www.imxingzhe.com/");
        mWebView = new WebView(new MutableContextWrapper(this));
    }

    public UserInfoBean getLoginUser() {
        return loginUser;
    }

    public void userLogin(UserInfoBean bean) {
        loginUser.setU_account(bean.getU_account());
        loginUser.setU_email(bean.getU_email());
        loginUser.setU_age(bean.getU_age());
        loginUser.setU_head(bean.getU_head());
        loginUser.setU_ride_time(bean.getU_ride_time());
        loginUser.setU_nickname(bean.getU_nickname());
    }

    public void userLogout() {
        loginUser = new UserInfoBean();
    }
}
