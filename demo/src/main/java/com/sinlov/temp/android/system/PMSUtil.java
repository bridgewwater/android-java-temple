package com.sinlov.temp.android.system;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 2021/5/6.
 */
public final class PMSUtil {

    private static volatile boolean hasSelfDebugCheck = false;
    private static volatile boolean selfDebugCache = false;

    public static boolean isSelfDebug(Context context) {
        if (hasSelfDebugCheck) {
            return selfDebugCache;
        }
        synchronized (PMSUtil.class) {
            try {
                ApplicationInfo info = context.getApplicationInfo();
                selfDebugCache = (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
                hasSelfDebugCheck = true;
                return selfDebugCache;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取软件版本号
     *
     * @param context {@link Context}
     * @return 对应AndroidManifest.xml下android:versionCode
     */
    public static int selfVersionCode(@NonNull Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     *
     * @param context {@link Context}
     * @return 对应AndroidManifest.xml下android:versionName
     */
    public static String selfVersionName(@NonNull Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    /**
     * 获取当前 App 名称
     *
     * @param context {@link Context}
     * @return 对应AndroidManifest.xml下 android:label
     */
    public static String selfAppName(@NonNull Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            return context.getResources().getString(applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private PMSUtil() {
    }
}
