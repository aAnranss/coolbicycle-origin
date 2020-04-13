package com.zy.coolbicycle.ui.fragment.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.user.UserDetailActivity;
import com.zy.coolbicycle.ui.activity.user.SettingActivity;
import com.zy.coolbicycle.adapter.ListViewAdapter;
import com.zy.coolbicycle.entity.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class UserFragment extends Fragment {
    private Unbinder unbinder;  //butterknife绑定
    @BindView(R.id.iv_avatar) ImageView mAvatar;        //iv_avatar
    @BindView(R.id.lv_items) ListView listView;           //lv_items
    private List<Item> mDatas;
    private ListViewAdapter listViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_page, null);
        unbinder = ButterKnife.bind(this,view);//绑定butterknife
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        //头像的点击事件--->显示用户信息详情页
        mAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internt = new Intent(getActivity(), UserDetailActivity.class);
                startActivity(internt);
            }
        });

        //加载自定义布局
        LayoutInflater inflater = getLayoutInflater();

        mDatas = new ArrayList<>();
        mDatas.add(new Item(R.mipmap.feedback, "意见反馈"));
        mDatas.add(new Item(R.mipmap.setting, "设置"));

        listViewAdapter = new ListViewAdapter(mDatas, inflater);
        //设置适配器
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Intent intent = new Intent(getContext(), SettingActivity.class);
                        startActivity(intent);
                }
            }
        });

    }

    private void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//销毁时解绑
    }
}
