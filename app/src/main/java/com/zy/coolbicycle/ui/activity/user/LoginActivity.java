package com.zy.coolbicycle.ui.activity.user;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.knifestone.hyena.view.edittext.ClearEditText;
import com.knifestone.hyena.view.edittext.EyesEditText;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.bean.UserInfoBean;
import com.zy.coolbicycle.ui.activity.main.MainActivity;
import com.zy.coolbicycle.util.MD5Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 应用模块:登陆
 * 类描述:
 * Created by 卢文钏 on 2020/4/6
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.et_password)
    EyesEditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String userAccount, userPassword;

    private MyApplication mApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);
        ButterKnife.bind(this);
        mApplication = (MyApplication) getApplication();
        initView();
        showActionBar();
    }

    private void initView() {
        //设置过滤器：账号、密码只允许输入数字、字母、符号
        InputFilterAdapter inputFilter = new InputFilterAdapter
                .Builder()
                .filterEmoji(true)      //过滤Emoji表情
                .filterChinese(true)    //过滤中文字符
                .builder();
        etAccount.setFilters(new InputFilter[]{inputFilter});
        etPassword.setFilters(new InputFilter[]{inputFilter});

        //设置文本监听
        etAccount.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable s) {
                if (checkLogin()) {
                    btnLogin.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable s) {
                if (checkLogin()) {
                    btnLogin.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }

            }
        });

    }

    /**
     * 登陆按钮的点击事件
     *
     * @param view
     */
    @OnClick(R.id.btn_login)
    public void btnLoginOnClick(View view) {
        userAccount = etAccount.getText().toString().trim();
        userPassword = MD5Util.md5(etPassword.getText().toString().trim());//MD5加密
        login(userAccount, userPassword);
    }

    private void login(String account, String password) {

        //显示加载进度条
        final ProgressDialog loadingDialog = new ProgressDialog(LoginActivity.this);
        loadingDialog.setMessage("登陆中...");
        loadingDialog.show();
        String postUrl = LoginActivity.this.getApplication().getString(R.string.server_address) + "/sign/login.php";

        EasyRequestParams params = new EasyRequestParams();
        params.put("account", account);
        params.put("password", password);

        EasyHttpClient.post(postUrl,
                params,
                new EasyStringCallback() {

                    @Override
                    public void onSuccess(String content) {
                        //String infoStream = content.substring(2,content.length()-3);
                        System.out.println("++++++++++++++++" + content);
                        Gson gson = new Gson();
                        System.out.println(content);
                        if (!content.equals("failure")) {
                            UserInfoBean bean = gson.fromJson(content.substring(1, content.length() - 1), UserInfoBean.class);
                            //UserInfoBean bean = gson.fromJson(content,UserInfoBean.class);
                            //传入当前用户信息
                            System.out.println("++++++++++++++++" + bean);
                            mApplication.userLogin(bean);
                            mApplication.isLogin = true;
                            //验证成功，跳转至首页
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            loadingDialog.dismiss();
                        } else {
                            Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                            loadingDialog.dismiss();
                        }

                    }

                    @Override
                    public void onFailure(Throwable error, String content) {
                        Toast.makeText(LoginActivity.this, "连接服务器失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                        loadingDialog.dismiss();
                    }
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkLogin();
    }

    /**
     * 检测是否可以提交
     */
    private Boolean checkLogin() {
        btnLogin.setEnabled(true);
        String msg = etAccount.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnLogin.setEnabled(false);
            //Toast.makeText(LoginActivity.this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnLogin.setEnabled(false);
            //Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 返回键点击事件，返回登陆按钮
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }

    /**
     * 显示顶部导航栏
     */
    public void showActionBar() {
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("登陆");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
