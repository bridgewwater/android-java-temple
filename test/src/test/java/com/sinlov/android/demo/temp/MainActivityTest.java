package com.sinlov.android.demo.temp;

import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowToast;

import test.RoboTemp;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * test {@link MainActivity}
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
 * Created by sinlov on 17/8/17.
 */
public class MainActivityTest extends RoboTemp {
    private MainActivity mainActivity;
    private ActivityController<MainActivity> activityControlle;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        // Create new activity
        this.mainActivity = Robolectric.setupActivity(MainActivity.class);
        this.activityControlle = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        // Destroy activity
        this.mainActivity.finish();
    }

    @Test
    public void testOnCreateNotNull() {
        assertNotNull(mainActivity);
        assertNotNull(activityControlle);
    }

    @Test
    public void testLifeCycleResume() {
        this.activityControlle.pause().stop().destroy();
    }

    @Test
    public void testResultClickAndToast() {
        TextView tvResult = (TextView) this.mainActivity.findViewById(R.id.tv_main_result);
        assertNotNull(tvResult);
        tvResult.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(), "Result has copy to clipboard");
    }
}