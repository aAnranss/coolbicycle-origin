package com.zy.coolbicycle.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zy.coolbicycle.ui.fragment.map.MapFragment;
import com.zy.coolbicycle.ui.fragment.home.HomeFragment;
import com.zy.coolbicycle.ui.fragment.user.UserFragment;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/2
 */
public class MainAdapter extends FragmentPagerAdapter {
    private Fragment mfragment = null;

    public MainAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                mfragment = new HomeFragment();
                break;
            case 1:
                mfragment = new MapFragment();
                break;
            case 2:
                mfragment = new UserFragment();
                break;
        }
        return mfragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
