package com.zy.coolbicycle.ui.activity.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zy.coolbicycle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zy.coolbicycle.R2.id.timer;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class SplashActivity extends Activity {

    private CountDownTimer timer;
    @BindView(R.id.tv_count_down)
    TextView tvCountDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);
        ButterKnife.bind(this);
        initCountDown(tvCountDown);
    }

    // 倒计时逻辑
    private void initCountDown(final TextView countDownText) {
        // 判断当前Activity是否isFinishing()，
        // 避免在finish，所有对象都为null的状态下执行CountDown造成内存泄漏
        if (!isFinishing()) {
            timer = new CountDownTimer(1000 * 5, 1000) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    int time = (int) millisUntilFinished;
                    countDownText.setText(time / 1000 + " 跳过");
                    countDownText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkToJump();
                        }
                    });
                }

                @Override
                public void onFinish() {
                    //倒计时结束自动进入下一页
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                }
            }.start();
        }
    }

    // 首次进入引导页判断
    private void checkToJump() {
        //  TODO：首次安装判断
        // 如果是首次安装打开，则跳至引导页；否则跳至主界面
        // 这里先不放引导页，直接跳到主界面
        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        // 回收内存
        destoryTimer();
        finish();
    }

    public void destoryTimer() {
        // 避免内存泄漏
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
