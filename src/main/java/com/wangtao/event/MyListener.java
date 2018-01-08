package com.wangtao.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static com.wangtao.study.pojo.UserSexEnum.m;

/**
 * @author : wangtao
 * @date : 2018/1/8 16:42
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        String msg = event.getMsg();
        System.out.println("我接受到了消息：" + msg);
    }
}
