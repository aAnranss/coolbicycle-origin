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
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.RBean;
import com.zy.coolbicycle.bean.RoadBean;
import com.zy.coolbicycle.ui.activity.home.RDetailActivity;
import com.zy.coolbicycle.ui.activity.home.RoadBookDetailActivity;

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
 * Created by 卢文钏 on 2020/5/4
 */
public class RFragment extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.road_recycler_view)
    ItheimaRecyclerView roadRecyclerView;
    @BindView(R.id.road_swipe_refresh_layout)
    SwipeRefreshLayout roadSwipeRefreshLayout;

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;

    private int state = 0;  //判断下拉刷新  or  加载更多
    private static final int STATE_MORE = 1;    //加载更多
    private static final int STATE_REFRESH = 2; //下拉刷新
    private String nextPage = "";
    private List<RBean.RoutesBean> mListBean = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_road, null);
        unbinder = ButterKnife.bind(this,view);
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
                Intent intent = new Intent(getContext(), RDetailActivity.class);
                intent.putExtra("routeId",mListBean.get(position).getRouteId());
                intent.putExtra("routeName",mListBean.get(position).getRouteName());
                startActivity(intent);
                /*http://client.blackbirdsport.com/route_getRouteInfo?ton=n3FRhrsvN0xBhqYM&routeId=1816*/
            }
        });
    }

    private void initView() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<RBean>(roadSwipeRefreshLayout, roadRecyclerView, RFragment.MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.home_item_road_list;
                //return R.layout.road;
            }

            @Override
            public String getApi() {
                //接口
                String firstPageUrl = "http://client.blackbirdsport.com/route_getRoutesByHot?ton=n3FRhrsvN0xBhqYM&page=0";
                String url = "http://client.blackbirdsport.com/route_getRoutesByHot?ton=n3FRhrsvN0xBhqYM&page=";
                switch (state) {
                    case STATE_MORE:
                        //首页为0，mCurPage为1
                        //首页为1，mCurPage为2
                        //......以此类推，mCurPage当首页为mCurPage-1时，mCurPage即为下一页
                        //使用String包装类转换int类型的 mCurPage
                        nextPage = String.valueOf(mCurPage);
                        url += nextPage;    //字符串拼接
                        break;
                    case STATE_REFRESH:
                        break;
                }
                //若mCurPage为1，则返回首页的地址，否则返回通用url(自增页数)
                return mCurPage == 1 ? firstPageUrl : url;
                //接口
                //return "http://client.blackbirdsport.com/route_getRoutesByHot?ton=n3FRhrsvN0xBhqYM&page=0";
            }

            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                state = STATE_MORE;
                return true;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();

        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<RBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                state = STATE_REFRESH;
            }

            @Override
            public void onSuccess(RBean roadBean, Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                List<RBean.RoutesBean> itemDatas = roadBean.getItemDatas();
                for (RBean.RoutesBean itemData : itemDatas) {
                    mListBean.add(itemData);
                }

            }
        });
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<RBean.RoutesBean> {
        @BindView(R.id.iv_road_logo)
        ImageView ivRoadLogo;
        @BindView(R.id.tv_road_des)
        TextView tvRoadDes;
        @BindView(R.id.tv_road_views_counts)
        TextView tvRoadViewsCounts;
        @BindView(R.id.tv_road_name)
        TextView tvRoadName;
        @BindView(R.id.tv_road_location)
        TextView tvRoadLocation;

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

            System.out.println("+++++++++++++++++++++++");
            System.out.println("CityName:"+mData.getCityName());
            System.out.println("RouteName:"+mData.getRouteName());
            System.out.println("Distance:"+mData.getDistance());
            System.out.println("CommentCount:"+mData.getCommentCount());
            System.out.println("+++++++++++++++++++++++");
            Glide.with(mContext)
                    .load(mData.getLogo()) //图片url地址
                    .override(width - 80, (int) ((width / 2) * 0.9))//固定大小
                    .centerCrop()//图片适应
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivRoadLogo);//图片显示的imageview
            tvRoadName.setText(mData.getRouteName());
            tvRoadDes.setText(String.valueOf(mData.getDistance()/1000) + "km");
            tvRoadLocation.setText(mData.getCityName());
            tvRoadViewsCounts.setText(String.valueOf(mData.getCommentCount()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
