package com.nixsolutions.laba7;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TasksStorageImpl implements TasksStorage {
    public TasksStorageImpl() {
    }

    private Stack<Task> tasks = new Stack<>();

    @Override public String toString() {
        return "TasksStorageImpl{" + "tasks=" + tasks + '}';
    }

    @Override public void add(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }

        tasks.add(task);
    }

    @Override synchronized public Task get() {

        if (tasks.size() != 0) {
            Task task = tasks.get(0);
            try {
                //  if (task.execute()) {
                //   tasks.remove(0);
                // } else {
                //Task tmp = tasks.get(0);
                //tasks.remove(0);
                //tmp.incTryCount();
                // if (tmp.getTryCount() > 5) {
                if (tasks.size() != 0) {
                    tasks.remove(0);
                    tasks.trimToSize();
                }
                //  } else {
                //tasks.add(tmp);

                //  }

                // }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return task;
        }

        //        Task task = tasks.get(0);
        //        tasks.remove(0);
        //        System.out.println("получил таск:   " + task);
        //        return task;
        return null;
    }

    @Override public int count() {
        return tasks.size();
    }

}
