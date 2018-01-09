package com.wangtao.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author : wangtao
 * @date : 2018/1/9 16:20
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.wangtao.mvc")
public class MyMvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();

        resourceViewResolver.setPrefix("/WEB-INF/classes/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }
}
