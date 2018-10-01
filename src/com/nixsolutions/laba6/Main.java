package com.nixsolutions.laba6;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.Reader;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Random;

import interfaces.task6.IOUtils;

public class Main {
    public static void main(String[] args) {

        //        Random random = new Random();
        //        Integer val = random.nextInt((int) 12);
        //        BigInteger rrrr = new BigInteger(val.toString());
        //
        //        String reg = ".*[.]{1}.*";
        //
        //        String sssString = System.getProperty("java.io.tmpdir");
        //        boolean b = sssString.matches(reg);
        //
        //        new IOUtilsImpl().copyFile("qwe", System.getProperty("java.io.tmpdir"));
        //
        long t0 = 0;
        long t1 = 0;

        // replaceChars --------------------------------------------

        IOUtils iou = new IOUtilsImpl();

        char[] ca = { 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'a' };
        Reader r = new CharArrayReader(ca);

        Writer w = new CharArrayWriter();

        iou.replaceChars(r, w, "zcn", "ZCN");

        // copyFile ---------------------------------------------------

        String source = "C:\\Users\\zinchenko\\workspace\\ZinchenkoVitaliy\\test\\s.txt";
        String dest = "C:\\Users\\zinchenko\\workspace\\ZinchenkoVitaliy\\test\\d.txt";

        t0 = System.nanoTime();

        iou.copyFile(source, dest);

        t1 = System.nanoTime() - t0;
        System.out.println("for copyFile()         = " + t1 + " nano");

        // copyFileBuffered ---------------------------------------------------

        File sourceFile = new File(source);
        File destFile = new File(dest);

        t0 = System.nanoTime();

        iou.copyFileBuffered(sourceFile, destFile);

        t1 = System.nanoTime() - t0;
        System.out.println("for copyFileBuffered() = " + t1 + " nano");

        // copyFileBuffered ---------------------------------------------------

        t0 = System.nanoTime();

        iou.copyFileBest(source, dest);

        t1 = System.nanoTime() - t0;
        System.out.println("for copyFileBest()     = " + t1 + " nano");

        // findFiles ---------------------------------------------------

        String fileName = "C:\\Users\\zinchenko\\workspace\\ZinchenkoVitaliy\\myFolder";

        String[] files = iou.findFiles(fileName);

        for (String string : files) {
            System.out.println("file:   " + string);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // findFiles ---------------------------------------------------

        String extension = ".java";

        String[] files2 = iou.findFiles(fileName, extension);

        for (String string : files2) {
            System.out.println("file:   " + string);
        }

        System.out.println();
    }
}