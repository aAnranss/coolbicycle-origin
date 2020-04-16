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

import com.baidu.location.Address;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.ui.activity.map.MapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 应用模块:导航
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class SportFragment extends Fragment {

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
    @BindView(R.id.bmapView)
    MapView mMapView;

    BaiduMap mBaiduMap;
    private Unbinder unbinder;
    LocationClient mLocationClient;

    private String address;
    private String province;
    private String city;
    private String district;
    private String street;

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
        //获取图层
        mBaiduMap = mMapView.getMap();
        UiSettings uiSettings = mBaiduMap.getUiSettings();
        //显示指南针
        uiSettings.setCompassEnabled(true);

        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mLocationClient = new LocationClient(getContext());

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(3000);
        option.setIsNeedAddress(true);
        option.setIsNeedLocationDescribe(true);
        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者
        option.setOpenAutoNotifyMode();
        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();

    }

    //构造地图数据
    //我们通过继承抽象类BDAbstractListener并重写其onReceieveLocation方法来获取定位数据，并将其传给MapView。
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            tvLocation.setText(location.getCity()+location.getDistrict());
            /*System.out.println("获取详细地址信息："+location.getAddrStr());//获取详细地址信息
            System.out.println("获取省份："+location.getProvince());//获取省份
            System.out.println("获取城市："+location.getCity()); //获取城市
            System.out.println("获取街道信息："+location.getStreet()); //获取街道信息
            System.out.println("获取区县："+location.getDistrict()); //获取区县*/
            mBaiduMap.setMyLocationData(locData);
            //更新地图
            LatLng mNewCenter = new LatLng(location.getLatitude(), location.getLongitude());

            MapStatus mapStatus = new MapStatus.Builder().target(mNewCenter).zoom(17).build();
            //构造MapStatusUpdate，描述地图状态将要发生的变化
            //MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(mNewCenter);
            MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
            //改变地图状态
            mBaiduMap.animateMapStatus(mapStatusUpdate);

        }
    }


    private void initData() {
        Address address;

    }

    /**
     * 底部抽屉
     */
    private void initView() {

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
                behavior.setPeekHeight(60);
            }
        });
    }


    @Override
    public void onDestroyView() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
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
}
