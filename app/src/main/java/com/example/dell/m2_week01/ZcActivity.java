package com.example.dell.m2_week01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.m2_week01.login.bean.ZcBean;
import com.example.dell.m2_week01.login.presenter.LoginPresenterImp;
import com.example.dell.m2_week01.login.view.ILoginView;
import com.google.gson.Gson;

public class ZcActivity extends AppCompatActivity implements ILoginView {

    private EditText zc_name;
    private EditText zc_pswd;
    private Button btn_zc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        zc_name = findViewById(R.id.zc_name);
        zc_pswd = findViewById(R.id.zc_pswd);
        btn_zc = findViewById(R.id.btn_zc);

        final LoginPresenterImp presenterImp = new LoginPresenterImp(this);
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = zc_name.getText().toString();
                String pwd = zc_pswd.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(ZcActivity.this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    presenterImp.registPre(name,pwd);
                }
            }
        });
    }

    @Override
    public void jumpActivity() {

    }

    @Override
    public void getViewDatad(final String mViewDatad)
    {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                ZcBean zcBean = gson.fromJson(mViewDatad, ZcBean.class);
                String status = zcBean.getMessage();
                Toast.makeText(ZcActivity.this,zcBean.getMessage(),Toast.LENGTH_SHORT).show();
                if (status.equals("注册成功"))
                {
                    Intent intent = new Intent(ZcActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }






            }
        });

    }
}
