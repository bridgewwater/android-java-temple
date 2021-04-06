package com.sinlov.temp.android;

import android.view.View;

/**
 * open init
 *
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
 * Created by sinlov on 2021/4/6.
 */
public abstract class AbsTemplateActivity extends AbstractTemplateTestActivity {
    @Override
    protected boolean beforeSetContentView() {
        return true;
    }

    @Override
    protected View onSetContentView() {
        return null;
    }
}
