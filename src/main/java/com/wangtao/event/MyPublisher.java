package com.wangtao.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author : wangtao
 * @date :2018/1/8 16:45
 */
@Component
public class MyPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publishMsg(String msg) {
        applicationContext.publishEvent(new MyEvent(this, msg));
    }
}
