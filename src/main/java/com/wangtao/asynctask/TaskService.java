package com.wangtao.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by want on 2018-1-8.
 */
@Service
public class TaskService {

    @Async
    public void testOne(Integer i) throws InterruptedException {
        System.out.println("执行异步任务start   " + i);
        Thread.sleep((long) (Math.random()*10));
        System.out.println("执行异步任务end   " + i);
    }

    @Async
    public void testTwo(Integer i) throws InterruptedException {
        System.out.println("++++执行异步任务start++++   " + (i + 1));
        Thread.sleep((long) (Math.random()*10));
        System.out.println("++++执行异步任务end++++   " + (i + 1));
    }

}
