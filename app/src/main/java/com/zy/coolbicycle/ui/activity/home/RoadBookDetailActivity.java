package com.zy.coolbicycle.ui.activity.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.NewsBean;
import com.zy.coolbicycle.bean.RoadBookDetailBean;

import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/14
 */
public class RoadBookDetailActivity extends AppCompatActivity {

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.iv_road_detail_image)
    ImageView ivRoadImage;
    @BindView(R.id.tv_road_detail_title)
    TextView tvRoadDetailTitle;
    @BindView(R.id.tv_like_count)
    TextView tvLikeCount;
    @BindView(R.id.rl_roadbook_recycler_viewa)
    ItheimaRecyclerView rlRoadbookRecyclerViewa;
    @BindView(R.id.road_detail_swipe_refresh_layout)
    SwipeRefreshLayout roadDetailSwipeRefreshLayout;
    @BindView(R.id.constraint_layout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.iv_road_creater_head)
    ImageView ivRoadCreaterHead;
    @BindView(R.id.tv_creater_name)
    TextView tvCreaterName;
    @BindView(R.id.tv_road_description)
    TextView tvRoadDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_roadbook_detail);
        ButterKnife.bind(this);
        showActionBar();
        //initView();
        initDate();

    }

    private void initDate() {
        String baseUrl = "api/v4/collection_info/?time=1586849681080&id=";
        int id = getIntent().getIntExtra("id", 0);

        Request request = ItheimaHttp.newGetRequest(baseUrl + id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<RoadBookDetailBean>() {

            @Override
            public void onResponse(RoadBookDetailBean roadBookDetailBean, Headers headers) {
                tvRoadDescription.setText(roadBookDetailBean.getDescription());
                tvRoadDetailTitle.setText(roadBookDetailBean.getTitle());
            }
        });
    }

   /* private void initView() {

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<RoadBookDetailBean>(roadDetailSwipeRefreshLayout, rlRoadbookRecyclerViewa, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.home_item_road_detail_recyclerview;
            }

            @Override
            public String getApi() {
                //行者路书接口
                String baseUrl = "api/v4/collection_info/?time=1586849681080&id=";
                int id = getIntent().getIntExtra("id", 0);
                System.out.println("+++++++++++++" + baseUrl + id);
                return baseUrl + id;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
        tvRoadDetailTitle.setText(roadBookDetailBean.getTitle());
        tvRoadDescription.setText(roadBookDetailBean.getDescription());
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<RoadBookDetailBean.CollectionBean> {
        @BindView(R.id.iv_road_image)
        ImageView ivRoadImage;
        @BindView(R.id.tv_road_title)
        TextView tvRoadTitle;
        @BindView(R.id.tv_total_distance)
        TextView tvTotalDistance;
        @BindView(R.id.tv_road_comment_count)
        TextView tvRoadCommentCount;
        @BindView(R.id.tv_road_dowmlaod_count)
        TextView tvRoadDowmlaodCount;
        //换成你布局文件中的id

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        *//**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         *//*
        @Override
        public void onBindRealData() {
            //tvRoadDescription.setText(mData.getDesc());
            //tvCreaterName.setText(mData.user_name);
            //ivRoadCreaterHead.setImageURI();
            //tvLikeCount.setText();
            //tvRoadDetailTitle.setText(mData.getTitle());
            *//*Glide.with(mContext) //设置context
                    .load(mData.getImage()) //图片url地址
                    .override(1080, 270)//固定大小
                    .centerCrop()//图片适应
                    .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                    .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                    .into(ivRoadImage);//图片显示的imageview*//*
            tvRoadTitle.setText(mData.getTitle());
            tvTotalDistance.setText(mData.getDistance() / 1000 + " km");
            tvRoadCommentCount.setText(mData.getComment_num());
            tvRoadDowmlaodCount.setText(mData.getDownload_time());

        }

    }

*/
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
        //顶部导航
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("路线集合");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
