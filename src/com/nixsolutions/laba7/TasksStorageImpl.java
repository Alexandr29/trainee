package com.nixsolutions.laba7;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class TasksStorageImpl implements TasksStorage {
    public TasksStorageImpl() {
        tasks = new LinkedList<>();
    }

    private Queue<Task> tasks;

    @Override public String toString() {
        return "TasksStorageImpl{" + "tasks=" + tasks + '}';
    }

    @Override public void add(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }synchronized (tasks){
            tasks.offer(task);
        }

    }

    @Override synchronized public Task get() {
        synchronized (tasks){
            return tasks.poll();
        }
    }

    @Override public int count() {
        synchronized (tasks) {
            return tasks.size();
        }

    }

}
