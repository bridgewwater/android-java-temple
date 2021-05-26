package com.sinlov.android.plugin.demo;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.sinlov.temp.android.system.AMLUtil;
import com.sinlov.temp.android.utils.log.LoggerPrintTree;

import timber.log.Timber;


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
        if (BuildConfig.DEBUG) {
            Timber.plant(new LoggerPrintTree());
            Timber.tag("MineApplication");
            Timber.d("just open log print");
        }
        AMLUtil.getInstance()
                .init(application)
                .setDebug(true);
        ToastUtils.init(application);
    }
}
