package com.sinlov.temp.android.utils.widget;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import test.EasyMockTemp;

import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.expectLastCall;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import static org.powermock.api.support.SuppressCode.suppressConstructor;

/**
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
@PrepareForTest(UXUtils.class)
public class UxUtilsTest extends EasyMockTemp {
    private UXUtils mockSingleton;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mockApp = createMock(Application.class);
        mockActivity = createMock(Activity.class);
        mockDialog = createMock(Dialog.class);

        suppressConstructor(UXUtils.class);
        mockStatic(UXUtils.class);

        mockSingleton = createMock(UXUtils.class);
        assertNotNull(mockSingleton);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testFastRequest() {
        expect(UXUtils.fastRequest()).andReturn(false).anyTimes();
        replay(UXUtils.class);
        replay(mockSingleton);
        replayAll(mockActivity);
        verifyAll();
    }

    @Test
    public void testDialog() {
        mockDialog.setOnCancelListener(anyObject(DialogInterface.OnCancelListener.class));
        expectLastCall().once();

        mockDialog.show();
        expectLastCall().once();

        replayAll(mockActivity, mockDialog);
//        verifyAll();
    }
}
