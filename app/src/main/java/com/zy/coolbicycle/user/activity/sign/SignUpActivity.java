package com.zy.coolbicycle.user.activity.sign;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.util.CodeUtils;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/6
 */
public class SignUpActivity extends AppCompatActivity {
    private EditText etAccount;
    private EditText etPassword;
    private EditText etCode;
    private ImageView ivCode;
    private TextView btnSignUp;
    private Bitmap bitmap;
    private String code;
    private String account, password, vcode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_sign_up);
        initView();
    }

    private void initView() {
        etAccount = findViewById(R.id.et_account);    //获取账号
        etPassword = findViewById(R.id.et_password);   //获取密码
        btnSignUp = findViewById(R.id.btn_sign_up);   //绑定注册按钮
        etCode = findViewById(R.id.et_code);       //获取验证码
        ivCode = findViewById(R.id.iv_code);       //验证码图片
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
                if (checkSignUp()) {
                    btnSignUp.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable s) {
                if (checkSignUp()) {
                    btnSignUp.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });
        etCode.addTextChangedListener(new TextWatcherAdapter(){
            @Override
            public void afterTextChanged(Editable s) {
                if (checkSignUp()){
                    btnSignUp.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = etAccount.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                vcode = etCode.getText().toString().trim();
                sign(account,password, vcode);
            }
        });
        getCode();

    }

    private void getCode() {
        //获取工具类生成的图片验证码对象
        bitmap = CodeUtils.getInstance().createBitmap();
        //获取当前图片验证码的对应内容用于校验
        code = CodeUtils.getInstance().getCode();

        ivCode.setImageBitmap(bitmap);
        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = CodeUtils.getInstance().createBitmap();
                code = CodeUtils.getInstance().getCode();
                ivCode.setImageBitmap(bitmap);
            }
        });

    }

    private void sign(String account, String password, String vcode) {
        if (!code.equals(vcode)){
            Toast.makeText(SignUpActivity.this,"验证码输入错误!",Toast.LENGTH_SHORT).show();
            return;
        }
        //向服务器添加一条记录



        Intent intent = new Intent(SignUpActivity.this, SignOnActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkSignUp();
    }

    /**
     * 检测是否可以提交
     */
    private Boolean checkSignUp() {
        btnSignUp.setEnabled(true);
        String msg = etAccount.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignUp.setEnabled(false);
            Toast.makeText(SignUpActivity.this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignUp.setEnabled(false);
            Toast.makeText(SignUpActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etCode.getText().toString();
        if (TextUtils.isEmpty(msg)){
            btnSignUp.setEnabled(false);
            Toast.makeText(SignUpActivity.this, "请输入验证码！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
