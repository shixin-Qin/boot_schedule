package com.example.boot_schedule;

import com.example.boot_schedule.service.ReckonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/6/9 15
 */
public class PoolTest extends BootScheduleApplicationTests {
    
    @Autowired
    private ReckonService reckonService;
    
    @Test
    void name1() throws InterruptedException {
        reckonService.testPool();
    }
    
    @Test
    void name2() {
        reckonService.testNormal();
    }
}
