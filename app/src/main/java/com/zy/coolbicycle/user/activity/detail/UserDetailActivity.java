package com.zy.coolbicycle.user.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.zy.coolbicycle.R;
import com.zy.coolbicycle.user.adapter.UserFragmentItemAdapter;
import com.zy.coolbicycle.user.entity.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/9
 */
public class UserDetailActivity extends AppCompatActivity {
    @BindView(R.id.iv_detail_avatar)
    ImageView mAvatar;
    @BindView(R.id.tv_detail_account)
    TextView mAccount;
    @BindView(R.id.lv_detail_items)
    ListView items;
    private List<Item> mItems;
    private UserFragmentItemAdapter<Item> mAdapter; //实例化适配器


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_user_detail);
        ButterKnife.bind(this);
        initView();
        showActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_settings:
                Intent intent = new Intent(UserDetailActivity.this, UserInfoUpdateActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                return true;
        }
        return true;
    }

    private void initView() {
        /*mAccount = findViewById(R.id.tv_detail_account);
        mAvatar = findViewById(R.id.iv_detail_avatar);
        items = findViewById(R.id.lv_detail_items);*/
        mItems = new ArrayList<>();
        mItems.add(new Item("邮箱"));
        mItems.add(new Item("用户名"));
        mAdapter = new UserFragmentItemAdapter<Item>((ArrayList) mItems, R.layout.layout_user_frame_item) {
            @Override
            public void bindView(ViewHolder holder, Item obj) {
                holder.setText(R.id.tv_title, obj.getaTitle());
            }
        };

        items.setAdapter(mAdapter);

    }

    /**
     * 显示顶部导航栏
     */
    public void showActionBar() {
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("关于");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
