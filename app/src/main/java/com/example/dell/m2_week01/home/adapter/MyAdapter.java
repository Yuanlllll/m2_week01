package com.example.dell.m2_week01.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.m2_week01.R;
import com.example.dell.m2_week01.home.bean.ShowBean;
import com.example.dell.m2_week01.login.bean.User;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ShowBean.ResultBean userBean;

    public MyAdapter(Context context, ShowBean.ResultBean userBean) {
        this.context = context;
        this.userBean = userBean;
    }

    @Override
    public int getCount() {
        return userBean.getMlss().size();
    }

    @Override
    public Object getItem(int position) {
        return userBean.getMlss().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
           convertView = View.inflate(context, R.layout.ss_layout, null);
            holder = new ViewHolder();

            holder.text_title = convertView.findViewById(R.id.text_title);
            holder.text_price = convertView.findViewById(R.id.text_price);
            holder.img_view = convertView.findViewById(R.id.img);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

                holder.text_title.setText(userBean.getMlss().get(position).getCommodityList().get(position).getCommodityName());
                holder.text_price.setText("¥"+userBean.getMlss().get(position).getCommodityList().get(position).getPrice()+"");
                ImageLoader.getInstance().displayImage(userBean.getMlss().get(position).getCommodityList().get(position).getMasterPic(),holder.img_view);
                return convertView;
       }

    class ViewHolder {
        private ImageView img_view;
        private TextView text_title,text_price;

    }

    }


