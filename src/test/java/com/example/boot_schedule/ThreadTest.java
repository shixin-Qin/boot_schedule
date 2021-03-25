package com.example.boot_schedule;

import com.example.boot_schedule.threads.MyThread;
import org.junit.jupiter.api.Test;

public class ThreadTest extends BootScheduleApplicationTests {

    @Test
    void name() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
