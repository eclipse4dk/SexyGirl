package com.example.administrator.sexygirl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by DingK on 2016/10/13.
 */
public class GalleryAdapter extends SexyGirlBasedAdapter<GalleryBean.TngouBean> {
    public static final String TAG = "GalleryAdapter";

    public GalleryAdapter(List<GalleryBean.TngouBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gallerylist_item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String url = "http://tnfs.tngou.net/image" + datas.get(position).getImg();
        Glide.with(context).load(url).bitmapTransform(new CropCircleTransformation(context)).into(holder.image);
        holder.title.setText(datas.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.gallery_list_item_image)
        ImageView image;
        @BindView(R.id.gallery_list_item_title)
        TextView title;
        public ViewHolder(View v) {
            ButterKnife.bind(this,v);
        }
    }
}
