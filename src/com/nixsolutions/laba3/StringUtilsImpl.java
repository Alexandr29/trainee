package com.nixsolutions.laba3;

import interfaces.task3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsImpl implements StringUtils {
    public StringUtilsImpl() {
    }

    static final int NO_OF_CHARS = 256;

    static int[] getCharCountArray(String str) {
        int count[] = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        return count;
    }

    @Override public String invert(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        String str = String.valueOf(stringBuilder.reverse());
        return str;
    }

    @Override public String compareWords(String s, String s1) {
        if (s == null || s1 == null) {
            throw new NullPointerException("String is null");
        }
        int count[] = getCharCountArray(s1);
        int ip_ind = 0, res_ind = 0;

        char arr[] = s.toCharArray();

        while (ip_ind != arr.length) {
            char temp = arr[ip_ind];
            if (count[temp] == 0) {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;
        }
        s = new String(arr);

        return s.substring(0, res_ind);
    }

    @Override public double parseDouble(String string) {
        double result;
        try {
            String[] s1 = string.split(" ");
            if (s1.length > 0) {
                result = Double.parseDouble(s1[0]);
            } else {
                result = Double.parseDouble(string);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal argument", e);
        }
        return result;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        StringUtilsImpl stringUtils = new StringUtilsImpl();
        System.out.println(stringUtils.invert("Hello world"));
        System.out.println(stringUtils.compareWords("abcdef", "abcasdfg"));
        System.out.println(stringUtils.parseDouble("1.23e.11  hello 265.4"));

    }
}


