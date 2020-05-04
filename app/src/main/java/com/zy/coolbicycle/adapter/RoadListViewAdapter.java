package com.zy.coolbicycle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.RoadBookDetailBean;
import com.zy.coolbicycle.ui.activity.home.RoadBookDetailActivity;
import com.zy.coolbicycle.widget.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/28
 */
public class RoadListViewAdapter extends BaseAdapter {
    private RoadBookDetailActivity mContent;
    private List<RoadBookDetailBean.CollectionBean> mData;//定义数据。
    private LayoutInflater mInflater;//定义Inflater,加载我们自定义的布局。
    @BindView(R.id.iv_road_image)
    ImageView ivRoadImage;
    @BindView(R.id.road_detail_head)
    CircleImageView roadDetailHead;
    @BindView(R.id.tv_road_title)
    TextView tvRoadTitle;
    @BindView(R.id.tv_total_distance)
    TextView tvTotalDistance;
    @BindView(R.id.tv_road_comment_count)
    TextView tvRoadCommentCount;
    @BindView(R.id.tv_road_dowmlaod_count)
    TextView tvRoadDowmlaodCount;

    public RoadListViewAdapter(List<RoadBookDetailBean.CollectionBean> mData, LayoutInflater mInflater) {
        this.mData = mData;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = mInflater.inflate(R.layout.home_item_road_detail_recyclerview, null);
        RoadBookDetailBean.CollectionBean item = mData.get(position);
        tvRoadTitle.setText(item.getTitle());
        tvRoadCommentCount.setText(item.getComment_num());
        tvRoadDowmlaodCount.setText(item.getDownload_time());
        tvTotalDistance.setText(item.getDistance());
        Glide.with(mContent)
                .load(item.getImage()) //图片url地址
                .centerCrop()//图片适应
                .placeholder(R.mipmap.picture_loading) //加载时显示的图片
                .error(R.mipmap.picture_loading_error) //加载错误显示的图片
                .into(ivRoadImage);//图片显示的imageview
        return view;
    }


}
