package com.demo.temp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public abstract class AbstractTemplateTestActivity extends AppCompatActivity {

    protected String TAG;

    private long testTimeUse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName().replace("Activity", "");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        processLogic(savedInstanceState);
    }

    /**
     * process logic and resumes states etc.
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected abstract void processLogic(Bundle savedInstanceState);

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
        Toast.makeText(this.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int id) {
        Toast.makeText(this.getApplicationContext(), id, Toast.LENGTH_SHORT).show();
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