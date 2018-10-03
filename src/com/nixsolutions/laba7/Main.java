package com.nixsolutions.laba7;

public class Main {

    public static void main(String[] args) {
        Thread namePrinterThread = new NamePrinterThreadImpl("Name2",
                System.out, 100, 10);
        namePrinterThread.start();

        Thread thread = new Thread(
                new NamePrinterRunnableImpl("Name1", System.out, 100, 10));
        thread.start();
    }

}
