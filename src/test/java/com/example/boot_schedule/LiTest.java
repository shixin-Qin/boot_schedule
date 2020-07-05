package com.example.boot_schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

public class LiTest extends BootScheduleApplicationTests {
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Test
    void name() {
        GoPo goPo = new GoPo();
        capableBeanFactory.autowireBean(goPo);
        goPo.tGo();
    }

    @Test
    void name2() {
        GoPo goPo2 = new GoPo();
        capableBeanFactory.autowireBean(goPo2);
        goPo2.tGo();
    }
}
