package com.zy.coolbicycle.home.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zy.coolbicycle.home.fragment.HotFragment;
import com.zy.coolbicycle.home.fragment.RecommendFragment;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabTitles;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                RecommendFragment recommendFragment = new RecommendFragment();
                return recommendFragment;
            case 1:
                HotFragment hotFragment = new HotFragment();
                return hotFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position % tabTitles.length];
    }
}
