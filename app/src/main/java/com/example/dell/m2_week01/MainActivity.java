package com.example.dell.m2_week01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m2_week01.login.bean.User;
import com.example.dell.m2_week01.login.presenter.LoginPresenterImp;
import com.example.dell.m2_week01.login.view.ILoginView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ILoginView
{
    public static final String TAG="MainActivity";

    private TextView login_dl;
    private TextView login_zc;
    private EditText login_name;
    private EditText login_pswd;
    private LoginPresenterImp imp;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_dl = findViewById(R.id.login_dl);
        login_zc = findViewById(R.id.login_zc);
        login_name = findViewById(R.id.login_name);
        login_pswd = findViewById(R.id.login_pswd);
        tv = findViewById(R.id.tv);
        //初始化presenter
        imp = new LoginPresenterImp(this);

        login_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = login_name.getText().toString();
                String pswd = login_pswd.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pswd))
                {
                    Toast.makeText(MainActivity.this,"输入内容不能为空!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    imp.loginPre(name,pswd);

                }
            }
        });

        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册
                Intent intent=new Intent(MainActivity.this,ZcActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public void jumpActivity()
    {
        Log.d(TAG,"jumpActivity");


    }

    @Override
    public void getViewDatad(final String mViewDatad)
    {
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        User user = gson.fromJson(mViewDatad, User.class);
                        String message = user.getMessage();
                       //Log.d(TAG,message+"-------------------");
                        Toast.makeText(MainActivity.this,user.getMessage(),Toast.LENGTH_SHORT).show();
                        if (user.getMessage().equals("登录成功"))
                        {
                            //登录跳转
                            Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
                            startActivity(intent);
                            finish();

                        }
                        else{
                            Toast.makeText(MainActivity.this,user.getMessage(),Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        }.start();


    }
}
