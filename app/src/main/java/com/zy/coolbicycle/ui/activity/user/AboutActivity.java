package com.zy.coolbicycle.ui.activity.user;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.adapter.ListViewAdapter;
import com.zy.coolbicycle.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/9
 */
public class AboutActivity extends AppCompatActivity {

    private TextView mAppName;
    private TextView mAppVersion;
    private ListView mListView;
    private LayoutInflater layoutInflater;
    private ListViewAdapter mAdapter;
    private List<Item> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_about);
        initView();
        showActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }

    private void initView() {

        mAppName = findViewById(R.id.tv_app_name);
        mAppVersion = findViewById(R.id.tv_app_version);
        mListView = findViewById(R.id.lv_about_items);

        mAppName.setText(getApplicationInfo().packageName);//获取包名
        mAppVersion.setText(getAppVersionName(this));//显示当前版本号

        layoutInflater = getLayoutInflater();

        mDatas = new ArrayList<>();
        mDatas.add(new Item("检查更新"));

        mAdapter = new ListViewAdapter(mDatas, layoutInflater);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(AboutActivity.this,"已是最新版本",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    /**
     *  获取当前系统的版本名
     * @param context
     * @return appVersionName
     */
    public static String getAppVersionName(Context context) {
        String appVersionName = "";
        try {
            PackageInfo packageInfo = context.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            appVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {

        }
        return appVersionName;
    }

    /**
     * 显示顶部导航栏
     */
    public void showActionBar(){
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("关于");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
