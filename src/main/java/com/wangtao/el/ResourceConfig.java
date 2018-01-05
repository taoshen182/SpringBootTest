package com.wangtao.el;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author : wangtao
 * @date : 2018/1/5 18:04
 */
@Configuration
@ComponentScan("com.wangtao.el")
@PropertySources({
        @PropertySource("classpath:config.properties"),
        @PropertySource("classpath:db.properties")
})
public class ResourceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
