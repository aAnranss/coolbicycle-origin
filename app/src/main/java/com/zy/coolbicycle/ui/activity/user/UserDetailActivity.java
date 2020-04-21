package com.zy.coolbicycle.ui.activity.user;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.IDNA;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kongzue.dialog.interfaces.OnInputDialogButtonClickListener;
import com.kongzue.dialog.interfaces.OnMenuItemClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.v3.BottomMenu;
import com.kongzue.dialog.v3.InputDialog;
import com.kongzue.dialog.v3.TipDialog;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyCallback;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.application.MyApplication;
import com.zy.coolbicycle.widget.CircleImageView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

    private static final int TAKE_PHOTO_PERMISSION_REQUEST_CODE = 0; // 拍照的权限处理返回码
    private static final int WRITE_SDCARD_PERMISSION_REQUEST_CODE = 1; // 读储存卡内容的权限处理返回码

    private static final int TAKE_PHOTO_REQUEST_CODE = 3; // 拍照返回的 requestCode
    private static final int CHOICE_FROM_ALBUM_REQUEST_CODE = 4; // 相册选取返回的 requestCode
    private static final int CROP_PHOTO_REQUEST_CODE = 5; // 裁剪图片返回的 requestCode

    private Uri photoUri = null;
    private Uri photoOutputUri = null; // 图片最终的输出文件的 Uri

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_user_detail);
        ButterKnife.bind(this);
        /*
         * 先判断用户以前有没有对我们的应用程序允许过读写内存卡内容的权限，
         * 用户处理的结果在 onRequestPermissionResult 中进行处理
         */
        if (ContextCompat.checkSelfPermission(UserDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 申请读写内存卡内容的权限
            ActivityCompat.requestPermissions(UserDetailActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_SDCARD_PERMISSION_REQUEST_CODE);
        }
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
     * 点击更换头像
     *
     * @param view
     */
    @OnClick(R.id.iv_detail_avatar)
    public void ivDetailAvatarOnClick(View view) {
        List<String> datas = new ArrayList<>();
        datas.add("拍照");
        datas.add("从手机相册选择");

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
                                if (ContextCompat.checkSelfPermission(UserDetailActivity.this, Manifest.permission.CAMERA)
                                        != PackageManager.PERMISSION_GRANTED) {
                                    //下面是对调用相机拍照权限进行申请
                                    ActivityCompat.requestPermissions(UserDetailActivity.this,
                                            new String[]{Manifest.permission.CAMERA,}, TAKE_PHOTO_PERMISSION_REQUEST_CODE);
                                } else {
                                    openCamera(); // 打开相机
                                }
                                break;
                            case 1:
                                openGallery(); // 打开相册
                                break;
                        }
                    }
                }).show();
    }

    /**
     * 打开相机
     */
    private void openCamera() {
        /**
         * 设置拍照得到的照片的储存目录，因为我们访问应用的缓存路径并不需要读写内存卡的申请权限，
         * 因此，这里为了方便，将拍照得到的照片存在这个缓存目录中
         */
        File file = new File(getExternalCacheDir(), String.valueOf(System.currentTimeMillis()) + ".jpg");
        System.out.println(file);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            photoUri = FileProvider.getUriForFile(this, "com.zy.coolbicycle.provider", file);
        } else {
            photoUri = Uri.fromFile(file); // Android 7.0 以前使用原来的方法来获取文件的 Uri
        }
        // 打开系统相机的 Action，等同于："android.media.action.IMAGE_CAPTURE"
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 设置拍照所得照片的输出目录
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(takePhotoIntent, TAKE_PHOTO_REQUEST_CODE);
    }

    /**
     * 打开相册
     */
    private void openGallery() {
        // 打开系统图库的 Action，等同于: "android.intent.action.GET_CONTENT"
        Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // 设置数据类型为图片类型
        choiceFromAlbumIntent.setType("image/*");
        startActivityForResult(choiceFromAlbumIntent, CHOICE_FROM_ALBUM_REQUEST_CODE);
    }

    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri inputUri) {
        // 调用系统裁剪图片的 Action
        Intent cropPhotoIntent = new Intent("com.android.camera.action.CROP");
        // 设置数据Uri 和类型
        cropPhotoIntent.setDataAndType(inputUri, "image/*");
        // 授权应用读取 Uri，这一步要有，不然裁剪程序会崩溃
        cropPhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 设置图片的最终输出目录
        cropPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                photoOutputUri = Uri.parse("file:////sdcard/upload_head.jpg"));
        startActivityForResult(cropPhotoIntent, CROP_PHOTO_REQUEST_CODE);
    }

    /**
     * 动态获取权限
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            // 调用相机拍照：
            case TAKE_PHOTO_PERMISSION_REQUEST_CODE:
                // 如果用户授予权限，那么打开相机拍照
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "拍照权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
            // 打开相册选取：
            case WRITE_SDCARD_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "读写内存卡内容权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 判断用户选择头像的方式
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PHOTO_REQUEST_CODE:
                    cropPhoto(photoUri);
                    break;
                case CHOICE_FROM_ALBUM_REQUEST_CODE:
                    cropPhoto(data.getData());
                    break;
                case CROP_PHOTO_REQUEST_CODE:
                    File file = new File(photoOutputUri.getPath());
                    if (file.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(photoOutputUri.getPath());
                        ivDetailAvatar.setImageBitmap(bitmap);
                        upLoadFile(file, mApplication.getLoginUser().getU_account());
//                        file.delete(); // 选取完后删除照片
                    } else {
                        Toast.makeText(this, "找不到照片", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }

    /**
     * 上传头像
     *
     * @param file        头像文件
     * @param currentUser 当前用户
     */
    private void upLoadFile(File file, String currentUser) {
        System.out.println("文件名:" + file.getName() + ",文件绝对路径:" + file.getAbsolutePath());
        RequestBody fileBody2 = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("account", currentUser)
                .addFormDataPart("image", file.getName(), fileBody2)
                .build();
        Request request = new Request.Builder()
                .url(UserDetailActivity.this.getApplication().getString(R.string.server_address) + "/load/upload.php")
                .post(requestBody)
                .build();
        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = httpBuilder
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    final String newHeadUrl = response.body().string();//获取服务器返回的新头像的地址
                    mApplication.getLoginUser().setU_head(newHeadUrl);//设置新头像
                    System.out.println(newHeadUrl);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(response);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }


        });
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
