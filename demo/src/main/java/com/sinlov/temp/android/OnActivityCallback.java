package com.sinlov.temp.android;

import android.content.Intent;

import androidx.annotation.Nullable;

public interface OnActivityCallback {
    /**
     * Activity 回调
     *
     * @param code 结果码
     * @param data 数据
     */
    void onActivityResult(int code, @Nullable Intent data);
}