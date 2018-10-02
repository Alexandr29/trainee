package com.nixsolutions.laba7.taskB;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

    public ExecutorImpl() {
    }

    private TasksStorage tasksStorage;
    private boolean started;
    private boolean stoped;

    @Override public void setStorage(TasksStorage tasksStorage) {

        this.tasksStorage = tasksStorage;
    }

    @Override public TasksStorage getStorage() {
        return tasksStorage;
    }

    @Override public void start() {
        started = true;
        while (true) {
            if (getStorage().count() != 0) {
                try {
                    getStorage().get().execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override public void stop() {
        if (!started) {
            throw new IllegalStateException();
        }
        stoped = true;
        started = false;
    }
}
