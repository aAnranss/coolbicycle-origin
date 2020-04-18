package com.zy.coolbicycle.ui.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.user.LoginActivity;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class SplashActivity extends Activity {
    //设置延迟时间
    private final int SKIP_DELAY_TIME = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);
        //在SplashActivity停留3秒，随即跳转至MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initMain();
            }
        }, SKIP_DELAY_TIME);
    }

    private void initMain() {
        this.startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
