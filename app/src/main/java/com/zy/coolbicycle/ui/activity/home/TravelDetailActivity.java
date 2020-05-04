package com.zy.coolbicycle.ui.activity.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.AgentWebView;
import com.just.agentweb.WebViewClient;
import com.yang.easyhttp.EasyHttpClient;
import com.yang.easyhttp.callback.EasyStringCallback;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.TravelDetailBean;
import com.zy.coolbicycle.widget.CircleImageView;

import java.util.regex.Matcher;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/14
 */
public class TravelDetailActivity extends AppCompatActivity {

    AgentWeb mAgentWeb;
    @BindView(R.id.tv_travel_article_title)
    TextView tvTravelArticleTitle;
    @BindView(R.id.tv_travel_forum_name)
    TextView tvTravelForumName;
    @BindView(R.id.tv_travel_article_views_count)
    TextView tvTravelArticleViewsCount;
    @BindView(R.id.rl_travel_article_info)
    RelativeLayout rlTravelArticleInfo;
    @BindView(R.id.iv_travel_article_author)
    ImageView ivTravelArticleAuthor;
    @BindView(R.id.tv_travel_article_author_name)
    TextView tvTravelArticleAuthorName;
    @BindView(R.id.tv_travel_article_publish_time)
    TextView tvTravelArticlePublishTime;
    @BindView(R.id.rl_travel_article_author_info)
    RelativeLayout rlTravelArticleAuthorInfo;
    @BindView(R.id.travel_agent_webview)
    AgentWebView travelAgentWebview;
    @BindView(R.id.iv_comment_author_head)
    CircleImageView ivCommentAuthorHead;
    @BindView(R.id.tv_comment_author_name)
    TextView tvCommentAuthorName;
    @BindView(R.id.tv_post_time)
    TextView tvPostTime;
    @BindView(R.id.rl_comment_author_info)
    RelativeLayout rlCommentAuthorInfo;
    @BindView(R.id.ll_travel_detail_comment_layout)
    LinearLayout llTravelDetailCommentLayout;
    @BindView(R.id.relative_layout_travel_detail)
    RelativeLayout relativeLayoutTravelDetail;
    @BindView(R.id.tv_comment_detail)
    TextView tvCommentDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_travel_detail);
        ButterKnife.bind(this);
        showActionBar();
        getData();
        //initData();

    }

    String completeUrl = "";

    private void getData() {
        String baseUrl = "https://bbs.biketo.com/api/mobile/index.php?module=viewthread&page=1&version=5&tid=";
        String realUrl = "&ordertype=0";
        String tid = getIntent().getStringExtra("tid");
        completeUrl = baseUrl + tid + realUrl;
        System.out.println("++++++++++++++++" + completeUrl);
        EasyHttpClient.get(completeUrl,
                new EasyStringCallback() {
                    @Override
                    public void onSuccess(String content) {
                        System.out.println("游记详情页申请数据：++++++++++++++++" + content);
                        Gson gson = new Gson();
                        TravelDetailBean bean = gson.fromJson(content.replaceAll("\\\\","").replaceAll(Matcher.quoteReplacement("$"), ""), TravelDetailBean.class);
                        //传入当前用户信息
                        System.out.println("++++++++++++++++" + bean);
                        setTravelDetail(bean);
                    }

                    @Override
                    public void onFailure(Throwable error, String content) {

                    }
                });
    }

    public void setTravelDetail(TravelDetailBean bean) {
        tvTravelArticleTitle.setText(bean.Variables.thread.getSubject());
        tvTravelArticleAuthorName.setText(bean.Variables.thread.getAuthor());
        //tvPostTime.setText(bean.Variables.thread.getDateline());
        tvTravelArticleViewsCount.setText(bean.Variables.thread.getViews());
        tvTravelForumName.setText(bean.Variables.thread.getForumname());
        tvTravelArticlePublishTime.setText(bean.Variables.thread.getDateline());
        //加载博客图片
        Glide.with(this) //设置context
                .load(bean.Variables.getMember_avatar()) //图片url地址
                .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                .into(ivTravelArticleAuthor);//图片显示的imageview

        //tvCommentDetail.setText(bean.Variables.postlist);

    }
    /*private void initData() {
        String baseUrl = "https://bbs.biketo.com/api/mobile/index.php?module=viewthread&page=1&version=5&tid=";
        String realUrl = "&ordertype=0";
        String tid = getIntent().getStringExtra("tid");
        String completeUrl = baseUrl + tid + realUrl;
        System.out.println("++++++++++++++++" + completeUrl);
        Request request = ItheimaHttp.newGetRequest(completeUrl);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<TravelDetailBean>() {

            @Override
            public void onResponse(TravelDetailBean travelDetailBean, Headers headers) {

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(travelDetailBean.Variables.thread.dateline);
                System.out.println("+++++++++++" + dateString);
                tvTravelArticleTitle.setText(getIntent().getStringExtra("title"));
                tvTravelForumName.setText("来源 " + travelDetailBean.Variables.thread.forumname);
                System.out.println("+++++++++++++" + tvTravelForumName);
                tvTravelArticleViewsCount.setText(String.valueOf(travelDetailBean.Variables.thread.views));
                tvTravelArticleAuthorName.setText(travelDetailBean.Variables.thread.author);
                tvTravelArticlePublishTime.setText(dateString);
            }
        });

        mAgentWeb = AgentWeb.with(this)//传入Activity
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .setAgentWebParent(relativeLayoutTravelDetail, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()//使用默认进度条
                .setWebChromeClient(new WebChromeClient())
                .setWebViewClient(mWebViewClient)
                .createAgentWeb()
                .ready()
                .go(completeUrl);
    }*/

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            AgentWebConfig.syncCookie(url, AgentWebConfig.getCookiesByUrl(url));
            super.onPageFinished(view, url);
        }
    };

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
        //获取标题，填充到标题栏
        String title = getIntent().getStringExtra("title");
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
