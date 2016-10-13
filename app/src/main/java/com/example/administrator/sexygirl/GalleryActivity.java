package com.example.administrator.sexygirl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
            GalleryAdapter adapter = new GalleryAdapter(datas,GalleryActivity.this);
            mGalleryListview.setAdapter(adapter);
        }
    };

    private Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

}
