package com.nixsolutions.laba7;

import interfaces.task7.executor.CopyTask;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyTaskImpl implements CopyTask {

    public CopyTaskImpl() {
    }

    @Override public String toString() {
        return "CopyTaskImpl";
    }

    private int tryCount = 0;
    private String source;
    private String dest;

    public CopyTaskImpl(String source, String dest) {
        this.source = source;
        this.dest = dest;
    }

    @Override public void setSource(String source) {
        //java.lang.NullPointerException - если source == null
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        try {
            this.source = source;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException();
        }

        try {
            BufferedInputStream input = new BufferedInputStream(
                    new FileInputStream(source));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override public void setDest(String dest) {
        if (dest == null) {
            throw new NullPointerException("dest is null");
        }
        this.dest = dest;
    }

    @Override public int getTryCount() {
        return tryCount;
    }

    @Override public void incTryCount() {
        tryCount++;
    }

    @Override synchronized public boolean execute() throws Exception {

        while (getTryCount()<5){
            InputStream input;

            try {
                input = new BufferedInputStream(new FileInputStream(source));
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException(e);
            }

            OutputStream output;

            try {
                output = new BufferedOutputStream(new FileOutputStream(dest));
            } catch (FileNotFoundException e) {
                e.getCause();
                try {
                    input.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                // }
                throw new IllegalArgumentException(e);
            }

            int bytes;

            try {
                while ((bytes = input.read()) != -1) {
                    output.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                incTryCount();
            }

        }return true;
    }

}
