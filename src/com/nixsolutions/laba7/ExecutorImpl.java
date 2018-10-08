package com.nixsolutions.laba7;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.concurrent.TimeUnit;

public class ExecutorImpl implements Executor {
    private boolean started = false;
    private boolean stopped = false;

    public ExecutorImpl() {
    }

    private TasksStorage tasksStorage;

    @Override public void setStorage(TasksStorage tasksStorage) {

        this.tasksStorage = tasksStorage;
    }

    @Override public TasksStorage getStorage() {
        return tasksStorage;
    }

    @Override public void start() {
        if (getStorage() == null) {
            throw new NullPointerException();
        }
        if (started) {
            throw new IllegalStateException();
        }
        started = true;
        Thread thread = new Thread(() -> {
            while (started) {
                Task task = tasksStorage.get();
                try {
                    if (task != null) {
                        if (!task.execute()) {
                            returnTask(task);
                        }
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (Exception e) {
                    returnTask(task);
                }
            }
        });
        thread.start();
    }


    private void returnTask(Task task) {
        int count = task.getTryCount();
        if (count < 5) {
            tasksStorage.add(task);
            System.out.println("put back " + Thread.currentThread().getName());
        }
    }

    @Override public void stop() {

        if (!started) {
            throw new IllegalStateException();
        }
        //System.out.println(Thread.currentThread().getName() + " Закончился");
        Thread.currentThread().interrupt();
        started = false;
        stopped = true;
    }

    //    @Override public void run() {
    //        start();
    //    }
}
