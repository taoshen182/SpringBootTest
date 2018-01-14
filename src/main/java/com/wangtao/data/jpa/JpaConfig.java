package com.wangtao.data.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;

/**
 * Created by want on 2018-1-13.
 */
@Configuration
@EnableJpaRepositories("com.wangtao.data.jpa")
public class JpaConfig {
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        return null;
//    }

    //DataSource

    //PlatformTransactionManager
}
