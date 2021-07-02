package com.example.boot_schedule.runables;

import com.example.boot_schedule.service.ConfigService;

public class ReRunnable implements Runnable {
    
    private ConfigService configService;
    
    public ReRunnable(ConfigService configService) {
        this.configService = configService;
    }
    
    @Override
    public void run() {
        while (true) {
            configService.reduce();
        }
    }
}
