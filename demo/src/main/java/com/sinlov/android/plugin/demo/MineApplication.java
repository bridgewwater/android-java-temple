package com.sinlov.android.plugin.demo;

import android.app.Application;

import com.hjq.toast.ToastUtils;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initSDK() {
        ToastUtils.init(this);
    }
}
