package com.zy.coolbicycle.ui.fragment.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.adapter.ListViewAdapter;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.entity.Item;
import com.zy.coolbicycle.ui.activity.main.GuideActivity;
import com.zy.coolbicycle.ui.activity.user.FeedbackActivity;
import com.zy.coolbicycle.ui.activity.user.SettingActivity;
import com.zy.coolbicycle.ui.activity.user.UserDetailActivity;
import com.zy.coolbicycle.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.view.View.GONE;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class UserFragment extends Fragment {
    @BindView(R.id.tv_user_nick_name)
    TextView tvUserNickName;
    @BindView(R.id.tv_user_account)
    TextView tvUserAccount;
    @BindView(R.id.rl_user_info)
    RelativeLayout userInfo;
    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    private Unbinder unbinder;  //butterknife绑定
    @BindView(R.id.lv_items)
    ListView listView;           //lv_items
    private List<Item> mDatas;
    private ListViewAdapter listViewAdapter;
    private MyApplication mApplication;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_page, null);
        unbinder = ButterKnife.bind(this, view);//绑定butterknife
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mApplication = (MyApplication) getActivity().getApplication();
        initView();
        initData();
    }

    private void initData() {
        
    }

    @OnClick(R.id.rl_user_info)
    public void ivAvatarOnClick(View view) {
        if (mApplication.isLogin) {
            Intent internt = new Intent(getActivity(), UserDetailActivity.class);
            startActivity(internt);
        } else {
            Intent intent = new Intent(getActivity(), GuideActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void initView() {
        //头像的点击事件--->显示用户信息详情页

        if (mApplication.isLogin) {
            tvUserNickName.setText(mApplication.getLoginUser().getU_nickname());
            tvUserAccount.setText("账号：" + mApplication.getLoginUser().getU_account());
            System.out.println(mApplication.getLoginUser().getU_head());
            Glide.with(getContext()) //设置context
                    .load(mApplication.getLoginUser().getU_head()) //图片url地址
                    .override(dip2px(getContext(), 62), dip2px(getContext(), 62))//固定大小
                    .centerCrop()//图片适应
                    .into(ivAvatar);//图片显示的imageview
        } else {
            tvUserAccount.setVisibility(GONE);
            tvUserNickName.setText("您还没有登陆，点击前往登陆界面");
        }

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
                        Intent feedback = new Intent(getContext(), FeedbackActivity.class);
                        startActivity(feedback);
                        break;
                    case 1:
                        Intent setting = new Intent(getContext(), SettingActivity.class);
                        startActivity(setting);
                        break;
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//销毁时解绑
    }

}
