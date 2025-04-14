package com.sinlov.android.plugin;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void plugin() {
//        Plugin instance = Plugin.getInstance();
//        Assert.assertNotNull(instance);
//    }

    @Test
    public void faker_data() throws Exception {
        // mock
        Faker faker = new Faker(new Locale("zh-CN"));
        // do
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);
        // verify
        Assert.assertNotNull(fullName);
    }
}