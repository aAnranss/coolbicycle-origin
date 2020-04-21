package com.zy.coolbicycle.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.eminayar.panter.PanterDialog;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.adapter.ListViewAdapter;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.entity.Item;
import com.zy.coolbicycle.ui.activity.main.GuideActivity;
import com.zy.coolbicycle.ui.activity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 应用模块:设置
 * 类描述:
 * Created by 卢文钏 on 2020/4/9
 */
public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.lv_setting_items)
    ListView lvSettingItems;
    @BindView(R.id.btn_logout)
    Button btnLogout;
    private List<Item> mDatas;
    private ListViewAdapter listViewAdapter;
    private LayoutInflater layoutInflater;
    private MyApplication mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_setting);
        ButterKnife.bind(this);
        initView();
        showActionBar();
    }

    /**
     * 退出按钮的点击事件
     *
     * @param view
     */
    @OnClick(R.id.btn_logout)
    public void btnLogoutOnClick(View view) {
        mApplication = (MyApplication) getApplication();
        if (mApplication.isLogin) {
            new PanterDialog(this)
                    .setHeaderBackground(R.color.white)
                    .setTitle("退出提示")
                    .setTitleColor(R.color.black)
                    .setMessage("您真的要残忍离开吗？")
                    .setPositive("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mApplication.isLogin = false;//设置登陆状态
                            mApplication.userLogout();//重置当前用户，null,未登录状态
                            startActivity(new Intent(SettingActivity.this, MainActivity.class));
                            finish();
                        }
                    })
                    .setNegative("取消")
                    .isCancelable(true)
                    .show();

        } else {
            new PanterDialog(this)
                    .setHeaderBackground(R.color.white)
                    .setTitle("登陆提示")
                    .setTitleColor(R.color.black)
                    .setMessage("您还没有登陆，是否前往登陆/注册？")
                    .setPositive("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(SettingActivity.this, GuideActivity.class));
                            finish();
                        }
                    })
                    .setNegative("取消")
                    .isCancelable(true)
                    .show();
        }

    }

    private void initView() {

        layoutInflater = getLayoutInflater();
        mDatas = new ArrayList<>();
        mDatas.add(new Item("用户服务协议"));
        mDatas.add(new Item("隐私协议"));
        mDatas.add(new Item("关于"));

        listViewAdapter = new ListViewAdapter(mDatas, layoutInflater);
        lvSettingItems.setAdapter(listViewAdapter);

        lvSettingItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
                        startActivity(intent);
                }
            }
        });

    }

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
            actionBar.setTitle("设置");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
