package com.wangtao.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by want on 2018-1-8.
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    ListService getWin(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    ListService getLinux(){
        return new LinuxListService();
    }
}
