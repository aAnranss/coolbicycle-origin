package com.zy.coolbicycle.ui.activity.main;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.fragment.home.HomeFragment;
import com.zy.coolbicycle.ui.fragment.map.MapFragment;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        ButterKnife.bind(this);
        initFragment();
        initBottomTab();
    }


    private void initFragment() {
        //frameLayout = findViewById(R.id.frame);
        Fragment homeFragment = new HomeFragment();
        Fragment mapFragment = new MapFragment();
        Fragment userFragment = new UserFragment();
        //添加fragment
        mfragments = new ArrayList<>();
        mfragments.add(homeFragment);
        mfragments.add(mapFragment);
        mfragments.add(userFragment);
        if (homeFragment != null) {
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
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_frame, currentFragment);
                    transaction.commit();
                    // transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }
}
