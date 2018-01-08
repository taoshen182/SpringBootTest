package com.wangtao.scheduledtask;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by want on 2018-1-8.
 */
@Configuration
@ComponentScan("com.wangtao.scheduledtask")
@EnableScheduling
public class ScheduledConfig {
}
