package com.wangtao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : wangtao
 * @date : 2018/1/15 16:44
 */
@Configuration
@EnableJpaRepositories("com.wangtao.security")
public class RepositoryConfig {
}
