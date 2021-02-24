package com.sinlov.temp.android.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

public class RunThreadUtils {

    /**
     * run thread on UI Thread
     * @param act {@link Activity}
     * @param action {@link Runnable}
     */
    public static void onUI(Activity act, Runnable action) {
        if (null != act && null != action) {
            act.runOnUiThread(action);
        } else {
            new NullPointerException("run onUI is empty with Activity or Runnable").printStackTrace();
        }
    }

    /**
     * this runnable is not on UI Thread
     * @param action {@link Runnable}
     * @param delayMillis long of time
     */
    public static void delay(Runnable action, long delayMillis) {
        delay(action, delayMillis, false);
    }

    /**
     *
     * @param action {@link Runnable}
     * @param delayMillis long of time
     * @param isOnUIThread boolean
     */
    public static void delay(Runnable action, long delayMillis, boolean isOnUIThread) {
        if (null != action) {
            if (isOnUIThread) {
                new Handler(Looper.getMainLooper()).postDelayed(action, delayMillis);
            } else {
                new Handler().postDelayed(action, delayMillis);
            }
        } else {
            new NullPointerException("run delay is empty with Runnable").printStackTrace();
        }
    }

    /**
     * default is not run on UI Thread
     * @param action {@link Runnable}
     */
    public static void post(Runnable action){
        post(action, false);
    }

    /**
     * post runnable
     * @param action {@link Runnable}
     * @param isOnUIThread boolean
     */
    public static void post(Runnable action, boolean isOnUIThread) {
        if (null != action) {
            if (isOnUIThread) {
                new Handler(Looper.getMainLooper()).post(action);
            } else {
                new Handler().post(action);
            }
        } else {
            new NullPointerException("run post is empty with Runnable").printStackTrace();
        }
    }

    private RunThreadUtils() {
    }
}
