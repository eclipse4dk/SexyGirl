package com.example.administrator.sexygirl;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by DingK on 2016/10/13.
 */
public abstract class SexyGirlBasedAdapter<T> extends BaseAdapter{
    public static final String TAG = "SexyGirlBasedAdapter";

    protected List<T> datas;
    protected Context context;

    public SexyGirlBasedAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(datas==null) {
            return 0;
        }else {
            return datas.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
