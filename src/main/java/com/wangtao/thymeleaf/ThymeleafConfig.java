package com.wangtao.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

/**
 * @author : wangtao
 * @date : 2018/1/10 16:09
 * 系统自动配置 已经做好了，不需要手动编写了
 */
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.wangtao.thymeleaf")
public class ThymeleafConfig {

    @Bean
    public DefaultTemplateResolver templateViewResolver() {
        DefaultTemplateResolver resolver = new DefaultTemplateResolver();
//        resolver.setPrefix("/WEB-INF/classes/views");
        resolver.setTemplateMode(TemplateMode.HTML);
        System.out.println("ThymeleafConfig templateViewResolver ... " + resolver);
        return resolver;
    }

    //模板引擎
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateViewResolver());
        engine.addDialect(new SpringSecurityDialect());
        return engine;
    }


    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }
}
