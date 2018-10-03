package com.nixsolutions.laba7;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor, Runnable {

    public ExecutorImpl() {
    }

    private TasksStorage tasksStorage;
    private boolean started;

    @Override public void setStorage(TasksStorage tasksStorage) {

        this.tasksStorage = tasksStorage;
    }

    @Override public TasksStorage getStorage() {
        return tasksStorage;
    }

    @Override public void start() {
        try{
            if (getStorage()==null){
                throw new NullPointerException();
            }

            started = true;
            while (!Thread.interrupted()) {
                if (getStorage().count() != 0) {
                    try {
                        getStorage().get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    stop();
                }
            }
        }catch (IllegalStateException ise){
            ise.getCause();
        }
    }

    @Override public void stop() {
        if (!started) {
            throw new IllegalStateException();
        }
        //System.out.println(Thread.currentThread().getName() + " Закончился");
        Thread.currentThread().interrupt();
        started = false;
    }

    @Override public void run() {
        start();
    }
}
