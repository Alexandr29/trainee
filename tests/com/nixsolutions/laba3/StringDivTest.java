package com.nixsolutions.laba3;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import interfaces.task3.StringDiv;

import org.junit.Before;
import org.junit.Test;

public class StringDivTest {
    private static Class testingClass;

    private StringDiv stringDiv = null;

    @Before public void before() throws Exception {
        stringDiv = new StringDivImpl();
    }

    @Test public void testDivANull() {
        try {
            stringDiv.div(null, "1");
            fail("function should throw NullPointerException if a == null");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("function should throw NullPointerException if a == null");
        }
    }

    @Test public void testDivBNull() {
        try {
            stringDiv.div("1", null);
            fail("function should throw NullPointerException if b == null");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("function should throw NullPointerException if b == null");
        }
    }

    @Test public void testDivAWrongValue() {
        try {
            stringDiv.div("3q1w2e", "1");
            fail("'a' can not be wrong, "
                    + "function should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotNull("error cause should be included into the error",
                    e.getCause());
        } catch (Exception e) {
            fail("'a' can not be wrong, "
                    + "function should throw IllegalArgumentException");
        }
    }

    @Test public void testDivBWrongValue() {
        try {
            stringDiv.div("1", "1q2we");
            fail("'b' can not be wrong, "
                    + "function should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotNull("error cause should be included into the error",
                    e.getCause());
        } catch (Exception e) {
            fail("'b' can not be wrong, "
                    + "function should throw IllegalArgumentException");
        }
    }

    @Test public void testDivDivisorZero() {
        try {
            stringDiv.div("1", "0");
            fail("divisor can not be 0, "
                    + "function should throw ArithmeticException");
        } catch (ArithmeticException e) {
        } catch (Exception e) {
            fail("divisor can not be 0, "
                    + "function should throw ArithmeticException");
        }
    }

    @Test public void testDivGood() throws Exception {
        assertEquals("Wrong return value", 1.2563d,
                stringDiv.div("2.9711495", "2.365"), 0.000001d);
    }

    @Test public void testDivGoodE() throws Exception {
        assertEquals("Wrong return value", 1.2563d,
                stringDiv.div("297.11495e-2", "0.2365e+1"), 0.000001d);
    }
}
