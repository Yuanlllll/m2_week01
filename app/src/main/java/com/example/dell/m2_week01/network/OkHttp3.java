package com.example.dell.m2_week01.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public  class OkHttp3 {
    public static final String TAG="OkHttp3";
    private static OkHttpClient okHttpClient;
    private static Request request;
    private static RequestBody builder;
    private GetMessListener getMessListener;

    /*
     * okhttp get异步请求方法
     * */
    public static void  OkHttpget(String url,Callback call){
        //创建okHttpClient
        okHttpClient = new OkHttpClient();
        //创建request
        request = new Request.Builder().url(url).method("GET",null).build();
        //
        okHttpClient.newCall(request).enqueue(call);

    }
    //okhttp post请求
    public static  void OkHttpPost(String url, String name, String pswd, final GetMessListener getMessListener){
        okHttpClient = new OkHttpClient();
        builder = new FormBody.Builder()
                .add("phone",name)
                .add("pwd",pswd)
                .build();
        //创建request
        request = new Request.Builder().url(url).post(builder).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Log.d(TAG, "onResponse: "+response.body().string());
                getMessListener.getMess(response.body().string());
            }
        });

    }


    public interface GetMessListener{
         void getMess(String s);
    }

}
