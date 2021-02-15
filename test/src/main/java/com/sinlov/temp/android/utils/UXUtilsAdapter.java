package com.sinlov.temp.android.utils;

import android.app.ProgressDialog;

public abstract class UXUtilsAdapter {
    private boolean isLock;
    private ProgressDialog pd;

    public boolean isLock() {
        return isLock;
    }

    public void setPd(ProgressDialog pd) {
        this.pd = pd;
    }

    public void unLock() {
        this.isLock = false;
        if (pd != null && pd.isShowing()) {
            pd.hide();
        }
    }

    public void lock() {
        this.isLock = true;
    }

    public abstract void doProgressDialog(ProgressDialog pd);
}
