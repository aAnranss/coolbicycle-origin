package com.zy.coolbicycle.ui.activity.user;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.knifestone.hyena.view.edittext.ClearEditText;
import com.knifestone.hyena.view.edittext.EyesEditText;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.LoginBean;
import com.zy.coolbicycle.bean.WeatherBean;
import com.zy.coolbicycle.ui.activity.main.MainActivity;
import com.zy.coolbicycle.util.MD5Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

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
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forgetpwd)
    TextView tvForgetpwd;
    @BindView(R.id.tv_btn)
    LinearLayout tvBtn;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String userAccount, userPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);
        ButterKnife.bind(this);
        initView();

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

    /**
     * 注册按钮的点击事件
     *
     * @param view
     */
    @OnClick(R.id.tv_register)
    public void btnRegisterOnClick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login(String account, String password) {

        //显示加载进度条
        final ProgressDialog loadingDialog = new ProgressDialog(LoginActivity.this);
        loadingDialog.setMessage("登陆中...");
        loadingDialog.show();
        String postUrl = "http://123.57.204.10/app/sign/login.php";

        EasyRequestParams params = new EasyRequestParams();
        params.put("account", account);
        params.put("password", password);

        EasyHttpClient.post(postUrl,
                params,
                new EasyStringCallback() {

                    @Override
                    public void onSuccess(String content) {
                        if (!content.equals("failure")) {
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
            Toast.makeText(LoginActivity.this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnLogin.setEnabled(false);
            Toast.makeText(LoginActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        } else if (msg.trim().length() < 5) {
            btnLogin.setEnabled(false);
            Toast.makeText(LoginActivity.this, "密码不能少于六位！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
