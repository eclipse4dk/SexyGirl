package com.example.administrator.sexygirl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DingK on 2016/10/13.
 */
public class ClassifyAdapetr extends SexyGirlBasedAdapter<ClassifyBean.TngouBean> {
    public static final String TAG = "ClassifyAdapetr";

    public ClassifyAdapetr(List<ClassifyBean.TngouBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(datas.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        public ViewHolder(View v) {
            ButterKnife.bind(this,v);
        }
    }
}
