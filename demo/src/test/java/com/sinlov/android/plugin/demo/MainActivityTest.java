package com.sinlov.android.plugin.demo;

import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowToast;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import test.RoboTemp;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * test {@link MainTempActivityAbstract}
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
    //    private MainActivityAbstract mainActivity;
    private ActivityController<MainTempActivityAbstract> activityController;
    private ActivityScenario<MainTempActivityAbstract> activityScenario;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        // Create new activity http://robolectric.org/androidx_test/
        activityScenario = ActivityScenario.launch(MainTempActivityAbstract.class);
        activityScenario.moveToState(Lifecycle.State.CREATED);
        this.activityController = Robolectric.buildActivity(MainTempActivityAbstract.class).create().start().resume().visible();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        // Destroy activity
        this.activityScenario.moveToState(Lifecycle.State.DESTROYED);
    }

    @Test
    public void testOnCreateNotNull() {
        assertNotNull(activityScenario);
        assertNotNull(activityController);
    }

    @Test
    public void testLifeCycleResume() {
        this.activityController.pause().stop().destroy();
    }

    @Test
    public void testResultClickAndToast() {
        this.activityScenario.onActivity(new ActivityScenario.ActivityAction<MainTempActivityAbstract>() {
            @Override
            public void perform(MainTempActivityAbstract activity) {
                TextView tvResult = activity.findViewById(R.id.tv_result);
                assertNotNull(tvResult);
                tvResult.performClick();
                // data-bing can ot test
                assertNull(ShadowToast.getTextOfLatestToast());
//                assertEquals("Result has copy to clipboard", ShadowToast.getTextOfLatestToast());
            }
        });
//        TextView tvResult = (TextView) this.mainActivity.findViewById(R.id.tv_main_result);
//        assertNotNull(tvResult);
//        tvResult.performClick();
//        assertEquals(ShadowToast.getTextOfLatestToast(), "Result has copy to clipboard");
    }
}