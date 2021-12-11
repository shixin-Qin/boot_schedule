package com.example.boot_schedule.taskpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class TaskPoolScheduleTest {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostConstruct
    void name() {
        threadPoolTaskScheduler.setPoolSize(4);
        System.out.println("开始时间:"+LocalTime.now().toString());
        for (int i = 0; i < 40; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程:"+ finalI +",执行时间:"+ LocalTime.now().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND,5);
            Date date2 = calendar.getTime();
            threadPoolTaskScheduler.schedule(runnable,date2);
        }
    }
}
