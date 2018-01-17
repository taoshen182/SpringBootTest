package com.wangtao.actuator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : wangtao
 * @date : 2018/1/17 10:08
 */
@ConfigurationProperties(prefix = "endpoints.status", ignoreUnknownFields = false)
public class StatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware {
    ApplicationContext applicationContext;

//    private String stop;
//    private String run;

    public StatusEndPoint(String id) {

        super(id);
        System.out.println("id = " + id);
//        System.out.println("stop = " + stop);
//        System.out.println("run = " + run);
    }

    @Override
    public String invoke() {
        StatusService status = applicationContext.getBean(StatusService.class);
        return "The Current Status is : " + status.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
