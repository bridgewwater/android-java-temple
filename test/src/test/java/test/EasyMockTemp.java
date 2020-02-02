package test;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;

import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * for EasyMock temp
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
@RunWith(PowerMockRunner.class)
public abstract class EasyMockTemp extends TestTemp {

    protected Application mockApp;
    protected Activity mockActivity;
    protected Dialog mockDialog;

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
