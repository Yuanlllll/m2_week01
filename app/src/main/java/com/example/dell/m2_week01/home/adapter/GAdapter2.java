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

public class GAdapter2 extends BaseAdapter {

    private Context context;
    private ShowBean showbean;

    public GAdapter2(Context context, ShowBean showbean) {
        this.context = context;
        this.showbean = showbean;
    }
    @Override
    public int getCount() {
        return showbean.getResult().getPzsh().get(0).getCommodityList().size();
    }

    @Override
    public Object getItem(int position) {
        return showbean.getResult().getPzsh().get(0).getCommodityList().get(position);
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
            convertView = View.inflate(context, R.layout.s3_layout, null);
            holder = new ViewHolder();

            holder.gimg2 = convertView.findViewById(R.id.gimg2);
            holder.title_list2 = convertView.findViewById(R.id.title_list2);
            holder.price_list2 = convertView.findViewById(R.id.price_list2);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.price_list2.setText("¥"+showbean.getResult().getPzsh().get(0).getCommodityList().get(position).getPrice()+"");
        holder.title_list2.setText(showbean.getResult().getPzsh().get(0).getCommodityList().get(position).getCommodityName());
        ImageLoader.getInstance().displayImage(showbean.getResult().getPzsh().get(0).getCommodityList().get(position).getMasterPic(),holder.gimg2);
        return convertView;
    }

    class ViewHolder {
        private ImageView gimg2;
        private TextView title_list2,price_list2;

    }

}
