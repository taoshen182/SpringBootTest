package com.wangtao.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * @author : wangtao
 * @date : 2018/1/10 17:31
 * 可以添加指定路径对应的页面
 * 注解配置的不受影响
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/bbb").setViewName("test");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/chat").setViewName("chat");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/action").setViewName("angulartest");
        registry.addViewController("/view1").setViewName("view1");
        registry.addViewController("/view2").setViewName("view2");
    }

}
