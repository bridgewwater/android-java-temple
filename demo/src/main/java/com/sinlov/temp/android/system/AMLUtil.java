package com.sinlov.temp.android.system;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;

/**
 * Activity Lifecycle 管理类
 * <br/>
 * 在 Application 的声明周期 {@link Application#onCreate()} 中使用
 * <pre>
 *        // Activity 栈管理初始化，默认会读取 apk debug 状态，打开日志
 *         boolean isDebug = AMLUtil.getInstance()
 *                 .init(application)
 *                 .isDebug();
 *        // 也可以强制关闭 Debug
 *        AMLUtil.getInstance()
 *                 .init(application)
 *                 .setDebug(false);
 * </pre>
 * 功能
 * <pre>
 *        // 安全获取 application
 *        AMLUtil.getInstance().getApplication();
 *        // 获取当前栈顶 Activity
 *        AMLUtil.getInstance().getTopActivity()
 *        // 内存优化，销毁掉所有的界面
 *        AMLUtil.getInstance().finishAllActivities();
 *        // 内存优化，销毁除登录页之外的所有界面
 *        AMLUtil.getInstance().finishAllActivities(LoginActivity.class);
 *        // 判断当前应用是否处于前台状态
 *        AMLUtil.getInstance().isForeground()
 * </pre>
 */
public final class AMLUtil implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "AMLUtil";

    private final ArrayMap<String, Activity> mActivitySet = new ArrayMap<>();

    /**
     * 当前应用上下文对象
     */
    private Application mApplication;
    /**
     * 最后一个可见 Activity 标记
     */
    private String mLastVisibleTag;
    /**
     * 最后一个不可见 Activity 标记
     */
    private String mLastInvisibleTag;
    /**
     * 当前是否在 Debug 模式
     */
    private boolean isDebug;


    /**
     * 使用必须先初始化, 默认情况会读取 Apk 是否在 Debug
     *
     * @param application {@link Application}
     */
    public AMLUtil init(Application application) {
        mApplication = application;
        mApplication.registerActivityLifecycleCallbacks(this);
        // 默认情况会读取 Apk 是否在 Debug
        isDebug = PMSUtil.isSelfDebug(mApplication.getApplicationContext());
        return this;
    }

    private void checkInit() {
        if (mApplication == null) {
            throw new IllegalArgumentException("not use AMLUtil.init(application)");
        }
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * 获取 Application 对象
     */
    public Application getApplication() {
        checkInit();
        return mApplication;
    }

    /**
     * 获取栈顶的 Activity
     */
    public Activity getTopActivity() {
        checkInit();
        return mActivitySet.get(mLastVisibleTag);
    }

    /**
     * 判断当前应用是否处于前台状态, 通过最后一个 Activity 是否时记录的
     */
    public boolean isForeground() {
        checkInit();
        // 如果最后一个可见的 Activity 和最后一个不可见的 Activity 是同一个的话
        if (mLastVisibleTag.equals(mLastInvisibleTag)) {
            return false;
        }
        Activity activity = getTopActivity();
        return activity != null;
    }

    /**
     * 销毁所有的 Activity
     */
    public void finishAllActivities() {
        finishAllActivities((Class<? extends Activity>) null);
    }

    /**
     * 销毁所有的 Activity，除这些 Class 之外的 Activity
     */
    @SafeVarargs
    public final void finishAllActivities(Class<? extends Activity>... classArray) {
        checkInit();
        String[] keys = mActivitySet.keySet().toArray(new String[]{});
        for (String key : keys) {
            Activity activity = mActivitySet.get(key);
            if (activity != null && !activity.isFinishing()) {
                boolean whiteClazz = false;
                if (classArray != null) {
                    for (Class<? extends Activity> clazz : classArray) {
                        if (activity.getClass() == clazz) {
                            whiteClazz = true;
                        }
                    }
                }
                // 如果不是白名单上面的 Activity 就销毁掉
                if (!whiteClazz) {
                    activity.finish();
                    mActivitySet.remove(key);
                }
            }
        }
    }

    /**
     * 获取一个对象的独立无二的标记, 同 object.getName() + Hex(object.hashCode())
     */
    private static String getObjectTag(Object object) {
        // 对象所在的包名 + 对象的内存地址
        return object.getClass().getName() + Integer.toHexString(object.hashCode());
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onCreate", activity.getClass().getSimpleName()));
        }
        mLastVisibleTag = getObjectTag(activity);
        mActivitySet.put(getObjectTag(activity), activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onStart", activity.getClass().getSimpleName()));
        }
        mLastVisibleTag = getObjectTag(activity);
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onResume", activity.getClass().getSimpleName()));
        }
        mLastVisibleTag = getObjectTag(activity);
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onPause", activity.getClass().getSimpleName()));
        }
        mLastInvisibleTag = getObjectTag(activity);
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onStop", activity.getClass().getSimpleName()));
        }
        mLastInvisibleTag = getObjectTag(activity);
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onSaveInstanceState", activity.getClass().getSimpleName()));
        }
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (isDebug) {
            Log.i(TAG, String.format("%s - onDestroy", activity.getClass().getSimpleName()));
        }
        mActivitySet.remove(getObjectTag(activity));
        mLastInvisibleTag = getObjectTag(activity);
        if (getObjectTag(activity).equals(mLastVisibleTag)) {
            // 清除当前标记
            mLastVisibleTag = null;
        }
    }

    public static AMLUtil getInstance() {
        return Instance.instance;
    }

    private AMLUtil() {
    }

    private static class Instance {
        private static final AMLUtil instance = new AMLUtil();
    }
}
