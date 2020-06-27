package com.example.boot_schedule.runables;

public class TaskRunnable implements Runnable {
    private String name;

    public TaskRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "---动态定时任务运行---");
    }
}
