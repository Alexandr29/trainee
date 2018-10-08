package com.nixsolutions.laba7;

import interfaces.task7.simple.NamePrinterRunnable;
import interfaces.task7.simple.NamePrinterThread;

public class Main {

    public static void main(String[] args) {

        NamePrinterThread sub = new NamePrinterThreadImpl();
        sub.setCount(10);
        sub.setInterval(5000);
        sub.setPrintName("First");
        sub.setStream(System.out);
        sub.start();

        NamePrinterRunnable runnable = new NamePrinterRunnableImpl();
        runnable.setCount(20);
        runnable.setInterval(4000);
        runnable.setPrintName("Second");
        runnable.setStream(System.err);
        Thread secondThread = new Thread(runnable);
        secondThread.start();


        //        Thread namePrinterThread = new NamePrinterThreadImpl("Name2",
//                System.out, 100, 10);
//        namePrinterThread.start();
//
//        Thread thread = new Thread(
//                new NamePrinterRunnableImpl("Name1", System.out, 100, 10));
//        thread.start();
    }

}
