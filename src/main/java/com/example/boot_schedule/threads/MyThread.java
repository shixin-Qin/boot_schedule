package com.example.boot_schedule.threads;

public class MyThread extends Thread{
    @Override
    public synchronized void start() {
        System.out.println("自定义start");
    }

    @Override
    public void run() {
        System.out.println("MyThread run起来");
    }
}
