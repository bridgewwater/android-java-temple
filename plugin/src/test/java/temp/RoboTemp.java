package temp;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;

import com.sinlov.android.plugin.TestMockApplication;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.robolectric.Robolectric.flushBackgroundThreadScheduler;
import static org.robolectric.Robolectric.flushForegroundThreadScheduler;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static org.robolectric.shadows.ShadowLooper.runUiThreadTasksIncludingDelayedTasks;

/**
 * for android Robolectric Test com.sinlov.android.plugin
 * <br/>
 * you can change Config as new application or sdk
 * <br/>
 * TestMockApplication can extends your biz application
 * <br/>
 * you unit test-case extends RoboTemp then run as ${moduleDir}
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
 * Created by sinlov on 20/8/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(
        application = TestMockApplication.class,
        sdk = Build.VERSION_CODES.O,
        manifest = Config.NONE
)
public abstract class RoboTemp extends TestTemp {

    /**
     * Android Related app context
     */
    protected static final Context ctx_app = ApplicationProvider.getApplicationContext();
    /**
     * application mock
     */
    protected static final Application app = ApplicationProvider.getApplicationContext();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * finish Unit Test do threads free
     */
    protected void freeThreads() {
        runBackgroundTasks();
        flushForegroundThreadScheduler();
        flushBackgroundThreadScheduler();
        runUiThreadTasksIncludingDelayedTasks();
    }
}
