package com.wangtao.scheduledtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by want on 2018-1-8.
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportTime() {
        System.out.println(dataFormat.format(new Date()));
    }


    @Scheduled(cron = "0 * * * * *")
    public void fixTimeExe() {
        System.out.println("dataFormat = " + dataFormat.format(new Date()));
    }

}
