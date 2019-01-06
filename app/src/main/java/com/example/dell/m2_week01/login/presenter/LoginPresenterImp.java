package com.example.dell.m2_week01.login.presenter;

import android.util.Log;

import com.example.dell.m2_week01.MainActivity;
import com.example.dell.m2_week01.ZcActivity;
import com.example.dell.m2_week01.api.Api;
import com.example.dell.m2_week01.login.model.ILoginModel;
import com.example.dell.m2_week01.login.model.LoginModelImp;

public class LoginPresenterImp implements ILoginPresenter
{

    public static final String TAG="LoginPresenterImp";
    private final LoginModelImp loginModelImp;
    MainActivity mainActivity;
    ZcActivity zcActivity;

    //注册
    public LoginPresenterImp(ZcActivity zcActivity) {
        this.zcActivity = zcActivity;
        loginModelImp = new LoginModelImp();
    }

          //登录
 public LoginPresenterImp(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        //初始化model
        loginModelImp = new LoginModelImp();
    }

    @Override
    public void loginPre(String name, String pswd)
    {
        loginModelImp.login(Api.LOGIN, name, pswd, new ILoginModel.ILoginCallBack() {
            @Override
            public void onStatus(String data) {
                //Log.d(TAG, "onStatus: "+data);
                mainActivity.getViewDatad(data);
            }

            @Override
            public void onFailed()
            {
                mainActivity.getViewDatad("失败");

            }
        });

    }

    //注册
    @Override
    public void registPre(String name, String pswd)
    {
        loginModelImp.regist(Api.ZC, name, pswd, new ILoginModel.ILoginCallBack() {
            @Override
            public void onStatus(String data) {
                zcActivity.getViewDatad(data);
                zcActivity.jumpActivity();

            }

            @Override
            public void onFailed() {

            }
        });

    }
}
