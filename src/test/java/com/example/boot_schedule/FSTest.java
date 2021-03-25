package com.example.boot_schedule;

import com.example.boot_schedule.fs.Child;
import com.example.boot_schedule.fs.Parent;
import org.junit.jupiter.api.Test;

public class FSTest extends BootScheduleApplicationTests{

    @Test
    void name() {
        Parent child = new Child();
        child.say();
    }
}
