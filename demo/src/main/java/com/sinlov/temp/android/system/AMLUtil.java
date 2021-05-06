package com.sinlov.temp.android.system;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;

/**
 * Activity Lifecycle management
 * <br/>
 * use at Application {@link Application#onCreate()} to init
 * <pre>
 *        // Activity stack management init, will open log which apk debuggable status is true
 *         boolean isDebug = AMLUtil.getInstance()
 *                 .init(application)
 *                 .isDebug();
 *        // can force close Debug
 *        AMLUtil.getInstance()
 *                 .init(application)
 *                 .setDebug(false);
 * </pre>
 * function
 * <pre>
 *        // safe way to get application
 *        AMLUtil.getInstance().getApplication();
 *        // get top Activity
 *        AMLUtil.getInstance().getTopActivity()
 *        // memory optimization, destroy all activity
 *        AMLUtil.getInstance().finishAllActivities();
 *        // memory optimization, destroy all activity except LoginActivity.class
 *        AMLUtil.getInstance().finishAllActivities(LoginActivity.class);
 *        // Determines whether the current application is in the foreground
 *        AMLUtil.getInstance().isForeground()
 * </pre>
 */
public final class AMLUtil implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "AMLUtil";

    private final ArrayMap<String, Activity> mActivitySet = new ArrayMap<>();

    /**
     * current application
     */
    private Application mApplication;
    /**
     * tag of last Visible Activity
     */
    private String mLastVisibleTag;
    /**
     * tag of last Invisible Activity
     */
    private String mLastInvisibleTag;
    /**
     * flag of AMLUtil debug
     */
    private boolean isDebug;


    /**
     * must init!. By default, it reads whether APK is DEBUG
     *
     * @param application {@link Application}
     */
    public AMLUtil init(Application application) {
        mApplication = application;
        mApplication.registerActivityLifecycleCallbacks(this);
        // By default, it reads whether APK is DEBUG
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
     * get current Application
     */
    public Application getApplication() {
        checkInit();
        return mApplication;
    }

    /**
     * get top Activity of visible
     */
    public Activity getTopActivity() {
        checkInit();
        return mActivitySet.get(mLastVisibleTag);
    }

    /**
     * Determining whether the current application is in the foreground by recording the last visible activity
     */
    public boolean isForeground() {
        checkInit();
        // If the last visible activity is the same as the last invisible activity
        if (mLastVisibleTag.equals(mLastInvisibleTag)) {
            return false;
        }
        Activity activity = getTopActivity();
        return activity != null;
    }

    /**
     * destroy all activity
     */
    public void finishAllActivities() {
        finishAllActivities((Class<? extends Activity>) null);
    }

    /**
     * destroy all activity except classArray array
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
                // If the activity is not on the whitelist, destroy it
                if (!whiteClazz) {
                    activity.finish();
                    mActivitySet.remove(key);
                }
            }
        }
    }

    /**
     * Gets a unique token for an object, as: object.getName() + Hex(object.hashCode())
     */
    private static String getObjectTag(Object object) {
        // The class full name + the memory address of hashcode
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
            // clear the current flag
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
