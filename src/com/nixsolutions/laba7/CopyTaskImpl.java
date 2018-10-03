package com.nixsolutions.laba7;

import interfaces.task7.executor.CopyTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyTaskImpl implements CopyTask {

    public CopyTaskImpl() {
    }

    @Override public String toString() {
        return "CopyTaskImpl";
    }

    private int tryCount = 1;
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

    @Override synchronized public boolean execute() throws Exception {
        //System.out.println(Thread.currentThread().getName() + " execute CopyTask" +" source: " +  source+" " + dest);
        //System.out.println("выполняю");
        try{
            for (int i = 0; i < getTryCount(); i++) {

                try (FileChannel sourceChannel = new FileInputStream(source)
                        .getChannel();
                        FileChannel destChannel = new FileOutputStream(dest)
                                .getChannel()) {
                    destChannel
                            .transferFrom(sourceChannel, 0, sourceChannel.size());
                    //tmp = false;
                    //System.out.println(getTryCount() + "-ая попытка");
                    break;
                } catch (Exception e) {
                    //incTryCount();
                    e.getCause();
                    return false;

                }
            }
        }catch (Exception e){
            throw new Exception(e.getCause());
        }
        return true;
    }
}
