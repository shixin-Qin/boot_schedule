package com.example.boot_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.LocalDateTime;

public class TaskPoolScheduleTest extends BootScheduleApplicationTests{

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Test
    void name() {
        for (int i = 0; i < 40; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程:"+ finalI +",执行时间:"+ LocalDateTime.now().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoolTaskScheduler.execute(runnable,5000);
        }
    }
}
