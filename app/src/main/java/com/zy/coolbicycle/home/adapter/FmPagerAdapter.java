package com.zy.coolbicycle.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zy.coolbicycle.home.fragment.HotFragment;
import com.zy.coolbicycle.home.fragment.RecommendFragment;

import java.util.HashMap;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class FmPagerAdapter extends FragmentPagerAdapter {

    private int num;

    public FmPagerAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {

        return createFragment(position);
    }

    @Override
    public int getCount() {
        return num;
    }

    private Fragment createFragment(int pos) {
        switch (pos) {
            case 0:
                return new RecommendFragment();
            case 1:
                return new HotFragment();

        }
        return null;
    }
}
