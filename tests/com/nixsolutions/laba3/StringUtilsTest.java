package com.nixsolutions.laba3;



         import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;
import interfaces.task3.StringUtils;
 import org.junit.Before;
import org.junit.Test;


public class StringUtilsTest {

    private static Class testingClass;

    private StringUtils stringUtils = null;
@Before


    public void before() throws Exception {
         stringUtils = new StringUtilsImpl();

    }
@Test


    public void testInvertNull() {
         try {
             String result = stringUtils.invert(null);
             assertNotNull("for null input should be '' output", result);
             assertEquals("for null input should be '' output", "", result);

        } catch (Exception e) {
             fail("for str == null should return empty string");

        }
    }
    @Test


    public void testInvertClear() {
         String result = stringUtils.invert("");
         assertNotNull("for '' input should be '' output", result);
         assertEquals("for '' input should be '' output", "", result);

    }
@Test

    public void testInvertOdd() {
         String result = stringUtils.invert("12345");
         assertNotNull("result should be not null", result);
         assertEquals("wrong result", "54321", result);

    }
@Test


    public void testInvertEven() {
         String result = stringUtils.invert("1234");
         assertNotNull("result should be not null", result);
         assertEquals("wrong result", "4321", result);

    }
@Test


    public void testCompareWordsANull() {
        try {
             String result = stringUtils.compareWords(null, "1");
             fail("for a=null input should throw NullPointerException");

        } catch (NullPointerException e) {

        } catch (Exception e) {
             fail("for a=null input should throw NullPointerException");

        }
    }
@Test


    public void testCompareWordsBNull() {
         try {
            String result = stringUtils.compareWords("1", null);
            fail("for b=null input should throw NullPointerException");
        } catch (NullPointerException e) {

        } catch (Exception e) {
             fail("for b=null input should throw NullPointerException");

        }
    }
@Test


    public void testCompareWords() {
         String result = stringUtils.compareWords("12345", "789");
         assertNotNull("result should be not null", result);
         assertEquals("wrong result for '12345' and '789'", "12345", result);
          result = stringUtils.compareWords("12345", "135");
         assertNotNull("result should be not null", result);
         assertEquals("wrong result for '12345' and '135'", "24", result);
          result = stringUtils.compareWords("12345", "12345");
         assertNotNull("result should be not null", result);
         assertEquals("wrong result for '12345' and '12345'", "", result);

    }
@Test


    public void testParseDoubleNull() {
         try {
             stringUtils.parseDouble(null);
             fail("for str == null should be throw NullPointerException");

        } catch (NullPointerException e) {

        } catch (Exception e) {
             fail("for str == null should be throw NullPointerException");

        }
    }
@Test


    public void testParseDoubleWrongValue() {
         try {
             stringUtils.parseDouble("qwe");

            fail("for wrong value should be throw IllegalArgumentException");

        } catch (IllegalArgumentException e) {

        } catch (Exception e) {

            fail("for wrong value should be throw IllegalArgumentException");

        }
    }
@Test

    public void testParseDoubleWrongValueDot() {
        try {
             stringUtils.parseDouble("1.23e.11");

            fail("for wrong value should be throw IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            assertNotNull("error cause should be included into the error", e
                    .getCause());
        }
    }
@Test


    public void testParseDoubleGood() {
        assertEquals("Wrong return value", 12563d, stringUtils
                .parseDouble("12563"), 0.000001d);
    }
@Test


    public void testParseDoubleGoodDot() {
        assertEquals("Wrong return value", 1.2563d, stringUtils
                .parseDouble("1.2563"), 0.000001d);
    }
@Test


    public void testParseDoubleGoodTwoValues() {
        assertEquals("Wrong return value", 1.2563d, stringUtils
                .parseDouble("1.2563 1234"), 0.000001d);
    }
@Test


    public void testParseDoubleGoodEMinus() {
        assertEquals("Wrong return value", 0.12563d, stringUtils
                .parseDouble("1.2563e-1"), 0.0000001d);
    }
@Test


    public void testParseDoubleGoodEPlus() throws IllegalArgumentException {
        assertEquals("Wrong return value", 12.563d, stringUtils
                .parseDouble("1.2563e+1"), 0.000001d);
    }

}

