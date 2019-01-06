package com.example.dell.m2_week01.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.m2_week01.R;
import com.example.dell.m2_week01.home.bean.ShowBean;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GAdapter1 extends BaseAdapter {
   private Context context;
   private ShowBean showbean;

    public GAdapter1(Context context, ShowBean showbean) {
        this.context = context;
        this.showbean = showbean;
    }

    @Override
    public int getCount() {
        return showbean.getResult().getRxxp().get(0).getCommodityList().size();
    }

    @Override
    public Object getItem(int position) {
        return showbean.getResult().getRxxp().get(0).getCommodityList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = View.inflate(context, R.layout.s2_layout, null);
            holder = new ViewHolder();

            holder.gimg1 = convertView.findViewById(R.id.gimg1);
            holder.title_list = convertView.findViewById(R.id.title_list);
            holder.price_list = convertView.findViewById(R.id.price_list);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.price_list.setText("¥"+showbean.getResult().getRxxp().get(0).getCommodityList().get(position).getPrice()+"");
        holder.title_list.setText(showbean.getResult().getRxxp().get(0).getCommodityList().get(position).getCommodityName());
        ImageLoader.getInstance().displayImage(showbean.getResult().getRxxp().get(0).getCommodityList().get(position).getMasterPic(),holder.gimg1);
        return convertView;
    }

    class ViewHolder {
        private ImageView gimg1;
        private TextView title_list,price_list;

    }

}
