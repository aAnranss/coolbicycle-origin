package com.zy.coolbicycle.ui.activity.user;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.zy.coolbicycle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/19
 */
public class FeedbackActivity extends AppCompatActivity {
    @BindView(R.id.et_feedback)
    EditText etFeedback;
    @BindView(R.id.btn_commit_feedback)
    Button btnCommitFeedback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_feedback);
        ButterKnife.bind(this);
        showActionBar();
    }

    @OnClick(R.id.btn_commit_feedback)
    public void btnCommitFeedbackOnClick(View view) {
        //向数据库添加一条记录
        //新建一个反馈表,记录反馈记录
    }

    /**
     * 显示顶部导航栏
     */
    public void showActionBar() {
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("意见反馈");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    /**
     * 返回箭头的点击事件
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}
