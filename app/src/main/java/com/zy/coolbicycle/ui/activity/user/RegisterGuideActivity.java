package com.zy.coolbicycle.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.knifestone.hyena.view.edittext.ClearEditText;
import com.zy.coolbicycle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/23
 */
public class RegisterGuideActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    ClearEditText etEmail;
    @BindView(R.id.et_ride_time)
    ClearEditText etRideTime;
    @BindView(R.id.spn_experience)
    Spinner spnExperience;
    @BindView(R.id.btn_go_ahead)
    Button btnGoAhead;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_register_guide);
        ButterKnife.bind(this);
        initVIew();
    }

    @OnClick(R.id.btn_go_ahead)
    public void goAheadOnClick(View view) {
        startActivity(new Intent(RegisterGuideActivity.this, LoginActivity.class));
        finish();
    }

    private void initVIew() {
        String email = etEmail.getText().toString().trim();
        String rideTime = etRideTime.getText().toString().trim();
        spnExperience.setOnItemSelectedListener(spnSexOnItemSelected);
        System.out.println(email);
        System.out.println(rideTime);
    }

    private AdapterView.OnItemSelectedListener spnSexOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            System.out.println(parent.getSelectedItem().toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }

    /**
     * 显示顶部导航栏
     */
    public void showActionBar() {
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("信息详情");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
