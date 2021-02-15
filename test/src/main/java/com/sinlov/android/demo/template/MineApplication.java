package com.sinlov.android.demo.template;

import android.app.Application;

import com.hjq.toast.ToastUtils;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}
