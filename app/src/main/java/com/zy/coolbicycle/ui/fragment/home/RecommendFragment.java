package com.zy.coolbicycle.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.home.NewsDetailActivity;
import com.zy.coolbicycle.bean.NewsBean;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Headers;
import retrofit2.Call;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class RecommendFragment extends Fragment {
    private Unbinder unbinder;
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;  //下拉刷新
    @BindView(R.id.recycler_view)
    ItheimaRecyclerView recyclerView;       //RecyclerView

    private int state = 0;  //判断下拉刷新  or  加载更多
    private static final int STATE_MORE = 1;    //加载更多
    private static final int STATE_REFRESH = 2; //下拉刷新
    private String nextPage = "";
    private List<NewsBean.DataBean.DisplayTypeBean> mDisplayTypeBean = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_recommend, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        onClick();

    }


    private void onClick() {

        ItemClickSupport itemClickSupport = new ItemClickSupport(recyclerView);
        //新闻item的点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                String h5_url = mDisplayTypeBean.get(position).getH5_url();//获取H5页面地址
                String title = mDisplayTypeBean.get(position).getTitle();
                Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                intent.putExtra("title", title);//传入标题
                intent.putExtra("url", h5_url);//传入url
                startActivity(intent);
            }
        });
    }

    private void initView() {

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(swipeRefreshLayout, recyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.home_item_recyclerview;
            }

            @Override
            public String getApi() {
                //接口
                //page 为当前页，值为：1、2、3、4
                String url = "api/v4/news?news_type=3&limit=20&page=";
                String firstPage = "api/v4/news?news_type=3&limit=20&page=1";
                switch (state) {
                    case STATE_MORE:
                        //使用String包装类转换int类型的 mCurPage+1(当前页的下一页)
                        nextPage = String.valueOf(mCurPage + 1);
                        url += nextPage;    //字符串拼接
                        break;
                    case STATE_REFRESH:
                        break;
                }
                //若mCurPage为1，则返回首页的地址，否则返回通用url(自增页数)
                return mCurPage == 1 ? firstPage : url;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                state = STATE_MORE;
                return true;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();

        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<NewsBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                state = STATE_REFRESH;
            }

            @Override
            public void onSuccess(NewsBean newsBean, Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                List<NewsBean.DataBean.DisplayTypeBean> itemDatas = newsBean.getItemDatas();
                for (NewsBean.DataBean.DisplayTypeBean itemData : itemDatas) {
                    mDisplayTypeBean.add(itemData);
                }

            }
        });

    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.DataBean.DisplayTypeBean> {
        //换成你布局文件中的id
        @BindView(R.id.iv_news_pic)
        ImageView ivNewsPic;
        @BindView(R.id.tv_news_title)
        TextView tvNewsTitle;
        @BindView(R.id.tv_news_source)
        TextView tvNewsSource;
        @BindView(R.id.tv_publish_time)
        TextView tvPublishTime;
        @BindView(R.id.tv_click)
        TextView tvClick;

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            Glide.with(mContext) //设置context
                    .load(mData.getPic_url()) //图片url地址
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivNewsPic);//图片显示的imageview
            tvNewsTitle.setText(mData.getTitle());
            tvNewsSource.setText(mData.getSource());
            tvPublishTime.setText(mData.getPublish_time());
            tvClick.setText(mData.getClick());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }
}
