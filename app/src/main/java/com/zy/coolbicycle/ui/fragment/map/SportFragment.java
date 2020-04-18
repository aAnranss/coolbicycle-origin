package com.zy.coolbicycle.ui.fragment.map;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
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
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.zy.coolbicycle.R;
import com.zy.coolbicycle.bean.WeatherBean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Headers;
import retrofit2.Call;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * 应用模块:导航
 * 类描述:
 * Created by 卢文钏 on 2020/4/1
 */
public class SportFragment extends Fragment {

    @BindView(R.id.bottom_sheet)
    RelativeLayout bottomSheet;
    @BindView(R.id.tv_location)
    TextView tvLocation;//当前定位
    @BindView(R.id.tv_temperature)
    TextView tvTemperature;//当前温度
    @BindView(R.id.tv_speed)
    TextView tvSpeed;//当前速度
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;//当前湿度
    @BindView(R.id.btn_start_sport)
    Button btnStartSport;//开始按钮
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.timer)
    Chronometer mTimer;//运动时间计时器

    BaiduMap mBaiduMap;
    @BindView(R.id.btn_finish_sport)
    Button btnFinishSport;//结束按钮
    @BindView(R.id.btn_continue_sport)
    Button btnContinueSport;//继续按钮
    @BindView(R.id.tv_date)
    TextView tvDate;//日期
    @BindView(R.id.tv_wind_direction)
    TextView tvWindDirection;//风向
    @BindView(R.id.tv_wind_strength)
    TextView tvWindStrength;//风力
    @BindView(R.id.tv_mileage)
    TextView tvMileage;//里程
    @BindView(R.id.tv_average_speed)
    TextView tvAverageSpeed;//平均时速
    private Unbinder unbinder;
    LocationClient mLocationClient;
    private boolean isStart = false; // 用于判断是否为开始状态
    private long recordingTime = 0;// 记录下来的总时间

    private String city = "来宾"; //默认值为来宾，不设默认值在无法定位时，会出现空指针异常的情况
    private String district;
    /*private List<LatLng> mLocationPoints;
    private Polyline mPolyline;*/

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
        getWeather();
        getDate();
        //drawRoute();
    }

    //utf-8转码
    private String enCode2Utf8(String city) {
        String cityUtf8Code = "";
        try {
            cityUtf8Code = URLEncoder.encode(city, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return cityUtf8Code;
    }


    /**
     * 获取当前时间
     */
    public void getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd"); //设置时间格式
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08")); //设置时区
        Date curDate = new Date(System.currentTimeMillis()); //获取当前时间
        String createDate = formatter.format(curDate);   //格式转换
        tvDate.setText(createDate);//日期
    }

    /**
     * 实时获取天气情况
     */
    public void getWeather() {
        String requestUrl = "http://apis.juhe.cn/simpleWeather/query?city=";
        String cityCode = enCode2Utf8(city); // 转码
        Request request = ItheimaHttp.newGetRequest(requestUrl + cityCode + "&key=4029ce459022ea4a73f79ec0ee2d9d7f");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<WeatherBean>() {
            @Override
            public void onResponse(WeatherBean weatherBean, Headers headers) {
                tvWindDirection.setText(weatherBean.getResult().getRealtime().getDirect() + weatherBean.getResult().getRealtime().getPower());//风向
                tvWindStrength.setText(weatherBean.getResult().getRealtime().getInfo());//风力
                tvHumidity.setText(weatherBean.getResult().getRealtime().getHumidity());//适度
                tvTemperature.setText(weatherBean.getResult().getRealtime().getTemperature());//温度
            }
        });
    }
    /**
     * 绘制行进路线轨迹
     */
    /*private void drawRoute() {
     *//**
     * 配置线段图层参数类： PolylineOptions
     * ooPolyline.width(13)：线宽
     * ooPolyline.color(0xAAFF0000)：线条颜色红色
     * ooPolyline.points(latLngs)：List<LatLng> mLocationPoints位置点，将相邻点与点连成线就成了轨迹了
     *//*
        OverlayOptions ooPolyline = new PolylineOptions().width(13).color(0xAAFF0000).points(mLocationPoints);

        //在地图上画出线条图层，mPolyline：线条图层
        mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
        mPolyline.setZIndex(3);
    }*/

    /**
     * 计时器开始计时+开始导航
     *
     * @param view
     */
    @OnClick(R.id.btn_start_sport)
    public void btnStartSportOnClick(View view) {
        if (!isStart) {

            mTimer.setBase(SystemClock.elapsedRealtime());//计时器清零
            int hour = (int) ((SystemClock.elapsedRealtime() - mTimer.getBase()) / 1000 / 60);
            mTimer.setFormat("0" + String.valueOf(hour) + ":%s");
            mTimer.start();
            isStart = true;
            btnStartSport.setText("暂停");
        } else {
            recordingTime = SystemClock.elapsedRealtime() - mTimer.getBase();// 保存这次记录了的时间
            mTimer.stop();
            btnStartSport.setText("开始");
            btnStartSport.setVisibility(GONE); // 隐藏开始按钮
            btnFinishSport.setVisibility(VISIBLE); // 显示停止计时按钮
            btnContinueSport.setVisibility(VISIBLE); // 显示继续计时按钮
        }
    }

    /**
     * 计时器结束计时 + 结束导航
     *
     * @param view
     */
    @OnClick(R.id.btn_finish_sport)
    public void btnFinishSportOnClick(View view) {
        recordingTime = 0;
        mTimer.setBase(SystemClock.elapsedRealtime());
        mTimer.stop();
        btnStartSport.setVisibility(VISIBLE);
        btnContinueSport.setVisibility(GONE);
        btnFinishSport.setVisibility(GONE);
    }

    /**
     * 计时器继续计时 + 继续导航
     *
     * @param view
     */
    @OnClick(R.id.btn_continue_sport)
    public void btnContinueSportOnClick(View view) {
        mTimer.setBase(SystemClock.elapsedRealtime() - recordingTime);// 跳过已经记录了的时间，起到继续计时的作用
        mTimer.start();//开始计时
        btnStartSport.setText("暂停");
        btnStartSport.setVisibility(VISIBLE);
        btnContinueSport.setVisibility(GONE);
        btnFinishSport.setVisibility(GONE);
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
        mBaiduMap.setTrafficEnabled(true); // 开启交通状况显示，参数为true时开启，false关闭
        //定位初始化
        mLocationClient = new LocationClient(getContext());

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
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
            city = location.getCity();
            district = location.getDistrict();
            tvLocation.setText(city + district);//获取当前定位城市和区县信息，并显示
            mBaiduMap.setMyLocationData(locData);
            //更新地图
            LatLng mNewCenter = new LatLng(location.getLatitude(), location.getLongitude());
            //将定位点加入集合
            /*mLocationPoints = new ArrayList<>();
            mLocationPoints.add(mNewCenter);*/
            MapStatus mapStatus = new MapStatus.Builder().target(mNewCenter).zoom(17).build();
            //构造MapStatusUpdate，描述地图状态将要发生的变化
            //MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(mNewCenter);
            MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
            //改变地图状态
            mBaiduMap.animateMapStatus(mapStatusUpdate);

        }
    }


    private void initData() {

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
