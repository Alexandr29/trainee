package com.nixsolutions.laba6;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.Reader;
import java.io.Writer;

import interfaces.task6.IOUtils;

public class Main {
    public static void main(String[] args) {

        //
        long t0;
        long t1;

        // replaceChars --------------------------------------------

        IOUtils iou = new IOUtilsImpl();
        String source = "/home/NIX/asinkevich/java/English.pdf";
        String dest = "/home/NIX/asinkevich/java/English2.pdf";

        //t0 = System.nanoTime();
        //iou.copyFile(source, dest);
        //t1 = System.nanoTime() - t0;
         //System.out.println("for copyFile()         = " + t1 + " nano");

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

        String fileName = "/home/NIX/asinkevich/IdeaProjects/codeConvention/src";
        String[] files = iou.findFiles(fileName);

        for (String string : files) {
            System.out.println("file:   " + string);
        }

        // findFiles ---------------------------------------------------
        String extension = ".java";
        String[] files2 = iou.findFiles(fileName, extension);

        for (String string : files2) {
            System.out.println("file:   " + string);
        }
        System.out.println();


        char[] ca = { 'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r','l','d' };
        Reader r = new CharArrayReader(ca);
        Writer w = new CharArrayWriter();
        iou.replaceChars(r, w, "hel", "HEL");
        System.out.println(w);
    }
}