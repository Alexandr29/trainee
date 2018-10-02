package com.nixsolutions.laba7.taskB;

import interfaces.task7.executor.CopyTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyTaskImpl implements CopyTask {
    @Override public String toString() {
        return "CopyTaskImpl";
    }

    private int tryCount = 1;
    private String source;
    private String dest;

    public CopyTaskImpl() {
    }

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
            ex.getCause();
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

    @Override public boolean execute() throws Exception {
        //System.out.println("выполняю");
        for (int i = 0; i < getTryCount(); i++) {

            try (FileChannel sourceChannel = new FileInputStream(source)
                    .getChannel();
                    FileChannel destChannel = new FileOutputStream(dest)
                            .getChannel()) {
                destChannel
                        .transferFrom(sourceChannel, 0, sourceChannel.size());
                //tmp = false;
                System.out.println(i + 1 + "-ая попытка");
                break;
            } catch (IOException e) {
                //incTryCount();
                e.printStackTrace();
            }
        }
        return true;
    }
}
