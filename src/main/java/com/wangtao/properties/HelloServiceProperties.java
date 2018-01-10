package com.wangtao.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : wangtao
 * @date : 2018/1/10 14:12
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    //默认值
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
