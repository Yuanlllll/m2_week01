package com.example.dell.m2_week01.home.model;



import android.util.Log;

import com.example.dell.m2_week01.network.OkHttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ListModel implements Imodel
{
    public static final String TAG="ListModel";
    ModuleList moduleList;

    public ListModel(ModuleList moduleList)
    {
        this.moduleList = moduleList;
    }

    //网络请求数据
    @Override
    public void getmdata(final String url)
    {
        OkHttp3.OkHttpget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                moduleList.getOnFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                moduleList.getSuccess(response.body().string());
            }
        });
    }

    @Override
    public void getBanner(String data) {
        OkHttp3.OkHttpget(data, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                   moduleList.getBanner(response.body().string());
            }
        });
    }


    //定义接口
    public interface ModuleList
    {
        //接口中的方法
         void getSuccess(String data);
         void getBanner(String data);
         void getOnFail();
    }
}
