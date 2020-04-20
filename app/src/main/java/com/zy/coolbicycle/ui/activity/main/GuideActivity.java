package com.zy.coolbicycle.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.user.LoginActivity;
import com.zy.coolbicycle.ui.activity.user.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.btn_guide_login)
    Button btnGuideLogin;
    @BindView(R.id.btn_guide_register)
    Button btnGuideRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_guide);
        ButterKnife.bind(this);
    }

    /**
     * 前往登陆界面
     *
     * @param view
     */
    @OnClick(R.id.btn_guide_login)
    public void btnGuideLoginOnClck(View view) {
        Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * 前往注册界面
     *
     * @param view
     */
    @OnClick(R.id.btn_guide_register)
    public void btnGuideRegisterOnClick(View view) {
        Intent intent = new Intent(GuideActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
