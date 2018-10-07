package com.nixsolutions.laba7;

import interfaces.task7.executor.Executor;

public class Main2 {

    public static void main(String[] args) throws Exception {
        String source1 = "/home/NIX/asinkevich/java/forCopy/English1.pdf";
        String source2 = "/home/NIX/asinkevich/java/forCopy/English2.pdf";
        String source3 = "/home/NIX/asinkevich/java/forCopy/English3.pdf";
        String source4 = "/home/NIX/asinkevich/java/forCopy/English4.pdf";
        String dest1 = "/home/NIX/asinkevich/java/forCopy/1copy.pdf";
        String dest2 = "/home/NIX/asinkevich/java/forCopy/2copy.pdf";
        String dest3 = "/home/NIX/asinkevich/java/forCopy/3copy.pdf";
        String dest4 = "/home/NIX/asinkevich/java/forCopy/4copy.pdf";

        SumTaskImpl sumTask = new SumTaskImpl(1);
        SumTaskImpl sumTask2 = new SumTaskImpl(20);
        SumTaskImpl sumTask3 = new SumTaskImpl(20);
        sumTask.setCount(100);

        TasksStorageImpl tasksStorage = new TasksStorageImpl();
        CopyTaskImpl copyTask = new CopyTaskImpl();
        copyTask.incTryCount();
        copyTask.setSource(source1);
        copyTask.setDest(dest1);

        tasksStorage.add(copyTask);

        tasksStorage.add(new CopyTaskImpl(source1, dest1));
        tasksStorage.add(sumTask);
        tasksStorage.add(new CopyTaskImpl(source2, dest2));
        tasksStorage.add(sumTask2);
        tasksStorage.add(new CopyTaskImpl(source3, dest3));
        tasksStorage.add(sumTask3);
        tasksStorage.add(new CopyTaskImpl(source4, dest4));

        Executor executor1 = new ExecutorImpl();
        Executor executor2 = new ExecutorImpl();
        Executor executor3 = new ExecutorImpl();

        executor1.setStorage(tasksStorage);
        executor2.setStorage(tasksStorage);
        executor3.setStorage(tasksStorage);

        //System.out.println(Thread.currentThread().getName());

        Thread thread1 = (Thread) executor1;
        Thread thread2 = (Thread) executor2;
        Thread thread3 = (Thread) executor3;

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
