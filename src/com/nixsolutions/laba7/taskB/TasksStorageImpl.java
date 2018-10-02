package com.nixsolutions.laba7.taskB;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.ArrayList;
import java.util.LinkedList;

public class TasksStorageImpl implements TasksStorage {

    @Override public String toString() {
        return "TasksStorageImpl{" + "tasks=" + tasks + '}';
    }

    public TasksStorageImpl() {
    }

    private LinkedList<Task> tasks = new LinkedList<>();

    @Override public void add(Task task) {
        tasks.add(task);
    }

    @Override public Task get() {
        Task task = tasks.get(0);
        tasks.remove(0);
        System.out.println("получил таск:   " + task);
        return task;
    }

    @Override public int count() {
        return tasks.size();
    }

}
