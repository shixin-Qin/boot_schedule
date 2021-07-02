package com.example.boot_schedule;

import com.example.boot_schedule.runables.ReRunnable;
import com.example.boot_schedule.service.ConfigService;
import com.example.boot_schedule.threads.MyThread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ThreadTest extends BootScheduleApplicationTests {
    
    @Autowired
    private ConfigService configService;

    @Test
    void name() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
    
    @Test
    void name2() {
    
        for (int i = 0; i < 30; i++) {
            ReRunnable reRunnable = new ReRunnable(configService);
            new Thread(reRunnable).start();
        }
    
        try {
            Thread.sleep(1000*60*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
