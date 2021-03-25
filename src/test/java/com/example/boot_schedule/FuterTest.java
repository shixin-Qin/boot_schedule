package com.example.boot_schedule;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FuterTest  extends BootScheduleApplicationTests{

    @Test
    void name() {
        //这里call()方法的重写是采用lambda表达式，没有新建一个Callable接口的实现类
        FutureTask<Integer> task =  new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for(;i < 50;i++) {
                System.out.println(Thread.currentThread().getName() +
                        "  的线程执行体内的循环变量i的值为：" + i);
            }
            //call()方法的返回值
            return i;
        });

        new Thread(task,"有返回值的线程").start();

        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
