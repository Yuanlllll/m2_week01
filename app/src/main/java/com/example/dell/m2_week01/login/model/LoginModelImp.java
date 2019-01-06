package com.example.dell.m2_week01.login.model;

import android.telecom.Call;

import com.example.dell.m2_week01.network.OkHttp3;


public class LoginModelImp implements ILoginModel {
    public static final String TAG = "LoginModelImp";

    @Override
    public void login(final String url, final String username, final String pwd, final ILoginCallBack loginCallBack) {



        //登录
        OkHttp3.OkHttpPost(url, username, pwd, new OkHttp3.GetMessListener() {
            @Override
            public void getMess(String s) {
                loginCallBack.onStatus(s);
            }
        });



    }

    //注册
    @Override
    public void regist(String url, String username, String pwd, final ILoginCallBack loginCallBack) {

        OkHttp3.OkHttpPost(url,username,pwd, new OkHttp3.GetMessListener() {
            @Override
            public void getMess(String s) {
                loginCallBack.onStatus(s);
            }
        });
    }
}

