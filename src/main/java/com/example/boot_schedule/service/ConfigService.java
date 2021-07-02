package com.example.boot_schedule.service;

import com.example.boot_schedule.runables.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ConfigService {
    
    @Transactional
    public void reduce() {
        if(Config.i > 0){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Config.i--;
            System.out.println(Thread.currentThread()+":"+Config.i);
        }
    }
    
}
