package com.example.boot_schedule;

import com.example.boot_schedule.service.GoService;
import org.springframework.beans.factory.annotation.Autowired;

public class GoPo {

    @Autowired
    private GoService goService;

    public void tGo(){
       goService.go();
       while (true){
           System.out.println(this.toString()+"tttttt");
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
