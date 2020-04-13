package com.zy.coolbicycle.ui.activity.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zy.coolbicycle.R;

import butterknife.ButterKnife;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_search);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }
}
