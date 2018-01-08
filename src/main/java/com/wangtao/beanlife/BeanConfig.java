package com.wangtao.beanlife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangtao
 * @date : 2018/1/8 15:00
 */
@Configuration
@ComponentScan("com.wangtao.beanlife")
public class BeanConfig {
    @Bean(initMethod = "initTheBean", destroyMethod = "destroyBean")
    public BeanLifeService getBeanService() {
        return new BeanLifeService();
    }
}
