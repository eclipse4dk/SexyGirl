package com.example.administrator.sexygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class GalleryActivity extends AppCompatActivity {

    @BindView(R.id.gallery_listview)
    ListView mGalleryListview;
    private List<GalleryBean.TngouBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        loadDataFromServer();
        mGalleryListview.setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int girlId = datas.get(position).getId();
            Intent intent = new Intent(GalleryActivity.this,GalleryDetailActivity.class);
            intent.putExtra("id",girlId);
            startActivity(intent);
        }
    };

    private void loadDataFromServer() {
        int id = getIntent().getIntExtra("id", 0);
        String url = "http://apis.baidu.com/tngou/gallery/list?id=" + id + "&page=1&rows=20";
        SexyGirlRequest<GalleryBean> request = new SexyGirlRequest<>(url, GalleryBean.class, mGalleryBeanListener, mErrorListener);
        NetworkManager.sendRequest(request);
    }

    private Response.Listener<GalleryBean> mGalleryBeanListener = new Response.Listener<GalleryBean>() {
        @Override
        public void onResponse(GalleryBean response) {
            datas = response.getTngou();
            mGalleryListview.setAdapter(adapter);
        }
    };

    private Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView==null) {
                convertView = LayoutInflater.from(GalleryActivity.this).inflate(R.layout.gallerylist_item,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            String url = "http://tnfs.tngou.net/image" + datas.get(position).getImg();
            Glide.with(GalleryActivity.this).load(url).bitmapTransform(new CropCircleTransformation(GalleryActivity.this)).into(holder.image);
            holder.title.setText(datas.get(position).getTitle());
            return convertView;
        }
    };

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
