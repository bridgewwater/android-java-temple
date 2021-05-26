package com.sinlov.temp.android.utils.log;

import android.os.Build;

import androidx.annotation.NonNull;


import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

/**
 * 自定义日志打印规则
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
 * Created by sinlov on 2021/5/26.
 */
public final class LoggerPrintTree extends Timber.DebugTree {
    /**
     * TAG 长度限制 Android 7.0 之前
     */
    private static final int MAX_TAG_LENGTH = 23;

    @Override
    protected @NotNull
    String createStackElementTag(@NonNull StackTraceElement element) {
        String tag = "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
        if (tag.length() <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return tag;
        }
        return tag.substring(0, MAX_TAG_LENGTH);
    }
}

