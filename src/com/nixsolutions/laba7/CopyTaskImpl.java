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

            // try {
            // dest.createNewFile();
            // } catch (IOException e1) {
            // throw new IllegalArgumentException(e1);
            // } finally {
            try {
                input.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // }
            throw new IllegalArgumentException(e);
        }

        int b;

        try {
            while ((b = input.read()) != -1) {
                output.write(b);
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

        }return true;

        //        if (source == null) {
        //            throw new IllegalArgumentException();
        //        }
        //        FileChannel input;
        //        try {
        //            input = new FileInputStream(source).getChannel();
        //        } catch (FileNotFoundException e) {
        //            throw new IllegalArgumentException(e);
        //        }
        //        FileChannel output;
        //        try{
        //            output = new FileOutputStream(dest).getChannel();
        //        }catch (FileNotFoundException e){
        //            throw new IllegalArgumentException();
        //        }
        //
        //        try {
        //            output.transferFrom(input,0,input.size());
        //        } catch (IOException e) {
        //            throw new IllegalArgumentException(e);
        //        }
        //
        //        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
        //                FileChannel destChannel = new FileOutputStream(dest)
        //                        .getChannel()) {
        //            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
    }




        //System.out.println(Thread.currentThread().getName() + " execute CopyTask" +" source: " +  source+" " + dest);
        //System.out.println("выполняю");
//        try{
//            for (int i = 0; i < getTryCount(); i++) {
//
//                try (FileChannel sourceChannel = new FileInputStream(source)
//                        .getChannel();
//                        FileChannel destChannel = new FileOutputStream(dest)
//                                .getChannel()) {
//                    destChannel
//                            .transferFrom(sourceChannel, 0, sourceChannel.size());
//                    //tmp = false;
//                    //System.out.println(getTryCount() + "-ая попытка");
//                    break;
//                } catch (Exception e) {
//                    //incTryCount();
//                    e.getCause();
//                    return false;
//
//                }
//            }
//        }catch (Exception e){
//            throw new Exception(e.getCause());
//        }
//        return true;
//    }
}
