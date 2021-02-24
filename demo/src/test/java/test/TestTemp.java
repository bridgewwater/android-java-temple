package test;

import org.junit.After;
import org.junit.Before;

import java.util.Random;

import static java.util.UUID.randomUUID;

/**
 * for test base temp data
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
public abstract class TestTemp {
    protected static final int NUMBER_NEGATIVE_ONE = -1;
    protected static final int NUMBER_ZERO = 0;
    protected static final int NUMBER_ONE = 1;
    protected static final int DENSITY_LDPI = 36;
    protected static final int DENSITY_MDPI = 48;
    protected static final int DENSITY_HDPI = 72;
    protected static final int DENSITY_XHDPI = 96;
    protected static final int DENSITY_XXHDPI = 144;
    protected static final int DENSITY_XXXHDPI = 192;
    protected static final String STRING_EMPTY = "";
    protected static final String STRING_NULL = null;

    protected static final String STRING_UNIQUE = randomUUID().toString();
    protected static final String STRING_UNIQUE2 = randomUUID().toString() + randomUUID().toString();

    protected static final Integer RANDOM_INTEGER = new Random().nextInt();
    protected static final Integer RANDOM_INTEGER_POSITIVE = new Random().nextInt(Integer.SIZE - 1);
    protected static final Long RANDOM_LONG = new Random().nextLong();
    protected static final Double RANDOM_DOUBLE = new Random().nextDouble();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }
}
