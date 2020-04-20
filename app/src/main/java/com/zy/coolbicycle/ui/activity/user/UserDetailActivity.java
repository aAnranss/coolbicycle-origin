package com.zy.coolbicycle.ui.activity.user;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kongzue.dialog.interfaces.OnInputDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnMenuItemClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.v3.BottomMenu;
import com.kongzue.dialog.v3.InputDialog;
import com.kongzue.dialog.v3.TipDialog;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zy.coolbicycle.ui.fragment.user.UserFragment.dip2px;


/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/9
 */
public class UserDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_detail_avatar)
    CircleImageView ivDetailAvatar;     //头像
    @BindView(R.id.tv_user_detail_nick_name)
    TextView tvNickName;                //昵称
    @BindView(R.id.tv_user_detail_account)
    TextView tvUserAccount;             //账号
    @BindView(R.id.tv_user_detail_email)
    TextView tvUserEmail;               //邮箱
    @BindView(R.id.tv_join_time)
    TextView tvJoinTime;                //注册时间

    private MyApplication mApplication;
    // 拍照回传码
    public final static int CAMERA_REQUEST_CODE = 0;
    // 相册选择回传吗
    public final static int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_user_detail);
        ButterKnife.bind(this);
        getLoginInfo();
        initData();
        showActionBar();
    }

    @OnClick({R.id.tv_user_detail_account, R.id.tv_join_time})
    public void Unchangeable(View view) {
        TipDialog.show(UserDetailActivity.this, "无法修改", TipDialog.TYPE.WARNING)
                .setTipTime(1000)
                .setTheme(DialogSettings.THEME.LIGHT);
    }

    /**
     * 点击切换头像
     *
     * @param view
     */
    @OnClick(R.id.iv_detail_avatar)
    public void ivDetailAvatarOnClick(View view) {
        List<String> datas = new ArrayList<>();
        datas.add("从手机相册选择");
        datas.add("拍照");

        BottomMenu.build(UserDetailActivity.this)
                .setCancelButtonText("取消")
                .setTheme(DialogSettings.THEME.LIGHT)
                .setStyle(DialogSettings.STYLE.STYLE_KONGZUE)
                .setMenuTextList(datas)
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    @Override
                    public void onClick(String text, int index) {
                        switch (index) {
                            case 0:
                                Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                                openAlbumIntent.setType("image/*");
                                startActivityForResult(openAlbumIntent, GALLERY_REQUEST_CODE);//打开相册
                                break;
                            case 1:
                                //Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//用来打开相机的Intent
                                //startActivityForResult(takePhotoIntent, CAMERA_REQUEST_CODE);//启动相机
                        }
                    }
                }).show();
    }

    /**
     * 点击更改昵称
     *
     * @param view
     */
    @OnClick(R.id.tv_user_detail_nick_name)
    public void tvUserNickNameOnClick(View view) {
        InputDialog.show(UserDetailActivity.this, "设置昵称", "设置一个好听的昵称吧", "确定", "取消")
                .setTheme(DialogSettings.THEME.LIGHT)
                .setStyle(DialogSettings.STYLE.STYLE_KONGZUE)
                .setOnOkButtonClickListener(new OnInputDialogButtonClickListener() {
                    @Override
                    public boolean onClick(BaseDialog baseDialog, View v, String inputStr) {
                        //向服务器发送请求
                        return false;
                    }
                })
                .setOnCancelButtonClickListener(new OnInputDialogButtonClickListener() {
                    @Override
                    public boolean onClick(BaseDialog baseDialog, View v, String inputStr) {
                        baseDialog.doDismiss();
                        return false;
                    }
                });

    }

    /**
     * 点击更换邮箱
     *
     * @param view
     */
    @OnClick(R.id.tv_user_detail_email)
    public void tvUserEmailOnClick(View view) {
        InputDialog.show(UserDetailActivity.this, "设置邮箱", "请输入您的邮箱", "确定", "取消")
                .setTheme(DialogSettings.THEME.LIGHT)
                .setStyle(DialogSettings.STYLE.STYLE_KONGZUE)
                .setOnOkButtonClickListener(new OnInputDialogButtonClickListener() {
                    @Override
                    public boolean onClick(BaseDialog baseDialog, View v, String inputStr) {
                        //向服务器请求
                        return false;
                    }
                })
                .setOnCancelButtonClickListener(new OnInputDialogButtonClickListener() {
                    @Override
                    public boolean onClick(BaseDialog baseDialog, View v, String inputStr) {
                        baseDialog.doDismiss();
                        return false;
                    }
                });
    }


    public void getLoginInfo() {
        mApplication = (MyApplication) getApplication();
    }

    private void initData() {
        Glide.with(this) //设置context
                .load(mApplication.getLoginUser().getU_head()) //图片url地址
                .override(dip2px(this, 62), dip2px(this, 62))//固定大小
                .centerCrop()//图片适应
                .into(ivDetailAvatar);//图片显示的imageview
        tvNickName.setText(mApplication.getLoginUser().getU_nickname());
        tvUserAccount.setText(mApplication.getLoginUser().getU_account());
        tvUserEmail.setText(mApplication.getLoginUser().getU_email());
        tvJoinTime.setText(mApplication.getLoginUser().getU_ride_time());//这是骑行年龄
    }

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
            actionBar.setTitle("个人资料");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
