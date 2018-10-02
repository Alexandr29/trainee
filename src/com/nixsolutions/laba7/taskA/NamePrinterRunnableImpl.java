package com.nixsolutions.laba7.taskA;

import interfaces.task7.simple.NamePrinterRunnable;

import java.io.PrintStream;

public class NamePrinterRunnableImpl implements NamePrinterRunnable {

    private String printName;
    private PrintStream printStream;
    private long ms;
    private int count;

    public NamePrinterRunnableImpl() {
    }

    public NamePrinterRunnableImpl(String printName, PrintStream printStream,
            long ms, int count) {
        this.printName = printName;
        this.printStream = printStream;
        this.ms = ms;
        this.count = count;
    }

    @Override public void setPrintName(String name) {
        if (name == null) {
            throw new NullPointerException("");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.printName = name;
    }

    @Override public void setStream(PrintStream printStream) {
        if (printStream == null) {
            throw new NullPointerException();
        }
        this.printStream = printStream;
    }

    @Override public void setInterval(long ms) {
        this.ms = ms;
        //java.lang.IllegalArgumentException - если ms <= 0;
        if (ms <= 0) {
            throw new IllegalArgumentException("ms<=0");
        }
    }

    @Override public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    @Override public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(printName);
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
