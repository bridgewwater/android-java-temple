package com.demo.android.temp;

import android.app.Application;

import com.hjq.toast.ToastUtils;

/**
 * @author sinlov
 */
public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}
