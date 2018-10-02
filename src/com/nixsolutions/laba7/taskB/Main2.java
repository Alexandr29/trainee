package com.nixsolutions.laba7.taskB;

import interfaces.task7.executor.SumTask;

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

        TasksStorageImpl tasksStorage = new TasksStorageImpl();
        tasksStorage.add(new CopyTaskImpl(source1, dest1));
        tasksStorage.add(new CopyTaskImpl(source2, dest2));
        tasksStorage.add(new CopyTaskImpl(source3, dest3));
        tasksStorage.add(new CopyTaskImpl(source4, dest4));

        SumTaskImpl sumTask = new SumTaskImpl();
        sumTask.setCount(10);
        sumTask.setMax(123456789);
        tasksStorage.add(sumTask);

        ExecutorImpl executor = new ExecutorImpl();
        executor.setStorage(tasksStorage);
        executor.start();

    }

}
