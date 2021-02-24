package com.sinlov.temp.android.utils;

import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardUtils {

    public static void copy2Clipboard(Context context, String content) {
        content = content.trim();
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }

    public static String paste(Context context) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        return cmb.getText().toString().trim();
    }
}
