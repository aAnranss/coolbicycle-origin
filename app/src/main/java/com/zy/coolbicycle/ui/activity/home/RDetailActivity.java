package com.zy.coolbicycle.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.common.SysOSUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyCustomCallback;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.yang.easyhttp.request.EasyRequestParams;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.RDetailBean;
import com.zy.coolbicycle.ui.activity.main.MainActivity;
import com.zy.coolbicycle.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/5/5
 */
public class RDetailActivity extends AppCompatActivity {


    RDetailActivity mContext;
    @BindView(R.id.iv_road_detail_logo)
    ImageView ivRoadDetailLogo;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.iv_creater_portrait)
    CircleImageView ivCreaterPortrait;
    @BindView(R.id.tv_creater_nickname)
    TextView tvCreaterNickname;
    @BindView(R.id.tv_creater_city)
    TextView tvCreaterCity;
    @BindView(R.id.tv_route_desc)
    TextView tvRouteDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_r_detail);
        ButterKnife.bind(this);
        showActionBar();
        initData();
    }

    private void initData() {
        //获取屏幕尺寸
        WindowManager manager = (WindowManager) RDetailActivity.this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;//获取到的是px，像素，绝对像素，需要转化为dpi

        String baseUrl = "http://client.blackbirdsport.com/route_getRouteInfo?ton=n3FRhrsvN0xBhqYM&routeId=";
        int routeId = getIntent().getIntExtra("routeId", 0);
        String getURL = baseUrl + routeId;
        EasyHttpClient.get(getURL, new EasyCustomCallback<RDetailBean>() {

            @Override
            public void onSuccess(RDetailBean rDetailBean) {//ui thread.
                // ui operation using content object.
                Glide.with(RDetailActivity.this)
                        .load(rDetailBean.getRoute().getLogo()) //图片url地址
                        .override(width, (int) ((width / 2)))//固定大小
                        .centerCrop()//图片适应
                        .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                        .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                        .into(ivRoadDetailLogo);//图片显示的imageview
                Glide.with(RDetailActivity.this)
                        .load(rDetailBean.getRoute().getCreater().getPortrait())
                        .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                        .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                        .into(ivCreaterPortrait);
                tvCommentCount.setText(String.valueOf(rDetailBean.getRoute().getCommentCount()));
                tvCreaterNickname.setText(rDetailBean.getRoute().getCreater().getNickname());
                tvCreaterCity.setText(rDetailBean.getRoute().getCreater().getCityName());
                tvRouteDesc.setText(rDetailBean.getRoute().getRouteDesc());
            }

            @Override
            public void onFailure(Throwable error, String content) {//ui thread.

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 返回键的点击事件
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
        String routeName = getIntent().getStringExtra("routeName");
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(routeName);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
