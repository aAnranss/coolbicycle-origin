package com.zy.coolbicycle.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.home.bean.NewsDetailBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;

/**
 * 应用模块:新闻详情页
 * 类描述:
 * Created by 卢文钏 on 2020/4/11
 */
public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_news_detail_title)
    TextView tvNewsDetailTitle;
    @BindView(R.id.tv_news_detail_source)
    TextView tvNewsDetailSource;
    @BindView(R.id.tv_news_detail_publish_time)
    TextView tvNewsDetailPublishTime;
    @BindView(R.id.wv_news_detail)
    WebView wvNewsDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_news_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Request request = ItheimaHttp.newGetRequest("api/v4/news/?news_id= " + id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<NewsDetailBean>() {
            @Override
            public void onResponse(NewsDetailBean newsDetailBean, Headers headers) {

            }

        });
    }

    private void initView() {

    }
}
