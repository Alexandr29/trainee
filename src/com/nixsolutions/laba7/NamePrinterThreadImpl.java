package com.nixsolutions.laba7;

import interfaces.task7.simple.NamePrinterThread;

import java.io.OutputStream;
import java.io.PrintStream;

public class NamePrinterThreadImpl extends NamePrinterThread {
    private String printName;
    private PrintStream printStream;
    private long ms;
    private int count;

    public NamePrinterThreadImpl() {
    }

    public NamePrinterThreadImpl(String printName, PrintStream printStream,
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

    @Override public void setStream(PrintStream stream) {
        if (stream == null) {
            throw new NullPointerException();
        }
        this.printStream = stream;
    }

    @Override public void setInterval(long ms) {
        //java.lang.IllegalArgumentException - если ms <= 0;
        if (ms <= 0) {
            throw new IllegalArgumentException("ms<=0");
        }
        this.ms = ms;
    }

    @Override public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    @Override public void run() {
        for (int i = 0; i < count; i++) {
            printStream.print(printName);
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
