package com.sinlov.temp.android.utils;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public final class ClipboardUtils {

    public static void copy2Clipboard(@NonNull Context context, @NonNull String content) {
        content = content.trim();
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(content.trim(), content.trim());
        cmb.setPrimaryClip(clipData);
    }

    public static CharSequence item(@NonNull Context context, @IntRange(from = 0, to = 10) int count) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData primaryClip = cmb.getPrimaryClip();
        if (primaryClip == null) {
            return "";
        }
        if (primaryClip.getItemCount() < count) {
            return "";
        }
        return primaryClip.getItemAt(count).getText();
    }

    public static String label(@NonNull Context context) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData primaryClip = cmb.getPrimaryClip();
        if (primaryClip == null) {
            return "";
        }
        ClipDescription description = primaryClip.getDescription();
        if (description == null) {
            return "";
        }
        CharSequence label = description.getLabel();
        if (label == null) {
            return "";
        }
        return label.toString();
    }

    private ClipboardUtils() {
    }
}
