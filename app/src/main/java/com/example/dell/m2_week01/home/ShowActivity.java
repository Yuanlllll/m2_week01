/*
package com.example.dell.m2_week01.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.dell.m2_week01.R;
import com.example.dell.m2_week01.home.adapter.GAdapter1;
import com.example.dell.m2_week01.home.adapter.GAdapter2;
import com.example.dell.m2_week01.home.adapter.MyAdapter;
import com.example.dell.m2_week01.home.bean.BannerBean;
import com.example.dell.m2_week01.home.bean.ShowBean;
import com.example.dell.m2_week01.home.presenter.ListPresenter;
import com.example.dell.m2_week01.home.view.Iview;
import com.example.dell.m2_week01.xlistview.XListView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements Iview {


    private XListView xlist;
    private XBanner xBanner;
    private GridView grid_view1;
    private GridView grid_view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        xlist = findViewById(R.id.xlist);
        xBanner = findViewById(R.id.xbanner);
        grid_view1 = findViewById(R.id.grid_view1);
        grid_view2 = findViewById(R.id.grid_view2);


        ListPresenter listPresenter = new ListPresenter(this);
        listPresenter.getPdata();




    }

    @Override
    public void getVdata(final String vdata)
    {
        Gson gson=new Gson();
        final ShowBean userBean = gson.fromJson(vdata,ShowBean.class);
        new Thread(){
            @Override
            public void run() {
                super.run();
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {

                      GAdapter1 gadapter1=new GAdapter1(ShowActivity.this,userBean);
                      grid_view1.setAdapter(gadapter1);

                      MyAdapter adapter=new MyAdapter(ShowActivity.this,userBean.getResult());
                      xlist.setAdapter(adapter);

                      GAdapter2 gadapter2=new GAdapter2(ShowActivity.this,userBean);
                      grid_view2.setAdapter(gadapter2);

                  }
              });
         }
        }.start();

}

    @Override
    public void getBannerData(String bannerData) {
          Gson gson =new Gson();
        final BannerBean bannerBean = gson.fromJson(bannerData, BannerBean.class);
        runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  List<BannerBean.ResultBean> result = bannerBean.getResult();
                  final ArrayList<String> list=new ArrayList<>();
                  for (int i = 0; i < result.size(); i++) {
                      list.add(result.get(i).getImageUrl());
                  }
                  xBanner.setData(list,null);
                 xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                     @Override
                     public void loadBanner(XBanner banner, View view, int position) {
                         ImageLoader.getInstance().displayImage(list.get(position), (ImageView) view
                         );
                     }
                 });
                  xBanner.setPageTransformer(Transformer.Default);
                  xBanner.setmAutoPlayAble(true);
                  xBanner.setPageChangeDuration(1000);
              }
          });
    }
}
*/
