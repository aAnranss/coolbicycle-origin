package com.zy.coolbicycle.home.fragment;

import android.content.Context;
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
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.home.activity.NewsDetailActivity;
import com.zy.coolbicycle.home.bean.NewsBean;

import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class RecommendFragment extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    ItheimaRecyclerView recyclerView;

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;

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

                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);

                startActivity(intent);
            }
        });
    }

    private void initView() {

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(swipeRefreshLayout, recyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.home_item_recylerview;
            }

            @Override
            public String getApi() {
                //接口
                return "api/v4/news?news_type=3";
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            /*@Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);

                return true;
            }*/
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
        //控制加状态，可以在监听中处理


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
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
            //ivNewsPic.setImageURI(mData.getPic_url());
            tvNewsTitle.setText(mData.getTitle());
            tvNewsSource.setText(mData.getSource());
            tvPublishTime.setText(mData.getPublish_time());
            tvClick.setText(mData.getClick());
        }

    }
}
