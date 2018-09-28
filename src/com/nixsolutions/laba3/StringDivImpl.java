package com.nixsolutions.laba3;

import interfaces.task3.StringDiv;

public class StringDivImpl implements StringDiv {
    public StringDivImpl() {
    }

    @Override public double div(String s, String s1) {
        if (s == null || s1 == null) {
            throw new NullPointerException("String is null");
        }

        StringUtilsImpl sui = new StringUtilsImpl();
        double a = sui.parseDouble(s);
        double b = sui.parseDouble(s1);

        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        return a / b;
    }

    public static void main(String[] args) {
        StringDivImpl stringDiv = new StringDivImpl();
        double x = stringDiv.div("250.9 hello", "10 friend");
        System.out.println(x);
    }
}
