package com.example.administrator.sexygirl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryDetailActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra("id", 0);
        String url = "http://www.tngou.net/tnfs/show/" + id;
        mWebview.loadUrl(url);
    }
}
