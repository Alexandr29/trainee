package com.nixsolutions.laba3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class StringDivImpl implements StringDiv {
    public StringDivImpl() {
    }

    @Override public double div(String s1, String s2) {
        if (s2 == null) {
            throw new NullPointerException();
        }

        if (s2 == "0") {
            throw new ArithmeticException();
        }

        StringUtils stringUtils = new StringUtilsImpl();

        double d1 = stringUtils.parseDouble(s1);
        double d2 = stringUtils.parseDouble(s2);

        if (d2 == 0) {
            throw new IllegalArgumentException();
        }

        return d1 / d2;
    }

    public static void main(String[] args) {
        StringDivImpl stringDiv = new StringDivImpl();
        double x = stringDiv.div("10 hello", "-1 friend");
        System.out.println(x);
    }
}
