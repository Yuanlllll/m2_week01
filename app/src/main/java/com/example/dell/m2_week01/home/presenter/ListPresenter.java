package com.example.dell.m2_week01.home.presenter;
import com.example.dell.m2_week01.api.Api;
import com.example.dell.m2_week01.fragment.ThiedFragment;

import com.example.dell.m2_week01.home.model.ListModel;


public class ListPresenter implements Ipresenter,ListModel.ModuleList
{
    private final ListModel listModel;
   ThiedFragment fragment;

    public ListPresenter(ThiedFragment fragment) {
        this.fragment = fragment;
        listModel = new ListModel(this);
    }





    @Override
    public void getPdata()
    {
        listModel.getmdata(Api.SHOPLIST);
        listModel.getBanner(Api.bannerurl);
    }

    @Override
    public void getSuccess(String data)
    {
        fragment.getVdata(data);

    }

    @Override
    public void getBanner(String data){
        fragment.getBannerData(data);
    }

    @Override
    public void getOnFail()
    {
        fragment.getVdata("加载失败");

    }
}
