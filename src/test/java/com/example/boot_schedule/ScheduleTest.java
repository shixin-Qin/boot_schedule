package com.example.boot_schedule;

import com.example.boot_schedule.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduleTest extends BootScheduleApplicationTests {

    @Autowired
    private TestService testService;

  /*  @Autowired
    private ScheduleTask scheduleTask;

    @Test
    void name() {
        scheduleTask.addTask("xxx");
    }*/

    @Test
    void name2() {
        testService.test();
    }
}
