package com.wangtao.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * @author : wangtao
 * @date : 2018/1/17 10:01
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        String status = statusService.getStatus();
        if (StringUtils.isEmptyOrWhitespace(status) || !StringUtils.equals("running", status)) {
            return Health.down().withDetail("ERROR", "Not Running!!!").build();
        }
        return Health.up().build();
    }

    @Autowired
    StatusService statusService;

}
