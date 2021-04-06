package com.sinlov.temp.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.sinlov.temp.android.action.TempActivityAction;
import com.sinlov.temp.android.action.TempBundleAction;
import com.sinlov.temp.android.action.TempClickAction;
import com.sinlov.temp.android.action.TempHandlerAction;
import com.sinlov.temp.android.action.TempKeyboardAction;
import com.sinlov.temp.android.action.TempToastAction;

import java.util.Random;

public abstract class AbstractTemplateTestActivity extends AppCompatActivity
        implements TempActivityAction, TempClickAction,
        TempHandlerAction, TempBundleAction, TempKeyboardAction, TempToastAction {

    /**
     * Activity 回调集合
     */
    private SparseArray<OnActivityCallback> mActivityCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.removeCallbacks();
    }

    @Override
    public void finish() {
        // 隐藏软键，避免内存泄漏
        hideKeyboard(getCurrentFocus());
        super.finish();
    }


    protected void initActivity() {
        if (beforeSetContentView()) {
            initLayout();
            initView();
        }
    }

    /**
     * 无论返回啥，都会执行 {@link #initData(Bundle)}
     *
     * @return true 继续响应 {@link #getLayoutId()} or {@link #onSetContentView()} and {@link #initView()}
     */
    protected abstract boolean beforeSetContentView();

    /**
     * 优先通过布局 ID 初始化 onCreate setContentView() {@link AbstractTemplateTestActivity#initLayout()}
     */
    protected abstract int getLayoutId();

    /**
     * 如果 {@link AbstractTemplateTestActivity#getLayoutId()} 小于 1
     * <br/>
     * 不通过布局 ID 初始化 onCreate setContentView() in {@link AbstractTemplateTestActivity#initLayout()}
     * <br/>
     * 使用示例
     * <pre>
     *     Binding.inflate(getLayoutInflater());
     *     return binding.getRoot();
     * </pre>
     *
     * @return view
     */
    protected abstract View onSetContentView();

    /**
     * 初始化控件
     * <br/>
     * after {@link AbstractTemplateTestActivity#getLayoutId()} or {@link AbstractTemplateTestActivity#onSetContentView()}
     */
    protected abstract void initView();

    /**
     * 初始化数据
     * <br/>
     * after {@link AbstractTemplateTestActivity#initView()}
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 初始化布局
     */
    protected void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        } else {
            View contentView = onSetContentView();
            if (contentView == null) {
                throw new NullPointerException("onSetContentView return is null");
            }
            setContentView(contentView);
        }
        initSoftKeyboard();
    }

    /**
     * 初始化软键盘
     */
    protected void initSoftKeyboard() {
        // 点击外部隐藏软键盘，提升用户体验
        getContentView().setOnClickListener(v -> {
            // 隐藏软键，避免内存泄漏
            hideKeyboard(getCurrentFocus());
        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * 和 setContentView 对应的方法
     */
    public ViewGroup getContentView() {
        return findViewById(Window.ID_ANDROID_CONTENT);
    }

    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    /**
     * 如果当前的 Activity（singleTop 启动模式） 被复用时会回调
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 设置为当前的 Intent，避免 Activity 被杀死后重启 Intent 还是最原先的那个
        setIntent(intent);
    }

    /**
     * 跳转
     *
     * @param clazz {@link Activity}
     */
    protected void skip2Activity(Class<?> clazz) {
        skip2Activity(clazz, null);
    }

    /**
     * 带参数跳转
     *
     * @param clazz  {@link Activity}
     * @param bundle {@link Bundle}
     */
    protected void skip2Activity(Class<?> clazz, @Nullable Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        // 隐藏软键，避免内存泄漏
        hideKeyboard(getCurrentFocus());
        // startActivity 最终也会调用 startActivityForResult
        super.startActivityForResult(intent, requestCode, options);
    }

    /**
     * startActivityForResult 优化
     *
     * @param clazz    {@link Activity}
     * @param callback {@link OnActivityCallback}
     */
    public void startActivityForResult(Class<? extends Activity> clazz, OnActivityCallback callback) {
        startActivityForResult(new Intent(this, clazz), null, callback);
    }

    /**
     * startActivityForResult 优化封装
     *
     * @param intent   {@link Intent}
     * @param callback {@link OnActivityCallback}
     */
    public void startActivityForResult(Intent intent, OnActivityCallback callback) {
        startActivityForResult(intent, null, callback);
    }

    /**
     * requestCode 为自动生成，规则为 2 的 16 次方以内 随机
     *
     * @param intent   {@link Intent}
     * @param bundle   {@link Bundle}
     * @param callback {@link OnActivityCallback}
     */
    public void startActivityForResult(Intent intent, @Nullable Bundle bundle, OnActivityCallback callback) {
        if (mActivityCallbacks == null) {
            mActivityCallbacks = new SparseArray<>(1);
        }
        // 请求码必须在 2 的 16 次方以内
        int requestCode = new Random().nextInt((int) Math.pow(2, 16));
        mActivityCallbacks.put(requestCode, callback);
        startActivityForResult(intent, requestCode, bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        OnActivityCallback callback;
        if (mActivityCallbacks != null && (callback = mActivityCallbacks.get(requestCode)) != null) {
            callback.onActivityResult(resultCode, data);
            mActivityCallbacks.remove(requestCode);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}