package com.example.boot_schedule.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/6/9 15
 */
@Service
public class ReckonService {
    
    private int count = 900000000;
    
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 2, TimeUnit.SECONDS,
            new LinkedBlockingQueue(10000),new ThreadPoolExecutor.DiscardPolicy());
    
    public void testNormal(){
        long start = System.currentTimeMillis();
        while (count > 0) {
            count--;
        }
        long end = System.currentTimeMillis();
    
        System.out.println("count为:" + count + ",耗时:" + (end - start) / 1000);
    }
    
    public void testPool() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (count > 0) {
                        count--;
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }
        /*threadPoolExecutor.shutdown();
        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(1000);
        }*/
        while (true){
            Thread.sleep(1000);
            int activeCount = threadPoolExecutor.getActiveCount();
            if(activeCount == 0){
                System.out.println("所有任务都结束了！");
                System.out.println("完成任务数:"+threadPoolExecutor.getCompletedTaskCount());
                break;
            }
        }
        long end = System.currentTimeMillis();
        
        System.out.println("count为:" + count + ",耗时:" + (end - start) / 1000);
    }
    
}
