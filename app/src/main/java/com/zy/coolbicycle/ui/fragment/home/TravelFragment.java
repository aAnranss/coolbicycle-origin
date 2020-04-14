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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.NewsBean;
import com.zy.coolbicycle.bean.TravelBean;
import com.zy.coolbicycle.ui.activity.home.NewsDetailActivity;
import com.zy.coolbicycle.ui.activity.home.TravelDetailActivity;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Headers;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/10
 */
public class TravelFragment extends Fragment {
    private Unbinder unbinder;
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.travel_recycler_view)
    ItheimaRecyclerView travelRecyclerView;
    @BindView(R.id.travel_swipe_refresh_layout)
    SwipeRefreshLayout travelSwipeRefreshLayout;

    private int state = 0;  //判断下拉刷新  or  加载更多
    private static final int STATE_MORE = 1;    //加载更多
    private static final int STATE_REFRESH = 2; //下拉刷新
    private String nextPage = "";
    private List<TravelBean.VariablesBean.ForumThreadlistBean> mForumThreadlistBean = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_travel, null);
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

        ItemClickSupport itemClickSupport = new ItemClickSupport(travelRecyclerView);
        //新闻item的点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getContext(), TravelDetailActivity.class);
                intent.putExtra("tid",mForumThreadlistBean.get(position).getTid());
                intent.putExtra("title",mForumThreadlistBean.get(position).getSubject());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<TravelBean>(travelSwipeRefreshLayout, travelRecyclerView, TravelFragment.MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.home_item_travel_recyclerview;
            }

            @Override
            public String getApi() {
                //美骑网骑行游记接口
                String firstPageUrl = "https://bbs.biketo.com/api/mobile/index.php?module=forumdisplay&fid=72&filter=&orderby=lastpost&page=1&version=5";
                String baseUrl = "https://bbs.biketo.com/api/mobile/index.php?module=forumdisplay&fid=72&filter=&orderby=lastpost&page=";
                String rearUrl = "&version=5";
                String completeUrl = "";
                switch (state) {
                    case STATE_MORE:
                        //使用String包装类转换int类型的 mCurPage+1(当前页的下一页)
                        nextPage = String.valueOf(mCurPage + 1);
                        completeUrl = baseUrl + nextPage + rearUrl;    //字符串拼接
                        break;
                    case STATE_REFRESH:
                        break;
                }

                return mCurPage == 1 ? firstPageUrl : completeUrl;
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
        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<TravelBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                state = STATE_REFRESH;
            }

            @Override
            public void onSuccess(TravelBean travelBean, Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                List<TravelBean.VariablesBean.ForumThreadlistBean> itemDatas = travelBean.getItemDatas();
                for (TravelBean.VariablesBean.ForumThreadlistBean itemData : itemDatas) {
                    mForumThreadlistBean.add(itemData);
                }

            }
        });
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<TravelBean.VariablesBean.ForumThreadlistBean> {

        @BindView(R.id.iv_blog_avatar)
        ImageView ivBlogAvatar;
        @BindView(R.id.tv_blog_author_name)
        TextView tvBlogAuthorName;
        @BindView(R.id.tv_blog_publish_time)
        TextView tvBlogPublishTime;
        @BindView(R.id.iv_blog_pic)
        ImageView ivBlogPic;
        @BindView(R.id.tv_blog_title)
        TextView tvBlogTitle;
        @BindView(R.id.tv_blog_content)
        TextView tvBlogContent;
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
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
            //String dateString = formatter.format(mData.getDateline());
            //加载头像
            Glide.with(mContext) //设置context
                    .load(mData.getAvatar()) //图片url地址
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))//圆角
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivBlogAvatar);//图片显示的imageview
            //加载博客图片
            Glide.with(mContext) //设置context
                    .load(mData.getCoverpath()) //图片url地址
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivBlogPic);//图片显示的imageview

            tvBlogAuthorName.setText(mData.getAuthor());
            tvBlogPublishTime.setText(mData.getLastpost());
            tvBlogTitle.setText(mData.getSubject());
            tvBlogContent.setText(mData.getMsginfos());
            tvClick.setText(mData.getViews());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
