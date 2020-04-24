package com.zy.coolbicycle.ui.activity.main;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.fragment.home.HomeFragment;
import com.zy.coolbicycle.ui.fragment.map.SportFragment;
import com.zy.coolbicycle.ui.fragment.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_tab)
    PageNavigationView bottomTab;
    private List<Fragment> mfragments;
    @BindView(R.id.main_frame)
    FrameLayout frameLayout;
    /*String isRefresh = "";

    public String getIsRefresh() {
        Intent intent = getIntent();
        isRefresh = intent.getStringExtra("refresh");
        System.out.println("+++++++++++++++" + isRefresh);
        return isRefresh;
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        ButterKnife.bind(this);
        judgePermission();
        initFragment();
        initBottomTab();
        getData();
    }

    private void getData() {


    }


    private void initFragment() {
        //frameLayout = findViewById(R.id.frame);
        Fragment homeFragment = new HomeFragment();
        Fragment sportFragment = new SportFragment();
        Fragment userFragment = new UserFragment();
        //添加fragment
        mfragments = new ArrayList<>();
        mfragments.add(homeFragment);
        mfragments.add(sportFragment);
        mfragments.add(userFragment);
        if (sportFragment != null) {
            //默认选中home
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.main_frame, homeFragment);
            transaction.commit();
            // transaction.commitAllowingStateLoss();
        }

    }

    private void initBottomTab() {

        final NavigationController controller = bottomTab.material()
                .addItem(R.mipmap.ic_home_black_24dp, "首页")
                .addItem(R.mipmap.ic_bicycle_black_24dp, "运动")
                .addItem(R.mipmap.ic_user_black_24dp, "我的")
                .setDefaultColor(getResources().getColor(R.color.color_bottom_tab_black))
                .build();
        //第三个标签（我的）设置角标为10
        //controller.setMessageNumber(2, 10);
        controller.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Fragment currentFragment = mfragments.get(index);
                Fragment oldFragment = mfragments.get(old);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (currentFragment.isAdded()) {
                    transaction.hide(oldFragment).show(currentFragment).commit();

                } else {
                    transaction.add(R.id.main_frame, currentFragment).hide(oldFragment).show(currentFragment).commit();
                }


            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }

    //6.0之后要动态获取权限，重要！！！
    protected void judgePermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝

            String[] SdCardPermission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            String[] readPhoneStatePermission = {Manifest.permission.READ_PHONE_STATE};
            String[] locationPermission = {Manifest.permission.ACCESS_FINE_LOCATION};
            String[] WRITE_EXTERNAL_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            String[] ACCESS_COARSE_LOCATION = {Manifest.permission.ACCESS_COARSE_LOCATION};
            String[] READ_EXTERNAL_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE};
            if (ContextCompat.checkSelfPermission(this, SdCardPermission[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, readPhoneStatePermission[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION[0]) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, locationPermission[0]) != PackageManager.PERMISSION_GRANTED) {

                // 如果没有授予该权限，就去提示用户请求
                ActivityCompat.requestPermissions(this, SdCardPermission, 100);
                ActivityCompat.requestPermissions(this, locationPermission, 300);
                ActivityCompat.requestPermissions(this, readPhoneStatePermission, 200);
                ActivityCompat.requestPermissions(this, ACCESS_COARSE_LOCATION, 400);
                ActivityCompat.requestPermissions(this, READ_EXTERNAL_STORAGE, 500);
                ActivityCompat.requestPermissions(this, WRITE_EXTERNAL_STORAGE, 600);
            }

        } else {
            //doSdCardResult();
        }
        //LocationClient.reStart();
    }
}
