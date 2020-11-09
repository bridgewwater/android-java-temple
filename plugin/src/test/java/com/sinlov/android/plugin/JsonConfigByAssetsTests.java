package com.sinlov.android.plugin;

import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

import temp.RoboTemp;
import temp.utils.AssetsFileUtils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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
 * Created by sinlov on 20/8/17.
 */
public class JsonConfigByAssetsTests extends RoboTemp {

    private String testJson;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        testJson = AssetsFileUtils.readJson(app, new File("json", "test.json").toString());
    }

    @Test
    public void testReadConfig() throws Exception {
        // mock
        assertNotNull(testJson);
        System.out.println("testJson = " + testJson);
        // do
        JSONObject jsonObject = new JSONObject(testJson);
        assertNotNull(jsonObject);
        String name = jsonObject.getString("name");
        // verify
        assertEquals("sinlov", name);
        System.out.println("name = " + name);
    }
}
