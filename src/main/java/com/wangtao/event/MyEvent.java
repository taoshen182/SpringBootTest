package com.wangtao.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author : wangtao
 * @date : 2018/1/8 16:40
 */

public class MyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;

    }
}
