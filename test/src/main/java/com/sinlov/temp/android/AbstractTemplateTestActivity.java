package com.sinlov.temp.android;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.hjq.toast.ToastUtils;

public abstract class AbstractTemplateTestActivity extends AppCompatActivity {

    protected String TAG;

    private long testTimeUse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName().replace("Activity", "");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        onProcessLogic(savedInstanceState);
        setContentView(onSetContentView());
        onCreateBindView();
    }

    /**
     * process logic and resumes states by savedInstanceState.
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected abstract void onProcessLogic(Bundle savedInstanceState);

    /**
     * for onCreate setContentView()
     *
     * @return view
     */
    protected abstract View onSetContentView();

    /**
     * after setContentView can bind view
     */
    protected abstract void onCreateBindView();

    /**
     * @param id   widget id
     * @param <VT> View
     * @return extends {@link View}
     */
    @SuppressWarnings("unchecked")
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) findViewById(id);
    }

    protected void showToast(String text) {
        if (TextUtils.isEmpty(text)) {
            text = "nil";
        }

        ToastUtils.setGravity(Gravity.BOTTOM, 0, 64);
        ToastUtils.show(text);
//        Toast.makeText(this.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int id) {
        ToastUtils.setGravity(Gravity.BOTTOM, 0, 64);
        ToastUtils.show(id);
//        Toast.makeText(this.getApplicationContext(), id, Toast.LENGTH_SHORT).show();
    }

    protected void skip2Activity(Class<?> cls) {
        skip2Activity(cls, null);
    }

    protected void skip2Activity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(AbstractTemplateTestActivity.this, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void testTimeUseStart() {
        testTimeUse = System.currentTimeMillis();
    }

    protected long testTimeUseEnd() {
        long useTime = System.currentTimeMillis() - testTimeUse;
        Log.d(TAG, "testTimeUse: " + useTime);
        return useTime;
    }
}