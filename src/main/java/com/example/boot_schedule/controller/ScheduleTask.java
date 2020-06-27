package com.example.boot_schedule.controller;

import com.example.boot_schedule.runables.TaskRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/schedule")
public class ScheduleTask {
    private Map<String, ScheduledFuture<?>> taskMap = new HashMap<>();
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @RequestMapping("/add")
    @ResponseBody
    public boolean addTask(String name) {
//        String zhangsanCron = "*/3 * * * * ?";
        String zhangsanCron = "0,10,20,30,40,50 * * * * ?";
        return add(name, zhangsanCron);
    }

    @RequestMapping("/stop")
    @ResponseBody
    public boolean stopTask(String name) {
        return stop(name);
    }

    @RequestMapping("/list")
    @ResponseBody
    public String listTask() {
        return taskMap.keySet().stream().map(name -> name).collect(Collectors.joining(","));
    }

    private boolean add(String name, String cron) {
        if (null != taskMap.get(name)) {
            return false;
        }
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(new TaskRunnable(name), new CronTrigger(cron));
        taskMap.put(name, schedule);
        return true;
    }

    private boolean stop(String name) {
        if (null == taskMap.get(name)) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = taskMap.get(name);
        scheduledFuture.cancel(true);
        taskMap.remove(name);
        return true;
    }
}
