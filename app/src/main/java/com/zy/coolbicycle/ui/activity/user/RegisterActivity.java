package com.zy.coolbicycle.ui.activity.user;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.eminayar.panter.PanterDialog;
import com.knifestone.hyena.currency.InputFilterAdapter;
import com.knifestone.hyena.currency.TextWatcherAdapter;
import com.knifestone.hyena.view.edittext.ClearEditText;
import com.knifestone.hyena.view.edittext.EyesEditText;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.util.CodeUtils;
import com.zy.coolbicycle.util.MD5Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/6
 */
public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.et_password)
    EyesEditText etPassword;
    @BindView(R.id.et_code)
    ClearEditText etCode;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.v_code)
    LinearLayout vCode;
    @BindView(R.id.btn_register)
    Button btnSignUp;
    @BindView(R.id.cb_comfirm)
    CheckBox cbComfirm;
    @BindView(R.id.tv_privacy_policy)
    TextView tvPrivacyPolicy;
    @BindView(R.id.tv_service_policy)
    TextView tvServicePolicy;
    private Bitmap bitmap;
    private String code;
    private String account, password, vcode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_register);
        ButterKnife.bind(this);
        initView();
    }


    //服务协议
    @OnClick(R.id.tv_service_policy)
    public void tvServicePolicyOnClick(View view) {
        new PanterDialog(this)
                .setHeaderBackground(R.color.white)
                .setTitle("服务协议")
                .setTitleColor(R.color.black)
                .setPositive("确认")
                .setMessage(R.string.service_policy)
                .isCancelable(false)
                .show();
    }

    //隐私条款
    @OnClick(R.id.tv_privacy_policy)
    public void tvPrivacyPolicyOnClick(View view) {
        new PanterDialog(this)
                .setHeaderBackground(R.color.white)
                .setTitle("隐私条框")
                .setTitleColor(R.color.black)
                .setPositive("确认")
                .setMessage(R.string.privacy_policy)
                .isCancelable(false)
                .show();
    }

    /**
     * 注册按钮的点击事件
     *
     * @param view
     */
    @OnClick(R.id.btn_register)
    public void btnRigisterOnClick(View view) {
        account = etAccount.getText().toString().trim();
        password = MD5Util.md5(etPassword.getText().toString().trim());//获取输入框输入的密码，并进行md5加密
        vcode = etCode.getText().toString().trim();
        sign(account, password);
    }

    /**
     * 初始化页面，对输入框进行监听，输入过滤
     */
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
        etCode.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                if (checkSignUp()) {
                    btnSignUp.setBackground(getResources().getDrawable(R.drawable.btn_blue));
                }
            }
        });
        cbComfirm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    btnSignUp.setEnabled(false);
                    Toast.makeText(RegisterActivity.this, "请先勾选已阅读！", Toast.LENGTH_SHORT).show();
                    return;
                } else
                    btnSignUp.setBackground(getResources().getDrawable(R.drawable.btn_blue));
            }
        });
        getCode();

    }

    /**
     * 获取验证码图片
     */
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

    /**
     * 注册按钮，完成向数据库添加数据
     *
     * @param account
     * @param password
     */
    private void sign(String account, String password) {
        //验证码输入错误，自动切换新的图片
        if (!code.equals(vcode)) {
            Toast.makeText(RegisterActivity.this, "验证码输入错误!", Toast.LENGTH_SHORT).show();
            bitmap = CodeUtils.getInstance().createBitmap();
            code = CodeUtils.getInstance().getCode();
            ivCode.setImageBitmap(bitmap);
            return;
        }
        //显示加载进度条
        final ProgressDialog loadingDialog = new ProgressDialog(RegisterActivity.this);
        loadingDialog.setMessage("注册中...");
        loadingDialog.show();
        String postUrl = RegisterActivity.this.getApplication().getString(R.string.server_address) + "/sign/register.php";

        EasyRequestParams params = new EasyRequestParams();
        params.put("account", account);
        params.put("password", password);

        EasyHttpClient.post(postUrl,
                params,
                new EasyStringCallback() {

                    @Override
                    public void onSuccess(String content) {
                        if (content.equals("success")) {
                            //验证成功，跳转至首页
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                            loadingDialog.dismiss();
                        } else if (content.equals("failure")) {
                            Toast.makeText(RegisterActivity.this, "注册失败,请重试！", Toast.LENGTH_SHORT).show();
                            loadingDialog.dismiss();
                        } else {
                            Toast.makeText(RegisterActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                            loadingDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Throwable error, String content) {
                        Toast.makeText(RegisterActivity.this, "连接服务器失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                        loadingDialog.dismiss();
                    }
                }
        );
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
            Toast.makeText(RegisterActivity.this, "账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etPassword.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignUp.setEnabled(false);
            Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        msg = etCode.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            btnSignUp.setEnabled(false);
            Toast.makeText(RegisterActivity.this, "请输入验证码！", Toast.LENGTH_SHORT).show();
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
            actionBar.setTitle("关于");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
