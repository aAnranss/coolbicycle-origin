package com.zy.coolbicycle.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyCustomCallback;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.bean.UserInfoBean;
import com.zy.coolbicycle.ui.activity.main.MainActivity;

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
    private MyApplication mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_feedback);
        ButterKnife.bind(this);
        showActionBar();
    }

    @OnClick(R.id.btn_commit_feedback)
    public void btnCommitFeedbackOnClick(View view) {
        mApplication = (MyApplication) getApplication();
        String contentStr = etFeedback.getText().toString().trim();
        //向数据库添加一条记录
        //新建一个反馈表,记录反馈记录
        feedbackCommit(mApplication.getLoginUser().getU_account(), contentStr);
    }

    private void feedbackCommit(String account, String content) {
        String getUrl = FeedbackActivity.this.getApplication().getString(R.string.server_address) + "/sign/feedback.php";
        EasyRequestParams params = new EasyRequestParams();
        params.put("account", account);
        params.put("content", content);
        EasyHttpClient.post(getUrl, params, new EasyStringCallback() {
                    @Override
                    public void onSuccess(String content) {
                        if (content.equals("success")) {
                            Toast.makeText(FeedbackActivity.this, "反馈成功，感谢您提出的宝贵意见！", Toast.LENGTH_SHORT).show();
                        } else if (content.equals("failure")) {
                            Toast.makeText(FeedbackActivity.this, "反馈失败！", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable error, String content) {
                        Toast.makeText(FeedbackActivity.this, "连接服务器失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                    }
                }
        );
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
