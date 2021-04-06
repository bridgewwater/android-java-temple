package com.sinlov.temp.android.action;

import android.view.Gravity;

import androidx.annotation.StringRes;

import com.hjq.toast.ToastUtils;

/**
 * toast 意图
 */
public interface TempToastAction {
    default void toast(CharSequence text) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show(text);
    }

    default void toast(@StringRes int id) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show(id);
    }

    default void toast(Object object) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.show(object);
    }

    default void toastBottom(@StringRes int id) {
        ToastUtils.setGravity(Gravity.BOTTOM, 0, 64);
        ToastUtils.show(id);
    }

    default void toastBottom(CharSequence text) {
        ToastUtils.setGravity(Gravity.BOTTOM, 0, 64);
        ToastUtils.show(text);
    }

    default void toastBottom(Object object) {
        ToastUtils.setGravity(Gravity.BOTTOM, 0, 64);
        ToastUtils.show(object);
    }
}
