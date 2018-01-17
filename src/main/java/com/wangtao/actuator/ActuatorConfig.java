package com.wangtao.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangtao
 * @date : 2018/1/17 10:13
 */
@Configuration
public class ActuatorConfig {
    @Bean
    public Endpoint<String> stringEndpoint() {
        Endpoint<String> stringEndpoint = new StatusEndPoint("wangtao");
        return stringEndpoint;
    }
}
