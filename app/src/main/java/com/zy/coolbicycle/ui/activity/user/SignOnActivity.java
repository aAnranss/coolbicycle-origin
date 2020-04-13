package com.zy.coolbicycle.ui.activity.user;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.main.MainActivity;
import com.zy.coolbicycle.util.Okhttp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 应用模块:登陆
 * 类描述:
 * Created by 卢文钏 on 2020/4/6
 */
public class SignOnActivity extends AppCompatActivity {
    private EditText etAccount;
    private EditText etPassword;
    private TextView btnRegister;
    private TextView btnForgetPwd;
    private Button btnSignIn;
    private String userAccount, userPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_sign_on);
        initView();

    }


    private void initView() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);

        btnSignIn = findViewById(R.id.btn_sign_in);
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
                if (checkSignIn()) {
                    btnSignIn.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable s) {
                if (checkSignIn()) {
                    btnSignIn.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });

        //登陆按钮的点击事件
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAccount = etAccount.getText().toString().trim();
                userPassword = etPassword.getText().toString().trim();
                sign(userAccount, userPassword);
            }
        });

        //注册按钮的点击事件
        btnRegister = findViewById(R.id.tv_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignOnActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void sign(String account, String password) {

        //显示加载进度条
        final ProgressDialog loadingDialog = new ProgressDialog(SignOnActivity.this);
        loadingDialog.setMessage("登陆中...");
        loadingDialog.show();
        Intent internt = new Intent(SignOnActivity.this, MainActivity.class);
        startActivity(internt);
        finish();
        new Okhttp().setOkHttpClient(SignOnActivity.this.getApplication().getString(R.string.server_address) + "/sign/sign_on.php", "{\"account\":\"" + account + "\",\"password\":\"" + password + "\"}", new Okhttp.Getdata() {

            @Override
            public void successful(String s) {
                //获取用户信息
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String result = jsonObject.getString("result");
                    if (result.equals("登陆成功")) {
                        String userAccount = jsonObject.getString("account");
                        //登陆成功，跳转至首页
                        Intent internt = new Intent(SignOnActivity.this, MainActivity.class);
                        startActivity(internt);
                        finish();
                        loadingDialog.dismiss();
                    } else {
                        Toast.makeText(SignOnActivity.this, "登陆失败！用户名或密码错误。", Toast.LENGTH_SHORT).show();
                        loadingDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed() {
                Looper.prepare();
                Toast.makeText(SignOnActivity.this, "连接服务器失败！", Toast.LENGTH_SHORT).show();
                Looper.loop();
                loadingDialog.dismiss();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkSignIn();
    }

    /**
     * 检测是否可以提交
     */
    private Boolean checkSignIn() {
        btnSignIn.setEnabled(true);
        String msg = etAccount.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignIn.setEnabled(false);
            Toast.makeText(SignOnActivity.this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignIn.setEnabled(false);
            Toast.makeText(SignOnActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
