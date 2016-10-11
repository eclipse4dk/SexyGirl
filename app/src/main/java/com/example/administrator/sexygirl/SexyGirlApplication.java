package com.example.administrator.sexygirl;

import android.app.Application;

/**
 * Created by DingK on 2016/10/11.
 */
public class SexyGirlApplication extends Application{
    public static final String TAG = "SexyGirlApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(getApplicationContext());
    }
}
