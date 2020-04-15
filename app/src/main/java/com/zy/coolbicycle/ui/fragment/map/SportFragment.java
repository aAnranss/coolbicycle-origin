package com.zy.coolbicycle.ui.fragment.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.WeatherBean;
import com.zy.coolbicycle.ui.activity.map.MapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Headers;
import retrofit2.Call;

/**
 * 应用模块:导航
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class SportFragment extends Fragment {

    @BindView(R.id.bmapView)
    MapView mMapView;
    BaiduMap mBaiduMap;
    @BindView(R.id.bottom_sheet)
    RelativeLayout bottomSheet;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_temperature)
    TextView tvTemperature;
    @BindView(R.id.tv_temperature_unit)
    TextView tvTemperatureUnit;
    @BindView(R.id.tv_speed)
    TextView tvSpeed;
    @BindView(R.id.tv_speed_unit)
    TextView tvSpeedUnit;
    @BindView(R.id.tv_distance)
    TextView tvDistance;
    @BindView(R.id.tv_distance_unit)
    TextView tvDistanceUnit;
    @BindView(R.id.tv_123)
    TextView tv123;
    @BindView(R.id.tv_123_unit)
    TextView tv123Unit;
    @BindView(R.id.tv_456)
    TextView tv456;
    @BindView(R.id.tv_456_unit)
    TextView tv456Unit;
    @BindView(R.id.tv_789)
    TextView tv789;
    @BindView(R.id.tv_789_unit)
    TextView tv789Unit;
    @BindView(R.id.btn_start_sport)
    Button btnStartSport;

    private Unbinder unbinder;
    private LocationClient mLocationClient;//定位客户端

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_page, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMap();
        initView();
        initData();

    }


    @OnClick(R.id.btn_start_sport)
    public void btnStartSportOnClick(View view) {
        Intent intent = new Intent(getContext(), MapActivity.class);
        startActivity(intent);
    }


    /**
     * 初始化地图
     */
    private void initMap() {
        mBaiduMap = mMapView.getMap();
        //开启移动端定位图层
        mBaiduMap.setMyLocationEnabled(true);

        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                //这里是bottomSheet 状态的改变回调
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
                //下拉时不完全退出
                behavior.setPeekHeight(55);
            }
        });

        //定位初始化
        mLocationClient = new LocationClient(getContext());
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(3000);   //发起定位请求的间隔，默认为0（只定位一次）

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();
    }


    private void initData() {
        Request request = ItheimaHttp.newGetRequest("");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<WeatherBean>() {
            @Override
            public void onResponse(WeatherBean weatherBean, Headers headers) {

            }
        });

    }

    private void initView() {


    }//end of the iitView class

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())//获取定位精度，默认值为0.0f
                    .direction(location.getDirection())
                    .latitude(location.getLatitude())//获取纬度信息
                    .longitude(location.getLongitude())//获取经度信息
                    .build();
            mBaiduMap.setMyLocationData(locData);

            //将当前定位设置为地图的中心
            LatLng mNewCenter = new LatLng(location.getLatitude(), location.getLongitude());//设置经纬度
            //构造MapStatusUpdate实例，描述地图即将发生变化
            MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(mNewCenter);
            //改变地图状态
            mBaiduMap.setMapStatus(mapStatusUpdate);
        }
    }//end of the MyLocationListener class


    @Override
    public void onDestroyView() {

        mLocationClient.stop();//停止定位
        mBaiduMap.setMyLocationEnabled(false);//关闭图层
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();

    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }
}//end of the class
