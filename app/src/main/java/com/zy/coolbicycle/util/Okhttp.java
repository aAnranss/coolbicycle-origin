package com.zy.coolbicycle.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 *Create by Pixiu
 *QQ：1326227115
 *on 2019/7/18
 */
public class Okhttp {
    private OkHttpClient okHttpClient;
    //将线程切换到主线程 为了可以更新ui
    private Handler handler=new Handler(Looper.getMainLooper());
    //转换格式为UTF8
    private static  final MediaType JSON=MediaType.parse("application/json:charset=utf-8");
    //定义接口 回调成功的方法
    public interface Getdata{
        void successful(String s);
        void failed();
    }
    public  interface  GetByte{
        void successful(byte[] s);
        void failed();
    }
    //网络请求方法
    public void setOkHttpClient(final String url, final String info, final Getdata getdata){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getdata!=null){
                    okHttpClient=new OkHttpClient();
                    RequestBody body=RequestBody.create(JSON,info);
                    Request request=new Request.Builder()
                            .url(url)
                            .post(body)
                            .build();
                    try {
                        Response response=okHttpClient.newCall(request).execute();
                        final String string = response.body().string();
                        //转到主线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //得到的结果回调到成功的方法
                                getdata.successful(string);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        getdata.failed();
                    }
                }
            }
        }).start();

    }
    //网络请求方法
    public void setOkHttpClientByte(final String url, final String info, final GetByte getdata){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getdata!=null){
                    okHttpClient=new OkHttpClient();
                    RequestBody body=RequestBody.create(JSON,info);
                    Request request=new Request.Builder()
                            .url(url)
                            .post(body)
                            .build();
                    try {
                        Response response=okHttpClient.newCall(request).execute();
                        final byte[] bytes = response.body().bytes();
                        //转到主线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //得到的结果回调到成功的方法
                                getdata.successful(bytes);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        getdata.failed();
                    }
                }
            }
        }).start();

    }

    public void upload(final String url, final String imagePath, final String filename, final Getdata getdata)  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getdata != null) {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Log.d("imagePath", imagePath);
                    File file = new File(imagePath);
                    MultipartBody.Builder builder = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("img", filename,
                                    RequestBody.create(MediaType.parse("image/jpg"), file));

                    RequestBody requestBody = builder.build();
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    try {
                        Response response = okHttpClient.newCall(request).execute();
                        final String string = response.body().string();
                        //转到主线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //得到的结果回调到成功的方法
                                getdata.successful(string);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        getdata.failed();
                    }
                }
            }
        }).start();

    }



    public void setOkHttpClientpicturl(final String url, final String path, final Getdata getdata){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getdata!=null){
                    OkHttpClient mOkHttpClent = new OkHttpClient();
                    System.out.println(path);
                    File file = new File(path);
                    MultipartBody.Builder builder = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("img", file.getName(),
                                    RequestBody.create(  MediaType.parse("image/png"), file));

                    RequestBody requestBody = builder.build();
                    Request request = new Request.Builder()
                            .url(url+"upload")
                            .post(requestBody)
                            .build();
                    try {
                        Response response=okHttpClient.newCall(request).execute();
                        final String string = response.body().string();
                        //转到主线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //得到的结果回调到成功的方法
                                getdata.successful(string);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        getdata.failed();
                    }
                }
            }
        }).start();
    }




}