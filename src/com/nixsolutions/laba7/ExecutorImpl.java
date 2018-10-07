package com.nixsolutions.laba7;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

    private boolean stopped;

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
        if (started) {
            throw new IllegalStateException();
        }
        if (getStorage() == null) {
            throw new NullPointerException();
        }

        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    while (!stopped) {
                        Task task = tasksStorage.get();
                        if (task != null) {
                            task.incTryCount();
                            try {
                                if (!task.execute()) {
                                    returnTask(task);
                                }
                                // getStorage().get();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            stop();
                        }
                    }
                } catch (IllegalStateException ise) {
                    ise.getCause();
                }

            }
        });
        thread.start();
        started = true;

    }

    private void returnTask(Task task) {
        int count = task.getTryCount();
        if (count <= 5) {
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
