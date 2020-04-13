package com.zy.coolbicycle.ui.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.RoadBean;
import com.zy.coolbicycle.bean.RoadBookBean;
import com.zy.coolbicycle.ui.activity.home.NewsDetailActivity;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
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

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/11
 */
public class RoadFragment extends Fragment {
    private Unbinder unbinder;

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;

    @BindView(R.id.road_recycler_view)
    ItheimaRecyclerView roadRecyclerView;
    @BindView(R.id.road_swipe_refresh_layout)
    SwipeRefreshLayout roadSwipeRefreshLayout;

    private int state = 0;  //判断下拉刷新  or  加载更多
    private static final int STATE_MORE = 1;    //加载更多
    private static final int STATE_REFRESH = 2; //下拉刷新
    private String nextPage = "";
    private List<RoadBean.LushuCollectionBean> mListBean = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_road, null);
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

        ItemClickSupport itemClickSupport = new ItemClickSupport(roadRecyclerView);
        //新闻item的点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                //String h5_url = mListBean.get(position).getH5_url();//获取H5页面地址
                String title = mListBean.get(position).getTitle();
                Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                intent.putExtra("title", title);//传入标题
                //intent.putExtra("url", h5_url);//传入url
                startActivity(intent);
            }
        });
    }

    private void initView() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<RoadBean>(roadSwipeRefreshLayout, roadRecyclerView, RoadFragment.MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                //return R.layout.home_item_road_recyclerview;
                return R.layout.road;
            }

            @Override
            public String getApi() {
                //接口
                String firstPageUrl = "http://www.imxingzhe.com/api/v4/collection_list/?lng=109.49935913085938&province_id=1&time=1586595341150&page=1";
                String url = "http://www.imxingzhe.com/api/v4/collection_list/?lng=109.49935913085938&province_id=1&time=1586595341150&page=";
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
                return mCurPage == 1 ? firstPageUrl : url;
                //return "http://api.rabbitcycling.com/v2/route/list?access_token=YjkxYTJlZjhjZjg3ZjE4ZmFjZmUxNjNlMzc5MWNlZTExNmE5ZTVhMjdhMzFmMjlhZTMzMWZiYTc2MjJhNTdjYg";
            }

            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                state = STATE_MORE;
                return true;

            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<RoadBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                state = STATE_REFRESH;
            }

            @Override
            public void onSuccess(RoadBean roadBookBean, Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                List<RoadBean.LushuCollectionBean> itemDatas = roadBookBean.getItemDatas();
                for (RoadBean.LushuCollectionBean itemData : itemDatas) {
                    mListBean.add(itemData);
                }

            }
        });
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<RoadBean.LushuCollectionBean> {
        @BindView(R.id.iv_road_image)
        ImageView ivRoadImage;
        @BindView(R.id.tv_road_title)
        TextView tvRoadTitle;
        @BindView(R.id.tv_like_count)
        TextView tvLikeCount;

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            //获取屏幕尺寸
            WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics metrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;//获取到的是px，像素，绝对像素，需要转化为dpi

            /*Glide.with(mContext)
                    .load(mData.getThumb()) //图片url地址
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivRoadImage);//图片显示的imageview
            tvRoadTitle.setText(mData.getTitle());
            tvLikeCount.setText(mData.getVia());*/
            Glide.with(mContext)
                    .load(mData.getPic()) //图片url地址
                    .override(width - 80, (int) ((width / 2) * 0.9))//固定大小
                    .centerCrop()//图片适应
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivRoadImage);//图片显示的imageview
            tvRoadTitle.setText(mData.getTitle());
            tvLikeCount.setText(String.valueOf(mData.getLike_count()) + "人觉得行");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
