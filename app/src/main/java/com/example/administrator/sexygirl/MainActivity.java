package com.example.administrator.sexygirl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<ClassifyBean.TngouBean> datas;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        String url = "http://apis.baidu.com/tngou/gallery/classify";
        SexyGirlRequest<ClassifyBean> request = new SexyGirlRequest<ClassifyBean>(url, ClassifyBean.class, ClassifyBeanListener, ErrorListener);
        NetworkManager.sendRequest(request);
    }

    private Response.Listener<ClassifyBean> ClassifyBeanListener = new Response.Listener<ClassifyBean>() {
        @Override
        public void onResponse(ClassifyBean response) {
            datas = response.getTngou();
            listview.setAdapter(adapter);
        }
    };

    private Response.ErrorListener ErrorListener = new Response.ErrorListener() {
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
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(datas.get(position).getTitle());
            return convertView;
        }
    };

    public class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        public ViewHolder(View v) {
            ButterKnife.bind(this,v);
        }
    }

}
