package com.example.dell.m2_week01.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ThiedFragment extends Fragment implements Iview {
    private XListView xlist;
    private XBanner xBanner;
    private GridView grid_view1;
    private GridView grid_view2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third, container, false);
        xlist = view.findViewById(R.id.xlist);
        xBanner = view.findViewById(R.id.xbanner);
        grid_view1 = view.findViewById(R.id.grid_view1);
        grid_view2 = view.findViewById(R.id.grid_view2);


        ListPresenter listPresenter = new ListPresenter(this);
        listPresenter.getPdata();

        return view;
    }

    @Override
    public void getVdata(String vdata)
    {
        Gson gson=new Gson();
        final ShowBean userBean = gson.fromJson(vdata,ShowBean.class);
        new Thread(){
            @Override
            public void run() {
                super.run();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        GAdapter1 gadapter1=new GAdapter1(getActivity(),userBean);
                        grid_view1.setAdapter(gadapter1);

                        MyAdapter adapter=new MyAdapter(getActivity(),userBean.getResult());
                        xlist.setAdapter(adapter);

                        GAdapter2 gadapter2=new GAdapter2(getActivity(),userBean);
                        grid_view2.setAdapter(gadapter2);

                    }
                });
            }
        }.start();


    }

    @Override
    public void getBannerData(String bannerData)
    {
        Gson gson =new Gson();
        final BannerBean bannerBean = gson.fromJson(bannerData, BannerBean.class);
        getActivity().runOnUiThread(new Runnable() {
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
