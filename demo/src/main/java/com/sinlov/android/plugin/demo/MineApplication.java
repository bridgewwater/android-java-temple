package com.sinlov.android.plugin.demo;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.sinlov.temp.android.system.AMLUtil;


public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initSDK(Application application) {
        AMLUtil.getInstance()
                .init(application)
                .setDebug(true);
        ToastUtils.init(application);
    }
}
