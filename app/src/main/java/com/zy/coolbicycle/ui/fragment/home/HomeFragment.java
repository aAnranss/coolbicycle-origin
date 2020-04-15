package com.zy.coolbicycle.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zy.coolbicycle.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 应用模块:home
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class HomeFragment extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"推荐", "游记", "路书"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, null);
        unbinder = ButterKnife.bind(this, view);//绑定
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {

        for (int pos = 0; pos < titles.length; pos++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles[pos]));
        }

    }

    private void initView() {

        fragments.add(new RecommendFragment());
        fragments.add(new TravelFragment());
        fragments.add(new RoadFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {

                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        //可滑动，亦可点击切换
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager,true);
        //移除原有的tab
        tabLayout.removeAllTabs();
        //设置当前显示页面相邻的2个页面进行缓存,解决页面数据重新加载问题
        viewPager.setOffscreenPageLimit(2);
        //点击tab无效
        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();//解绑
    }
}
