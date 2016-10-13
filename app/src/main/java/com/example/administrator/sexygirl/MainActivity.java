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

public class MainActivity extends AppCompatActivity {

    private List<ClassifyBean.TngouBean> datas;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
    loadDataFromServer();
        listview.setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
            intent.putExtra("id",position);
            startActivity(intent);
        }
    };

    private void loadDataFromServer() {
        String url = "http://apis.baidu.com/tngou/gallery/classify";
        SexyGirlRequest<ClassifyBean> request = new SexyGirlRequest<ClassifyBean>(url, ClassifyBean.class, ClassifyBeanListener, ErrorListener);
        NetworkManager.sendRequest(request);
    }

    private Response.Listener<ClassifyBean> ClassifyBeanListener = new Response.Listener<ClassifyBean>() {
        @Override
        public void onResponse(ClassifyBean response) {
            datas = response.getTngou();
            ClassifyAdapetr adapter = new ClassifyAdapetr(datas,MainActivity.this);
            listview.setAdapter(adapter);
        }
    };

    private Response.ErrorListener ErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

}
