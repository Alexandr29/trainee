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
        Pattern pattern;
        Matcher matcher;
        Scanner scan = null;
        double value = 0.0d;
        String stringValeue = null;
        String s = string;

        scan = new Scanner(string);

        if (scan.hasNextDouble()) {
            pattern = Pattern.compile("(\\d+.?\\d+)");
            matcher = pattern.matcher(string);
            if (matcher.find()) {
                stringValeue = matcher.group(1);
            }
        } else {
            throw new IllegalArgumentException();
        }
        if (stringValeue == null) {
            value = 0;
        } else {
            value = Double.parseDouble(stringValeue);
        }

        return value;
    }
    //        double d = Double.valueOf(s);
    //
    //        return d;
    //    }

    public static void main(String[] args) throws IllegalArgumentException {
        StringUtilsImpl stringUtils = new StringUtilsImpl();
        System.out.println(stringUtils.invert("Hello world"));
        System.out.println(stringUtils.compareWords("abcdef", "abcasdfg"));
        try {
            System.out.println(stringUtils.parseDouble("257.456 hello 265.4"));
        } catch (IllegalArgumentException ex) {
            System.out.println("Преобразование невозможно");
            ex.printStackTrace(System.err);
        }

    }

}
