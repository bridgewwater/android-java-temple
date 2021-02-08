package com.sinlov.android.demo.template;

import android.widget.TextView;

import com.demo.android.template.MainActivityAbstract;
import com.demo.android.template.R;

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

/**
 * test {@link MainActivityAbstract}
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
    private ActivityController<MainActivityAbstract> activityController;
    private ActivityScenario<MainActivityAbstract> activityScenario;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        // Create new activity http://robolectric.org/androidx_test/
        activityScenario = ActivityScenario.launch(MainActivityAbstract.class);
        activityScenario.moveToState(Lifecycle.State.CREATED);
        this.activityController = Robolectric.buildActivity(MainActivityAbstract.class).create().start().resume().visible();
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
        this.activityScenario.onActivity(new ActivityScenario.ActivityAction<MainActivityAbstract>() {
            @Override
            public void perform(MainActivityAbstract activity) {
                TextView tvResult = (TextView) activity.findViewById(R.id.tv_main_result);
                assertNotNull(tvResult);
                tvResult.performClick();
                assertEquals(ShadowToast.getTextOfLatestToast(), "Result has copy to clipboard");
            }
        });
//        TextView tvResult = (TextView) this.mainActivity.findViewById(R.id.tv_main_result);
//        assertNotNull(tvResult);
//        tvResult.performClick();
//        assertEquals(ShadowToast.getTextOfLatestToast(), "Result has copy to clipboard");
    }
}