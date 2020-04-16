package com.zy.coolbicycle.ui.activity.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
import com.zy.coolbicycle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/14
 */
public class MapActivity extends AppCompatActivity {


    @BindView(R.id.bmapView)
    MapView mMapView;
    BaiduMap mBaiduMap;
    @BindView(R.id.normal)
    RadioButton normal;
    @BindView(R.id.statellite)
    RadioButton statellite;
    @BindView(R.id.RadioGroup)
    android.widget.RadioGroup RadioGroup;
    LocationClient mLocationClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_activity_map);
        ButterKnife.bind(this);
        initMap();
    }

    private void initMap() {
        //获取图层
        mBaiduMap = mMapView.getMap();
        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(3000);
        option.setIsNeedAddress(true);
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

            mBaiduMap.setMyLocationData(locData);
            //更新地图
            LatLng mNewCenter = new LatLng(location.getLatitude(), location.getLongitude());

            //构造MapStatusUpdate，描述地图状态将要发生的变化
            MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(mNewCenter);
            //改变地图状态
            //mBaiduMap.setMapStatus (mapStatusUpdate);
            mBaiduMap.animateMapStatus(mapStatusUpdate);

        }
    }

    public void setMapMode(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            // 普通图
            case R.id.normal:
                if (checked) {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                }
                break;
            // 卫星图
            case R.id.statellite:
                if (checked) {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
        // 在activity执行onResume时必须调用mMapView. onResume ()
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
        // 在activity执行onPause时必须调用mMapView. onPause ()
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

}
