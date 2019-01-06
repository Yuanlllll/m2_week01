package com.example.dell.m2_week01.login.model;

public interface ILoginModel
{
    //登录
     void login(String url, String username, String pwd, ILoginCallBack loginCallBack);
    //注册
     void regist(String url, String username, String pwd, ILoginCallBack loginCallBack);

    //定义接口
    interface ILoginCallBack
    {
        public void onStatus(String data);
        public void onFailed();
    }
}
